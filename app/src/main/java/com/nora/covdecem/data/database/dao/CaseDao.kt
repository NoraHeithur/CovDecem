package com.nora.covdecem.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nora.covdecem.data.database.entity.CaseEntity

@Dao
interface CaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDailyData(case: CaseEntity)

    @Query("SELECT * FROM DAILY_CASE_DATABASE")
    suspend fun queryDailyData(): CaseEntity
}