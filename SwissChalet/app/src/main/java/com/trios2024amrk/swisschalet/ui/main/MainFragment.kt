package com.trios2024amrk.swisschalet.ui.main

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.trios2024amrk.swisschalet.R
import com.trios2024amrk.swisschalet.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentMainBinding.inflate(inflater, container,false)
        binding.menuRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        // binding.menuRecyclerview.adapter = ListSelectionRecyclerViewAdapter()
        viewModel = ViewModelProvider(requireActivity(), MainViewModelFactory(
            PreferenceManager.getDefaultSharedPreferences(requireActivity())))
            .get(MainViewModel::class.java)

           val recyclerViewAdapter = ListSelectionRecyclerViewAdapter(viewModel.lists)
           binding.menuRecyclerview.adapter = recyclerViewAdapter
           viewModel.onListAdded = {
               recyclerViewAdapter.listsUpdated()
           }
        return binding.root
    }



}