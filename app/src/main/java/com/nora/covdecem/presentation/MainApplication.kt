package com.nora.covdecem.presentation

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import androidx.room.Room
import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate
import com.nora.covdecem.BuildConfig
import com.nora.covdecem.data.database.db.AppDatabase
import com.nora.covdecem.data.network.service.NetworkManager
import com.nora.covdecem.data.repository.CaseRepositoryImpl
import com.nora.covdecem.domain.repository.CaseRepository
import com.nora.covdecem.presentation.cases.CaseDataViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber
import java.util.*

class MainApplication : Application() {

    private val localizationDelegate = LocalizationApplicationDelegate()

    override fun attachBaseContext(base: Context) {
        localizationDelegate.setDefaultLanguage(base, Locale.ENGLISH)
        super.attachBaseContext(localizationDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localizationDelegate.onConfigurationChanged(this)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(baseContext, super.getResources())
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initKoin()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initKoin() {
        val networkModule = module {
            single { NetworkManager().requestCovApiService() }
        }
        val databaseModule = module {
            single {
                Room.databaseBuilder(
                    androidApplication(),
                    AppDatabase::class.java,
                    "CASE_DATABASE"
                ).build()
            }
        }
        val daoModule = module {
            single { get<AppDatabase>().caseDao() }
        }
        val repositoryModule = module {
            single<CaseRepository> { CaseRepositoryImpl(get(), get()) }
        }
        val viewModelModule = module {
            viewModel { CaseDataViewModel(get(), androidApplication()) }
        }
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(listOf(networkModule, databaseModule, daoModule, repositoryModule, viewModelModule))
        }
    }
}