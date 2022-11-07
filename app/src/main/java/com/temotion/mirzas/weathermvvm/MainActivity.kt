package com.temotion.mirzas.weathermvvm

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.temotion.mirzas.weathermvvm.Adapter.CoutryAdapter
import com.temotion.mirzas.weathermvvm.ViewModel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var countryRecyclerView : RecyclerView
    lateinit var countryAdapter :CoutryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryRecyclerView = findViewById(R.id.countryRecyclerView)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView(){
        countryRecyclerView.layoutManager = LinearLayoutManager(this)
        countryAdapter = CoutryAdapter()

    }

    private fun initViewModel (){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        /*setting Observer to the viewmodel*/
        viewModel.getLiveDataObserver().observe(this,Observer{
            if (it != null){
                countryAdapter.setupData(it.items) // "it" is the ListData sent by observer

                countryRecyclerView.adapter = countryAdapter
                countryAdapter.notifyDataSetChanged()
            }else{
                Log.d(TAG, "initViewModel: Error")
            }
        })
        viewModel.makeApiCall()   //calling API call throw ViewModel
    }
}