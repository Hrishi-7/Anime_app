package com.hrishikesh.animeapp.homeFeed.screen.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrishikesh.animeapp.R
import com.hrishikesh.animeapp.databinding.FragmentDetailsBinding
import com.hrishikesh.animeapp.homeFeed.screen.details.epoxy.EpoxyAnimeDetailController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerCallback
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val args: DetailsFragmentArgs by navArgs()
    private val animeId by lazy {
        args.animeId
    }

    private val viewModel: DetailsViewModel by viewModels<DetailsViewModel>()
    private val epoxyController by lazy {
        EpoxyAnimeDetailController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAnimeDetails(animeId)
        setupRecyclerView()
        setObserver()
    }

    private fun setupRecyclerView() {
        epoxyController.setFilterDuplicates(true)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = epoxyController.adapter
        }
    }

    private fun setObserver() {
        viewModel.animeDetails.observe(viewLifecycleOwner) {
            epoxyController.setData(it)
            binding.youtubeView.getYouTubePlayerWhenReady(object : YouTubePlayerCallback{
                override fun onYouTubePlayer(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(it.result.trailer.youtubeId, 0f)
                }

            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}