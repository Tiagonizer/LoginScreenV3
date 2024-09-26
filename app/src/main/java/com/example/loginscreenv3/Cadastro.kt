package com.example.loginscreenv3

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


//class Cadastro : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            LoginScreenV3Theme {
//                CadastroScreen()
//            }
//        }
//    }
//}


@Composable
fun CadastroScreen(navController: NavController){

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp


    val context = LocalContext.current

    var primeiroNome by remember {mutableStateOf("")}
    var ultimoNome by remember {mutableStateOf("")}
    var apelido by remember {mutableStateOf("")}
    var email by remember {mutableStateOf("")}
    var altura by remember {mutableStateOf("")}
    var peso by remember {mutableStateOf("")}
    var idade by remember {mutableStateOf("")}
    var senha by remember {mutableStateOf("")}
    var senhaConfirm by remember {mutableStateOf("")}


        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Box(modifier = Modifier.padding(10.dp),) {
                Text("Cadastro:", fontSize = 30.sp)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha") },
                    modifier = Modifier.fillMaxWidth()
                        .padding(0.dp,2.dp,0.dp,0.dp)
                )
                OutlinedTextField(
                    value = senhaConfirm,
                    onValueChange = { senhaConfirm = it },
                    label = { Text("Confirma senha") },
                    modifier = Modifier.fillMaxWidth()
                        .padding(0.dp,2.dp,0.dp,0.dp)
                )
                OutlinedTextField(
                    value = primeiroNome,
                    onValueChange = { primeiroNome = it },
                    label = { Text("Primeiro nome") },
                    modifier = Modifier.fillMaxWidth()
                        .padding(0.dp,2.dp,0.dp,0.dp)
                )
                OutlinedTextField(
                    value = ultimoNome,
                    onValueChange = { ultimoNome = it },
                    label = { Text("Ultimo nome") },
                    modifier = Modifier.fillMaxWidth()
                        .padding(0.dp,2.dp,0.dp,0.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(value = apelido,
                        onValueChange = { apelido = it },
                        label = { Text("Apelido") },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(0.dp,2.dp,10.dp,0.dp)
                    )
                    OutlinedTextField(value = idade,
                        onValueChange = { idade = it },
                        label = { Text("Idade") },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp,2.dp,0.dp,0.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedTextField(value = altura,
                        onValueChange = { altura = it },
                        label = { Text("Altura") },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(0.dp,2.dp,10.dp,0.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    OutlinedTextField(value = peso,
                        onValueChange = { peso = it },
                        label = { Text("Peso") },
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .padding(10.dp,2.dp,0.dp,0.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
            }





            Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom) {
                Button(modifier = Modifier
                    .fillMaxWidth(), onClick = {
                    Toast.makeText(
                        context, "Cadastrado com sucesso.",
                        Toast.LENGTH_SHORT).show()
                        navController.popBackStack()
                    })
                { Text("Cadastrar") }
            }
        }



}


@Preview(showBackground = true)
@Composable
private fun CasdastroScreenPreview() {
    CadastroScreen(rememberNavController())
}