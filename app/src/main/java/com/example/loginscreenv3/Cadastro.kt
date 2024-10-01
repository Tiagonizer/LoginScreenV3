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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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
fun CadastroScreen(navController: NavController) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp


    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var primeiroNomeTextField by remember { mutableStateOf("") }
    var ultimoNomeTextField by remember { mutableStateOf("") }
    var apelidoTextField by remember { mutableStateOf("") }
    var emailTextField by remember { mutableStateOf("") }
    var alturaTextField by remember { mutableStateOf("") }
    var pesoTextField by remember { mutableStateOf("") }
    var idadeTextField by remember { mutableStateOf("") }
    var senhaTextField by remember { mutableStateOf("") }
    var senhaConfirmTextField by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Box(modifier = Modifier.padding(10.dp)) {
            Text("Cadastro:", fontSize = 30.sp)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            OutlinedTextField(
                value = emailTextField,
                onValueChange = { emailTextField = it },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = senhaTextField,
                onValueChange = { senhaTextField = it },
                label = { Text("Senha") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 2.dp, 0.dp, 0.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            OutlinedTextField(
                value = senhaConfirmTextField,
                onValueChange = { senhaConfirmTextField = it },
                label = { Text("Confirma senha") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 2.dp, 0.dp, 0.dp),
                visualTransformation = PasswordVisualTransformation()
            )
            OutlinedTextField(
                value = primeiroNomeTextField,
                onValueChange = { primeiroNomeTextField = it },
                label = { Text("Primeiro nome") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 2.dp, 0.dp, 0.dp)
            )
            OutlinedTextField(
                value = ultimoNomeTextField,
                onValueChange = { ultimoNomeTextField = it },
                label = { Text("Ultimo nome") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 2.dp, 0.dp, 0.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = apelidoTextField,
                    onValueChange = { apelidoTextField = it },
                    label = { Text("Apelido") },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(0.dp, 2.dp, 10.dp, 0.dp)
                )
                OutlinedTextField(
                    value = idadeTextField,
                    onValueChange = { idadeTextField = it },
                    label = { Text("Idade") },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(10.dp, 2.dp, 0.dp, 0.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = alturaTextField,
                    onValueChange = { alturaTextField = it },
                    label = { Text("Altura") },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(0.dp, 2.dp, 10.dp, 0.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                OutlinedTextField(
                    value = pesoTextField,
                    onValueChange = { pesoTextField = it },
                    label = { Text("Peso") },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(10.dp, 2.dp, 0.dp, 0.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
        }





        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.Bottom) {
            Button(modifier = Modifier
                .fillMaxWidth(), onClick = {

//                val usuario = Usuario(
//                    emailTextField,
//                    senhaTextField,
//                    primeiroNomeTextField,
//                    ultimoNomeTextField,
//                    apelidoTextField,
//                    alturaTextField,
//                    pesoTextField,
//                    idadeTextField)
                val usuario = Usuario()
                usuario.email = emailTextField
                usuario.senha = senhaTextField
                usuario.primeiroNome = primeiroNomeTextField
                usuario.ultimoNome = ultimoNomeTextField
                usuario.apelido = apelidoTextField
                usuario.altura = alturaTextField.toDouble()
                usuario.peso = pesoTextField.toDouble()
                usuario.idade = idadeTextField.toInt()

                var mensagem = true

                scope.launch(Dispatchers.IO) {
                    if (senhaTextField != senhaConfirmTextField) {
                        mensagem = false
                    } else if (emailTextField.isEmpty()) {
                        mensagem = false
                    } else if (senhaTextField.isEmpty()) {
                        mensagem = false
                    } else if (primeiroNomeTextField.isEmpty()) {
                        mensagem = false
                    } else if (ultimoNomeTextField.isEmpty()) {
                        mensagem = false
                    } else if (alturaTextField.isEmpty()) {
                        mensagem = false
                    } else if (pesoTextField.isEmpty()) {
                        mensagem = false
                    } else if (idadeTextField.isEmpty()) {
                        mensagem = false
                    }

                    scope.launch(Dispatchers.Main){

                    }


                }

                scope.launch(Dispatchers.Main) {

                    if (emailTextField.isNotEmpty()&&senhaTextField.isNotEmpty()&&primeiroNomeTextField.isNotEmpty()&&ultimoNomeTextField.isNotEmpty()&&alturaTextField.isNotEmpty()&&pesoTextField.isNotEmpty()&&idadeTextField.isNotEmpty()){
                        usuario.validaUsuario(emailTextField, "").addOnCompleteListener() { querySnapshot ->
                            val emailValidacao = querySnapshot.result.data

                            if (emailValidacao == null) {
                                usuario.cadastraUsuario()
                            } else {
                                mensagem = false
                                Toast.makeText(
                                    context, "Email já existe", Toast.LENGTH_SHORT
                                ).show()

                            }

                            if (mensagem) {
                                Toast.makeText(
                                    context, "Cadastrado com sucesso.", Toast.LENGTH_SHORT
                                ).show()
                                navController.popBackStack()
                            } else if (senhaTextField != senhaConfirmTextField) {
                                Toast.makeText(context, "As senhas não são iguais.", Toast.LENGTH_SHORT
                                ).show()
                            } else if (emailTextField.isEmpty()) {
                                Toast.makeText(
                                    context, "E-mail precisa estar preenchido.", Toast.LENGTH_SHORT
                                ).show()
                            } else if (senhaTextField.isEmpty()) {
                                Toast.makeText(
                                    context, "Senha precisa estar preenchido.", Toast.LENGTH_SHORT
                                ).show()
                            } else if (primeiroNomeTextField.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Primeiro nome precisa estar preenchido.", Toast.LENGTH_SHORT
                                ).show()
                            } else if (ultimoNomeTextField.isEmpty()) {
                                Toast.makeText(
                                    context, "Ultimo nome precisa estar preenchido.", Toast.LENGTH_SHORT
                                ).show()
                            } else if (alturaTextField.isEmpty()) {
                                Toast.makeText(
                                    context, "Altura precisa estar preechido.", Toast.LENGTH_SHORT
                                ).show()
                            } else if (pesoTextField.isEmpty()) {
                                Toast.makeText(
                                    context, "Peso precisa estar preenchido.", Toast.LENGTH_SHORT
                                ).show()
                            } else if (idadeTextField.isEmpty()) {
                                Toast.makeText(
                                    context, "Idade precisa estar preechido.", Toast.LENGTH_SHORT
                                ).show()
                            }

                        }

                    }



                }

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