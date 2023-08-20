package com.example.apppromo.presentation.screen.promodetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apppromo.data.model.PromoData
import com.example.apppromo.repository.PromoRepository
import com.example.apppromo.util.Constant.PROMO_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PromoDetailViewModel @Inject constructor(
    private val promoRepository: PromoRepository,
    saveStateHandle: SavedStateHandle
) : ViewModel() {
    private val _promo : MutableStateFlow<PromoData?> = MutableStateFlow(null)
    val promo: StateFlow<PromoData?> = _promo

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val promoId = saveStateHandle.get<Int>(PROMO_ARGUMENT_KEY) ?: 0
            _promo.value =
                promoRepository.getPromoById(id = promoId)
        }
    }
}