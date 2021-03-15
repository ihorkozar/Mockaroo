package com.example.stormotiontest.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.stormotiontest.network.Property

class DetailViewModel(property: Property, app: Application): AndroidViewModel(app) {
    private val _selectedProperty = MutableLiveData<Property>()

    val selectedProperty: LiveData<Property>
        get() = _selectedProperty

    init {
        _selectedProperty.value = property
    }
}