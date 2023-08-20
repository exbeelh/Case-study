package com.example.apppromo.repository

import com.example.apppromo.data.PromoApi
import com.example.apppromo.data.model.PromoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PromoRepository @Inject constructor(
    private val promoApi: PromoApi
) {
    suspend fun getPromos(): List<PromoData> {
        return withContext(Dispatchers.IO) {
            val promo = promoApi.getPromos()
            promo.body() ?: emptyList()
        }
    }

    suspend fun getPromoById(id: Int): PromoData {
        return withContext(Dispatchers.IO) {
            val promo = promoApi.getPromoById(id)
            promo.body()!!
        }
    }
}