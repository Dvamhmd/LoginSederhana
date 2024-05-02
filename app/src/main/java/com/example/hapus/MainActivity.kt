package com.example.hapus
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hapus.ui.theme.HapusTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HapusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigasi()
                }
            }
        }
    }
}

@Composable
fun Navigasi(){

    val nav = rememberNavController()
    NavHost(
        navController = nav,
        startDestination = "Masuk",
        builder = {
            composable("Masuk"){
                HalamanMasuk(nav)
            }
            composable("MenuUtama"){
                MenuUtama(nav)
            }
        }
    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HapusTheme {
        Navigasi()
    }
}