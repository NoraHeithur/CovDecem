package com.nora.covdecem.domain.repository

import com.nora.covdecem.data.database.entity.CaseEntity
import com.nora.covdecem.domain.model.Case

interface CaseRepository {

    suspend fun getDailyCasesData() : Case

    suspend fun getDailyCasesResponseData() }