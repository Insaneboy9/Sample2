package com.example.samplequiz2.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BusViewModel(application: Application): AndroidViewModel(application)  {
    val allData: LiveData<List<Bus>>
    private val repository: BusRepository

    init {
        val busDao = BusRoomDatabase.getDatabase(application).busDao()
        repository = BusRepository(busDao)
        allData = repository.getAll
    }

    fun addBus(bus: Bus){
        viewModelScope.launch(Dispatchers.IO) {
            repository.add(bus)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

}