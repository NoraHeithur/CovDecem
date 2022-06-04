package com.nora.covdecem.data.network.model

import com.nora.covdecem.data.database.entity.CaseEntity
import com.nora.covdecem.domain.model.Case
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

private const val ID_ONE = 1

@JsonClass(generateAdapter = true)
data class CaseNetwork(
    @Json(name = "updated")
    val updated: Long,
    @Json(name = "country")
    val country: String,
    @Json(name = "cases")
    val cases: Int,
    @Json(name = "todayCases")
    val todayCases: Int,
    @Json(name = "deaths")
    val deaths: Int,
    @Json(name = "todayDeaths")
    val todayDeaths: Int,
    @Json(name = "recovered")
    val recovered: Int,
    @Json(name = "todayRecovered")
    val todayRecovered: Int,
    @Json(name = "active")
    val active: Int,
    @Json(name = "critical")
    val critical: Int,
    @Json(name = "casesPerOneMillion")
    val casesPerOneMillion: Int,
    @Json(name = "deathsPerOneMillion")
    val deathsPerOneMillion: Int,
    @Json(name = "tests")
    val tests: Int,
    @Json(name = "testsPerOneMillion")
    val testsPerOneMillion: Int,
    @Json(name = "population")
    val population: Int,
    @Json(name = "continent")
    val continent: String,
    @Json(name = "oneCasePerPeople")
    val oneCasePerPeople: Int,
    @Json(name = "oneDeathPerPeople")
    val oneDeathPerPeople: Int,
    @Json(name = "oneTestPerPeople")
    val oneTestPerPeople: Int,
    @Json(name = "activePerOneMillion")
    val activePerOneMillion: Double,
    @Json(name = "recoveredPerOneMillion")
    val recoveredPerOneMillion: Double,
    @Json(name = "criticalPerOneMillion")
    val criticalPerOneMillion: Double,
    @Json(name = "Confirmed")
    val confirmed: Int,
    @Json(name = "Recovered")
    val recovered2: Int,
    @Json(name = "Hospitalized")
    val hospitalized: Int,
    @Json(name = "Deaths")
    val deaths2: Int,
    @Json(name = "NewConfirmed")
    val newConfirmed: Int,
    @Json(name = "NewRecovered")
    val newRecovered: Int,
    @Json(name = "NewHospitalized")
    val newHospitalized: Int,
    @Json(name = "NewDeaths")
    val newDeaths: Int,
    @Json(name = "UpdateDate")
    val updateDate: String,
    @Json(name = "DevBy")
    val devBy: String
)

/*fun CaseNetwork.toDomainModel() =
    Case(
        updated,
        confirmed,
        recovered,
        hospitalized,
        deaths,
        newConfirmed,
        newRecovered,
        newHospitalized,
        newDeaths,
        updateDate,
    )*/

fun CaseNetwork.toDatabaseModel() =
    CaseEntity(
        ID_ONE,
        confirmed,
        recovered,
        hospitalized,
        deaths,
        newConfirmed,
        newRecovered,
        newHospitalized,
        newDeaths,
        updateDate
    )