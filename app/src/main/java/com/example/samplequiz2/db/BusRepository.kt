package com.example.samplequiz2.db

import androidx.lifecycle.LiveData

class BusRepository(private val busDao: BusDao) {

    val getAll : LiveData<List<Bus>> = busDao.all()

    suspend fun add(bus: Bus){
        busDao.add(bus)
    }

    suspend fun deleteAll(){
        busDao.deleteAll()
    }

}