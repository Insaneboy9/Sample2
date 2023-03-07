package com.example.samplequiz2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Bus::class],
    version = 1,
    exportSchema = true
)
abstract class BusRoomDatabase : RoomDatabase() {
    abstract fun busDao(): BusDao

    companion object {

        @Volatile
        private var INSTANCE: BusRoomDatabase? = null

        fun getDatabase(context: Context): BusRoomDatabase {
            if (INSTANCE == null) { //create db if null
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): BusRoomDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BusRoomDatabase::class.java,
                "BusRoomDatabase"
            )
                .build()
        }
    }
}