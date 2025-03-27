package com.hrishikesh.animeapp.homeFeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrishikesh.animeapp.R
import com.hrishikesh.animeapp.databinding.FragmentHomeBinding
import com.hrishikesh.animeapp.homeFeed.callback.HomeAnimeClickCallback
import com.hrishikesh.animeapp.homeFeed.epoxy.HomeAnimeEpoxyController
import com.hrishikesh.animeapp.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels<HomeViewModel>()
    private val epoxyController by lazy {
        val callback = HomeAnimeClickCallback(viewModel)
        HomeAnimeEpoxyController(callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setObservers()
    }

    private fun setRecyclerView() {
        epoxyController.setFilterDuplicates(true)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = epoxyController.adapter
        }
    }

    private fun setObservers() {
        viewModel.homeAnime.observe(viewLifecycleOwner) {
            epoxyController.setData(it)
        }

        viewModel.navDirections.observe(viewLifecycleOwner, EventObserver {
            navigate(it)
        })
    }

    private fun Fragment.navigate(navDirections: NavDirections) {
        try {
            findNavController().navigate(navDirections)
        } catch (exc: Exception) {
            exc.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}