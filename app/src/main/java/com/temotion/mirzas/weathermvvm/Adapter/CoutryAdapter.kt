package com.temotion.mirzas.weathermvvm.Adapter

import android.content.ClipData
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.temotion.mirzas.datafetchingmvvmhiltretro.Models.CountryModel
import com.temotion.mirzas.datafetchingmvvmhiltretro.Models.ItemsItem

import com.temotion.mirzas.weathermvvm.R

class CoutryAdapter : RecyclerView.Adapter <CoutryAdapter.CountryViewHolder>() {
    lateinit private  var countryList : List<ItemsItem>
    private val TAG = "CoutryAdapter"

    fun setupData(countryList : List<ItemsItem>){
        this.countryList = countryList


    }

/*The Flow of the Adapter
* 1-- OncreateviewHolder : It inflate the Single_Item layout and create a view and return it to ViewHolder(CountryViewholder)
* 2-- OnBindViewHolder : it takes the Items of Position index from the list and pass it to ViewHolder.bind method
* it also get the Size of the List to determine how many times to run
* ViewHolder(CountryViewholder)  has the View and the Data, It set the data to view*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_object,parent,false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList.get(position))
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: "+ countryList.size )
        return countryList.size
    }

    class CountryViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val titleText = view.findViewById<TextView>(R.id.name)
        val titleTextfull = view.findViewById<TextView>(R.id.name_full)

        fun bind(data : ItemsItem){
            titleText.text = data.fullName
            titleTextfull.text = data.language
        }

    }
}