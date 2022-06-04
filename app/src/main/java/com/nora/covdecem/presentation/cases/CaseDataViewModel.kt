package com.nora.covdecem.presentation.cases

import android.app.Application
import androidx.lifecycle.*
import com.nora.covdecem.R
import com.nora.covdecem.domain.model.Case
import com.nora.covdecem.domain.repository.CaseRepository
import com.nora.covdecem.presentation.utils.UpdateStatus
import kotlinx.coroutines.launch
import java.lang.Exception

class CaseDataViewModel(private val caseRepository: CaseRepository, application: Application) :
    AndroidViewModel(application) {

    private val _covData = MutableLiveData<Case>()
    val covData: LiveData<Case> = _covData

    private val _refreshData = MutableLiveData<Boolean>()
    val refreshData: LiveData<Boolean> = _refreshData

    val displayPlusNewConfirmed = Transformations.map(covData) { confirmed ->
        when (confirmed.newConfirmed) {
            zero -> application.applicationContext.getString(
                R.string.text_label_placeholder
            )
            else -> application.applicationContext.getString(
                R.string.text_label_display_new_case_number,
                confirmed.newConfirmed
            )
        }
    }

    val displayPlusNewDeaths = Transformations.map(covData) { deaths ->
        when (deaths.newConfirmed) {
            zero -> application.applicationContext.getString(
                R.string.text_label_placeholder
            )
            else -> application.applicationContext.getString(
                R.string.text_label_display_new_case_number,
                deaths.newDeaths
            )
        }
    }

    val displayPlusNewRecovered = Transformations.map(covData) { recovered ->
        when (recovered.newConfirmed) {
            zero -> application.applicationContext.getString(
                R.string.text_label_placeholder
            )
            else -> application.applicationContext.getString(
                R.string.text_label_display_new_case_number,
                recovered.newRecovered
            )
        }
    }

    val displayPlusNewHospitalized = Transformations.map(covData) { hospitalized ->
        when (hospitalized.newConfirmed) {
            zero -> application.applicationContext.getString(
                R.string.text_label_placeholder
            )
            else -> application.applicationContext.getString(
                R.string.text_label_display_new_case_number,
                hospitalized.newHospitalized
            )
        }
    }

    init {
        getNewDailyDataFromSource()
    }

    private fun onRefreshSuccessfully() {
        _refreshData.value = UpdateStatus.NOT_UPDATE.status
    }

    fun getDailyDataFromCaching() {
        viewModelScope.launch {
            try {
                _covData.value = caseRepository.getDailyCasesData()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getNewDailyDataFromSource() {
        viewModelScope.launch {
            try {
                caseRepository.getDailyCasesResponseData()
                getDailyDataFromCaching()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        onRefreshSuccessfully()
    }

    fun onForceToUpdateData() {
        _refreshData.value = UpdateStatus.UPDATE.status
    }

    companion object {
        private const val zero = 0
    }
}