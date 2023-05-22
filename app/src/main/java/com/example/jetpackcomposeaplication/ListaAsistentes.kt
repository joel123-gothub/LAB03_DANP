package com.example.jetpackcomposeaplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ListaAsistentes(navController: NavController, listaAsistentes:  MutableList<Asistente>) {
    Box(modifier = Modifier.fillMaxSize()) {
        Scaffold(
            topBar = { CustomTopAppBar(
                navController = navController,
                title = "Listado de Participantes",
                showBackIcon = true
            )},
            content = {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LazyColumn {
                        items(listaAsistentes) { Asistente ->
                            // Aquí puedes diseñar la apariencia de cada elemento de la lista
                            Text(text = "ASISTENTE:")
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = "Nombres: ${Asistente.Nombre}")
                            Text(text = "Fecha de Inscripcion: ${Asistente.Fecha}")
                            Text(text = "Tipo de sangre: ${Asistente.TipoSangre}")
                            Text(text = "Telefono: ${Asistente.Telefono}")
                            Text(text = "Correo electronico: ${Asistente.Email}")
                            Text(text = "Monto pagado : S/.: ${Asistente.Monto}")
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }
            }
        )
    }
}