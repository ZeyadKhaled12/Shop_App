package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.ShoeList.ShoeListModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.view.*

class ShoeDetailFragment : Fragment() {

    private  val viewModel: ShoeListModel by activityViewModels()



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

        binding.shoe = Shoe()

        binding.saveButton.setOnClickListener {
            viewModel.addShoe(viewModel.shoe)
            Navigation.findNavController(it).navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }


        binding.cancelButton.setOnClickListener {
            Navigation.findNavController(it).navigate(
                R.id.action_shoeDetailFragment_to_shoeListFragment)
        }



        return binding.root
    }
}