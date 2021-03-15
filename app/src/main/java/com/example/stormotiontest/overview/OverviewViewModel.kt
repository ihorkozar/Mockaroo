package com.example.stormotiontest.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stormotiontest.network.Api
import com.example.stormotiontest.network.Property
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel: ViewModel() {
    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus>
    get() = _status

    private val _properties = MutableLiveData<List<Property>>()
     val properties: LiveData<List<Property>>
        get() = _properties

    private val _navigateToSelectedProperty = MutableLiveData<Property>()
    val navigateToSelectedProperty: LiveData<Property>
        get() = _navigateToSelectedProperty

    init {
        getProperties()
    }

    private fun getProperties() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _properties.value = Api.RETROFIT_SERVICE.getProperties()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    fun displayPropertyDetails(property: Property) {
        _navigateToSelectedProperty.value = property
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}