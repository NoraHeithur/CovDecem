package com.nora.covdecem.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nora.covdecem.domain.model.Case

@Entity(tableName = "daily_case_database")
data class CaseEntity(
    @PrimaryKey
    val id: Int,
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

fun CaseEntity.toDomainModel() =
    Case(
        confirmed,
        recovered,
        hospitalized,
        deaths,
        newConfirmed,
        newRecovered,
        newHospitalized,
        newDeaths,
        updateDate,
    )