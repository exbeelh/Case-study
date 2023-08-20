package com.example.apppromo.presentation.screen.promodetail

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.apppromo.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoDetailScreen(
    modifier: Modifier = Modifier,
    promoDetailViewModel: PromoDetailViewModel = hiltViewModel()
) {
    val selectedPromo by promoDetailViewModel.promo.collectAsState()
    Scaffold {
        Column {
            selectedPromo?.let { promoData ->
                Log.d("API response", promoData.desc)
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current).data(promoData.img.formats.medium.url)
                        .crossfade(true).build(),
                    contentDescription = promoData.img.name,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(16.dp))
                Box(
                    modifier = modifier.padding(16.dp)
                ) {
                    Text(
                        text = promoData.desc,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoDetailScreenSample(
    modifier: Modifier = Modifier
) {
    Scaffold {
        Column(
            modifier = modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.small_bni_credit_card_banner_fitur_mbanking),
                contentDescription = null,
                modifier = modifier.fillMaxWidth().height(180.dp)
            )
            Spacer(modifier = modifier.height(16.dp))
            Text(
                text = "Potongan langsung (diskon) Rp 150.000,- untuk minimal transaksi Rp 1.000.000, kuota 15 transaksi pertama per hari. - Berlaku tiap Kamis dan Jumat. - Berlaku untuk pembelian Tiket Sriwijaya Air dan NAM Air di Website dan Mobile Apps Sriwijaya Air - Potongan harga langsung diperoleh ketika nomor Kartu BNI dimasukkan (tanpa kode promo) - Syarat dan ketentuan berlaku Info lebih lanjut hubungi BNI Call 1500046",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PromoDetailScreenPreview() {
    PromoDetailScreenSample()
}