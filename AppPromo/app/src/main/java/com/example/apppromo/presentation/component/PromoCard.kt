package com.example.apppromo.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.apppromo.R
import com.example.apppromo.data.model.PromoData

@Composable
fun PromoCard(
    modifier: Modifier = Modifier,
    promo: PromoData,
    navController: NavController
) {
    Card (
        modifier = modifier.fillMaxWidth()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current).data(promo.img.formats.small.url)
                .crossfade(true).build(),
            contentDescription = promo.img.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(175.dp)
                .fillMaxWidth()
                .clickable {
                    navController.navigate("promos/${promo.id}")
                }
        )
    }
}

@Composable
fun PromoCardSample(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.small_bni_credit_card_banner_fitur_mbanking),
            contentDescription = null,
            modifier = modifier.height(160.dp).fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PromoCardPreview() {
    PromoCardSample()
}