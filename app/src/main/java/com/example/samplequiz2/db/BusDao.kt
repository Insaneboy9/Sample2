package com.example.samplequiz2.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BusDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(digit: Bus)

    @Query("SELECT * FROM bus ORDER BY id ASC")
    fun all(): LiveData<List<Bus>>

    @Query("DELETE FROM bus")
    suspend fun deleteAll()
}