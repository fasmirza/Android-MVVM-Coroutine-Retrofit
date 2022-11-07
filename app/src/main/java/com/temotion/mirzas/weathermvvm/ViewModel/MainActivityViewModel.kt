package com.temotion.mirzas.weathermvvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.temotion.mirzas.datafetchingmvvmhiltretro.Models.CountryModel
import com.temotion.mirzas.datafetchingmvvmhiltretro.Network.RetroService
import com.temotion.mirzas.datafetchingmvvmhiltretro.Network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel(){

    lateinit var countryLiveData : MutableLiveData<CountryModel>

    init {
        countryLiveData = MutableLiveData()
    }
    fun getLiveDataObserver() : MutableLiveData<CountryModel>{
        return countryLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val retroInstance = RetrofitInstance.getRetroInstance()
            val retroService = retroInstance.create(RetroService::class.java)
            val countryData = retroService.getDataFromApi("ny")

            countryLiveData.postValue(countryData)
        }
    }
}