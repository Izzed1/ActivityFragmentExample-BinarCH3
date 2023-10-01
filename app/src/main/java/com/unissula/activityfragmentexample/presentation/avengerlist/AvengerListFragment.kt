package com.unissula.activityfragmentexample.presentation.avengerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.unissula.activityfragmentexample.data.AvengersDataSource
import com.unissula.activityfragmentexample.data.AvengersDataSourceImpl
import com.unissula.activityfragmentexample.databinding.FragmentAvengerListBinding
import com.unissula.activityfragmentexample.modul.Person

class AvengerListFragment : Fragment() {

    private lateinit var binding: FragmentAvengerListBinding

    private val dataSource: AvengersDataSource by lazy {
        AvengersDataSourceImpl()
    }

    private val adapter: AvengerListAdapter by lazy {
        AvengerListAdapter {
            navigateToFragmentTwo(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvengerListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.rvAvengers.adapter = adapter
        binding.rvAvengers.layoutManager = LinearLayoutManager(requireContext())

        // horizontal list
        // binding.rvAvengers.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        // grid list
        // binding.rvAvengers.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        adapter.setData(dataSource.getAvengersData()) // set data ke adapter
    }

    private fun navigateToFragmentTwo(person: Person? = null) {

        val action = AvengerListFragmentDirections.navigateToDetail(person)
        findNavController().navigate(action)
    }
}