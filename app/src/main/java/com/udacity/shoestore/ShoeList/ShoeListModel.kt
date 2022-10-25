package com.udacity.shoestore.ShoeList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListModel:ViewModel() {

    var listShoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    var shoe = Shoe()


    fun addShoe(newShoe: Shoe){
        val newList: MutableList<Shoe>? = listShoes.value
        newList?.add(newShoe)
        listShoes.value = newList
    }

}