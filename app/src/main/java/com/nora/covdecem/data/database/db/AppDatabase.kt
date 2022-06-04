package com.nora.covdecem.data.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nora.covdecem.data.database.dao.CaseDao
import com.nora.covdecem.data.database.entity.CaseEntity

@Database(entities = [CaseEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun caseDao(): CaseDao
}