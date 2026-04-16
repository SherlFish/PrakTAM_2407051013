package com.example.praktam_2407051013

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.praktam_2407051013.model.Chara
import com.example.praktam_2407051013.model.CharaSource
import com.example.praktam_2407051013.ui.theme.PrakTAM_2407051013Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrakTAM_2407051013Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DaftarCharaScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DaftarCharaScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CharaSource.dummyChara.forEach { chara ->
            ItemChara(chara = chara)
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun ItemChara(chara: Chara) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = chara.imageRes),
            contentDescription = chara.nama,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = chara.nama,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = chara.deskripsi,
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Harga Sewa: Rp ${chara.harga}",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Biarin kosong */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Rekrut Sekarang")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DaftarCharaPreview() {
    PrakTAM_2407051013Theme {
        DaftarCharaScreen()
    }
}