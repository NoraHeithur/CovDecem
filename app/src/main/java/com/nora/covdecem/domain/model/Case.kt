package com.nora.covdecem.domain.model

data class Case(
    val confirmed: Int,
    val recovered: Int,
    val hospitalized: Int,
    val deaths: Int,
    val newConfirmed: Int,
    val newRecovered: Int,
    val newHospitalized: Int,
    val newDeaths: Int,
    val updateDate: String,
)