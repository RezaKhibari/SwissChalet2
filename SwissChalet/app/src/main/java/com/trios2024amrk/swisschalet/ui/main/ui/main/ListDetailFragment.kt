package com.trios2024amrk.swisschalet.ui.main.ui.main

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.trios2024amrk.swisschalet.R



class ListDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ListDetailFragment()
    }

    private val viewModel: ListDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // viewModel = ViewModelProvider(requireActivity()).get(ListDetailViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.list_detail_fragment, container, false)
    }

}