package com.udacity.shoestore.ShoeList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShoeListModel:ViewModel() {

    var listShoes = MutableLiveData<MutableList<Map<String, String>>>()

    init {
        listShoes.value =  mutableListOf( mapOf())
    }

    fun addShoe(newShoe: Map<String, String>){
        val newList: MutableList<Map<String, String>>? = listShoes.value
        newList?.add(newShoe)
        listShoes.value = newList
    }

}