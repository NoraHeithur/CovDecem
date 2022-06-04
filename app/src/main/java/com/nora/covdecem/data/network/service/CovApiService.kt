package com.nora.covdecem.data.network.service

import com.nora.covdecem.data.network.model.CaseNetwork
import retrofit2.http.GET

interface CovApiService {

    @GET("getTodayCases.json")
    suspend fun getDailyData(): CaseNetwork

}