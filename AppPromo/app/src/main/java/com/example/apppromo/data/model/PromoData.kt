package com.example.apppromo.data.model

data class PromoData(
    val id: Int,
    val nama: String,
    val desc: String,
    val lokasi: String,
    val img: ImageData
)

data class ImageData(
    val id: Int,
    val name: String,
    val formats: FormatImage
)

data class FormatImage (
    val small: SmallImage,
    val medium: MediumImage
)

data class SmallImage(
    val url: String
)

data class MediumImage (
    val url: String
)