package com.example.jetpackcomposeaplication

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Enrollment(navController: NavController, listaAsistentes: MutableList<Asistente>) {
    Scaffold(
        topBar = { CustomTopAppBar(
            navController = navController,
            title = "Registro de Asistentes",
            showBackIcon = true
        )},
        content = {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val nombres = remember {
                    mutableStateOf("")
                }

                val fecha = remember {
                   mutableStateOf("")
                }

                val tipoSangre = remember {
                    mutableStateOf("")
                }

                val telefono = remember {
                    mutableStateOf("")
                }

                val email = remember {
                    mutableStateOf("")
                }

                val monto = remember {
                    mutableStateOf("")
                }

                Text(
                    text = "Registro de Asistentes",
                    style = TextStyle(fontSize = 40.sp, fontFamily = FontFamily.Cursive)
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Nombres Completos") },
                    value = nombres.value,
                    onValueChange = { nombres.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Fecha") },
                    value = fecha.value,
                    onValueChange = { fecha.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Tipo de Sangre") },
                    value = tipoSangre.value,
                    onValueChange = { tipoSangre.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Telefono") },
                    value = telefono.value,
                    onValueChange = { telefono.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Email") },
                    value = email.value,
                    onValueChange = { email.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                TextField(
                    label = { Text(text = "Monto pagado") },
                    value = monto.value,
                    onValueChange = { monto.value = it }
                )

                Spacer(modifier = Modifier.height(15.dp))

                /*Text(
                    text = "Fecha Actual: ${fecha.value}",
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))*/

                Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                    Button(
                        onClick = {
                            val asistenteOtro = Asistente(nombres.value, fecha.value, tipoSangre.value, telefono.value, email.value, monto.value)
                            listaAsistentes.add(asistenteOtro)
                            // Limpia los campos después de registrar al usuario
                            nombres.value = ""
                            fecha.value = ""
                            tipoSangre.value = ""
                            telefono.value = ""
                            email.value = ""
                            monto.value = ""
                        },
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Registrar")
                    }
                }
            }
        }
    )
}

