package com.nora.covdecem.data.repository

import com.nora.covdecem.data.database.dao.CaseDao
import com.nora.covdecem.data.database.entity.toDomainModel
import com.nora.covdecem.data.network.model.toDatabaseModel
import com.nora.covdecem.data.network.service.CovApiService
import com.nora.covdecem.domain.model.Case
import com.nora.covdecem.domain.repository.CaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class CaseRepositoryImpl(private val covApiService: CovApiService, private val caseDao: CaseDao) : CaseRepository {

    override suspend fun getDailyCasesData(): Case {
        val dailyData = withContext(Dispatchers.IO) {
            caseDao.queryDailyData()
        }
        return dailyData.toDomainModel()
    }

    override suspend fun getDailyCasesResponseData() {
        val response = withContext(Dispatchers.IO) {
            covApiService.getDailyData()
        }
        caseDao.insertDailyData(response.toDatabaseModel())
    }
}