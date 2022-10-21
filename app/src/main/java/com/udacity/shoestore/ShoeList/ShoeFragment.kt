package com.udacity.shoestore.ShoeList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeBinding

class ShoeFragment(context: Context?) : LinearLayout(context) {

    private val binding: FragmentShoeBinding = DataBindingUtil
        .inflate(LayoutInflater.from(context),
            R.layout.fragment_shoe, this, false)

    fun getView(
        name: String?,
        company: String?,
        shoeSize: String?, description: String?
    ): View{
        binding.shoeNameField.text =  name
        binding.companyField.text = company
        binding.shoeSizeField.text = shoeSize
        binding.descriptionField.text = description
        return binding.root
    }

}