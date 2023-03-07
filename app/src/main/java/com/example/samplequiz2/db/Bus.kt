package com.example.samplequiz2.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bus")
data class Bus(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "num")
    val num: String,
    @ColumnInfo(name = "route")
    val route: String,
    @ColumnInfo(name = "company")
    val company: String
)