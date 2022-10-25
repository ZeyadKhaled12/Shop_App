package com.udacity.shoestore.ShoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout


import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R

import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_list.view.*

class ShoeListFragment : Fragment() {

    lateinit var viewModel: ShoeListModel

    private lateinit var binding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false
        )
        viewModel = ViewModelProvider(this).get(ShoeListModel::class.java)


        viewModel.listShoes.observe(viewLifecycleOwner,
            Observer { newListShoes -> updateShoes(newListShoes)}
        )

        binding.floatingActionButton.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        setHasOptionsMenu(true)

        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    private fun updateShoes(listShoes: List<Shoe>){
        binding.layoutList.removeAllViews()
        listShoes.forEach{
            val layoutList: LinearLayout = binding.layoutList
            val shoe = ShoeFragment(context)
            layoutList.addView(
                shoe.getView(
                    it.name,
                    it.company,
                    it.size,
                    it.description
                )
            )
        }

    }

}