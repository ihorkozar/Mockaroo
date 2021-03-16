package com.example.stormotiontest.detail

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stormotiontest.R
import com.example.stormotiontest.databinding.FragmentDetailBinding
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val property = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = DetailViewModelFactory(property, application)

        val toolbar: androidx.appcompat.widget.Toolbar = binding.toolbar
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener{activity!!.onBackPressed()}

        val onlineUri = Uri.parse("https://android.codeseasy.com/Video-Files/BigBuckBunny.mp4")

        val videoView = binding.videoView
        val mediaController = MediaController(context)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(onlineUri)
        videoView.requestFocus()
        videoView.start()

        binding.viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(DetailViewModel::class.java)
        return binding.root
    }
}