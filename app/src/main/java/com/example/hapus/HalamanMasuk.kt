package com.example.hapus
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun HalamanMasuk(navController: NavController){

    val teksDasar = 0xFF304D30

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var error by remember { mutableStateOf(false) }

    var salah by remember { mutableStateOf("") }

    val textPudar = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF989898))

    Column{
        Surface(
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth(),
            color = Color(0xFFC5D7C5),
            shadowElevation = 8.dp
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color(0xFF304D30),
                    modifier = Modifier
                        .size(60.dp)
                        .padding(14.dp)
                )
                Text(
                    text = "Masuk",
                    fontSize = 24.sp,
                    color = Color(0xFF304D30),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(14.dp),

                )
            }
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Spacer(modifier = Modifier.height(60.dp))
            Image(painter = painterResource(id = R.drawable.logo_sleman), contentDescription = null )
            Text(text = salah)
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Username",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(teksDasar),
                modifier = Modifier
                    .offset((-90).dp)
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text(text = "Masukkan Username", style = textPudar) },
                shape = RoundedCornerShape(24.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color(0xFFEEF0E5),
                    focusedIndicatorColor = Color(0xFF789461),
                    focusedContainerColor = Color(0xFFEEF0E5)

                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Password",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(teksDasar),
                modifier = Modifier
                    .offset((-90).dp)
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text(text = "Masukkan Password",style = textPudar) },
                shape = RoundedCornerShape(24.dp),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color(0xFFEEF0E5),
                    focusedIndicatorColor = Color(0xFF789461),
                    focusedContainerColor = Color(0xFFEEF0E5)

                )
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Lupa Password?",
                fontSize = 17.sp,
                color = Color(teksDasar),
                modifier = Modifier.offset((-71).dp)
            )
            Spacer(modifier = Modifier.height(80.dp))

            Button(
                onClick = {
                    if (username == "davaasu" && password == "guguguk"){
                        navController.navigate("MenuUtama")
                    }else{
                        error = true
                    }

                },
                colors = ButtonDefaults.buttonColors(Color(0xFF789461)),
                modifier = Modifier
                    .height(50.dp)
                    .width(156.dp)
            ) {
                Text(
                    text = "Masuk",
                    fontSize = 24.sp
                )

            }
            if (error){
                salah = "Username atau Password Salah!"
                LaunchedEffect(Unit){
                    delay(2000)
                    error = false
                    salah = ""
                }

            }

            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "Atau", fontSize = 18.sp, color = Color(teksDasar))
            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Text(
                    text = "Belum Punya Akun?",
                    fontSize = 20.sp,
                    color = Color(0xFF789461)
                )
                Text(
                    text = "Daftar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(teksDasar)
                )
            }

        }
    }
}