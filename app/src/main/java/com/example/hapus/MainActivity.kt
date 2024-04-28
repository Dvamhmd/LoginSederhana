package com.example.hapus
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hapus.ui.theme.HapusTheme
import kotlinx.coroutines.delay


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
        startDestination = "1",
        builder = {
            composable("1"){
                Halaman1(nav)
            }
            composable("2"){
                Halaman2(nav)
            }
        }
    )

}

@Composable
fun Halaman1(navController: NavController){

    var username by remember {
        mutableStateOf("")
    }

    var error by remember {
        mutableStateOf(false)
    }

    var salah by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {

        Text(text = salah)

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Masukkan Username")}
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                if (username == "davaasu"){
                    navController.navigate("2")
                }else{
                    error = true
                }

            }
        ) {
            Text(text = "Log In")
        }

        if (error){
            salah = "Username Salah!"
            LaunchedEffect(Unit){
                delay(2000)
                error = false
                salah = ""
            }

        }

    }

}

@Composable
fun Halaman2(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("1") }) {
            Text(text = "Kembali")
        }
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HapusTheme {
        Navigasi()
    }
}