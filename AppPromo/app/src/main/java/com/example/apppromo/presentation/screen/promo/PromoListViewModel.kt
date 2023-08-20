package com.example.apppromo.presentation.screen.promo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppromo.data.model.PromoData
import com.example.apppromo.repository.PromoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoListViewModel @Inject constructor(
    private val promoRepository: PromoRepository
) : ViewModel() {
    private val _promos = MutableLiveData<List<PromoData>>()
    val promos: LiveData<List<PromoData>> get() = _promos

    init {
        getPromos()
    }

    private fun getPromos() {
        viewModelScope.launch {
            try {
                val promos = promoRepository.getPromos()
                _promos.value = promos
            } catch (_: Exception) {}
        }
    }

}