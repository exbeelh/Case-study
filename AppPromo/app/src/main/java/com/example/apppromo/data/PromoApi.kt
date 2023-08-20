package com.example.apppromo.data

import com.example.apppromo.data.model.PromoData
import com.example.apppromo.util.Constant.PROMO_ENDPOINT
import com.example.apppromo.util.Constant.PROMO_ENDPOINT_BY_ID
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PromoApi {
    @GET(PROMO_ENDPOINT)
    suspend fun getPromos(): Response<List<PromoData>>

    @GET(PROMO_ENDPOINT_BY_ID)
    suspend fun getPromoById(@Path(value = "id") id: Int) : Response<PromoData>
}