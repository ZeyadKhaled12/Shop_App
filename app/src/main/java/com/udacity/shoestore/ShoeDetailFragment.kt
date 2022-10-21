package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.ShoeList.ShoeListModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*

class ShoeDetailFragment : Fragment() {
    private lateinit var viewModel: ShoeListModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val binding: FragmentShoeDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(ShoeListModel::class.java)

        binding.saveButton.setOnClickListener {
            viewModel.addShoe(
                mapOf(
                    "shoe_name" to binding.shoeNameField.text.toString(),
                    "company" to binding.companyField.text.toString(),
                    "shoe_size" to binding.shoeSizeField.text.toString(),
                    "description" to binding.descriptionField.text.toString()
                )
                /*
                mapOf(
                    "shoe_name" to "kofta",
                    "company" to "adidas",
                    "shoe_size" to "40",
                    "description" to "this is  goodone"
                )

                 */
            )
            Navigation.findNavController(it).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }


        binding.cancelButton.setOnClickListener {
            Navigation.findNavController(it).navigate(
                R.id.action_shoeDetailFragment_to_shoeListFragment)
        }



        return binding.root
    }
}