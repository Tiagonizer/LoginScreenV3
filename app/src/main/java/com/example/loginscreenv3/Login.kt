package com.example.loginscreenv3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.loginscreenv3.ui.theme.LoginScreenV3Theme

@Composable
fun LoginScreen(navController: NavController) {

    val context = LocalContext.current

    val usuario = "exemplo@gmail.com"
    val senha = "123456"

    var textFieldUsuario by remember { mutableStateOf("") }
    var textFieldSenha by remember { mutableStateOf("") }
    var check by remember{ mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "\"App\"",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Spacer(modifier = Modifier.height(66.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding()) {
            OutlinedTextField(
                value = textFieldUsuario,
                onValueChange = { textFieldUsuario = it },
                label = { Text("Usuário") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding()) {
            OutlinedTextField(
                value = textFieldSenha,
                onValueChange = { textFieldSenha = it },
                label = { Text("Senha") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )
        }

        Row(modifier = Modifier
            .padding()
            .fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically){
            Box(modifier = Modifier.padding()){
                Checkbox(checked = check, onCheckedChange ={check = it} )
            }
            Box(modifier = Modifier.padding()){
                Text(text = "Lembrar usuário", fontWeight = FontWeight.Medium)
            }
        }


        Spacer(modifier = Modifier.height(38.dp))

        Row(modifier = Modifier.padding(10.dp),verticalAlignment = Alignment.CenterVertically) {
            //Box(modifier = Modifier
            //    .fillMaxWidth()
            //    .padding(10.dp),
            //    contentAlignment = Alignment.Center) {
            Button(modifier = Modifier.padding(10.dp), onClick = {

                if (textFieldUsuario != usuario) {
                    Toast.makeText(context, "Usuario incorreto.", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (textFieldSenha != senha) {
                    Toast.makeText(context, "Senha Incorreta.", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                Toast.makeText(context, "Login bem sucedido.", Toast.LENGTH_SHORT).show()


//                if (textFieldUsuario==usuario){
//                    //Toast.makeText(context, "Usuario correto.", Toast.LENGTH_SHORT).show()
//                    if (textFieldSenha == senha) {
//                        Toast.makeText(context, "Login bem sucedido.", Toast.LENGTH_SHORT).show()
//                    } else {
//                        Toast.makeText(context, "Login falhou.", Toast.LENGTH_SHORT).show()
//                    }
//                }else{
//                    Toast.makeText(context, "Usuario incorreto.", Toast.LENGTH_SHORT).show()
//                }

            }) {
                Text(text = "Entrar")
            }
            //}

            //Box(modifier = Modifier
            //    .fillMaxWidth()
            //    .padding(10.dp),
            //    contentAlignment = Alignment.Center){
            Button(modifier = Modifier.padding(10.dp),onClick = {
                val isClicked = true
                if (isClicked) {
                    navController.navigate("CadastroScreen")
                }

            }) {
                Text(text = "Cadastrar-se")
            }
            //}
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}