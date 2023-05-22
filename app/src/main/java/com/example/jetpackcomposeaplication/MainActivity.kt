package com.example.jetpackcomposeaplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeaplication.ui.theme.JetPackComposeAplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeAplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenMain()
                }
            }
        }
    }
}


@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    val listaAsistentes = remember { mutableStateListOf<Asistente>() }

    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginPage(navController) }
        composable("menu") { PrincipalMenu(navController = navController) }
        composable("signup") { SignUp(navController = navController)}
        composable("forgot-password") { ForgotPassword(navController = navController)}
        composable("registrar-participant") { Enrollment(navController = navController,listaAsistentes) }
        composable("listado") { ListaAsistentes(navController = navController,listaAsistentes) }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    JetPackComposeAplicationTheme {
        ScreenMain()
    }
}