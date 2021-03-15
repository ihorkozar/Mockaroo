package com.example.stormotiontest.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.stormotiontest.R
import com.example.stormotiontest.databinding.FragmentDetailBinding

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
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(DetailViewModel::class.java)
        return binding.root
    }
}