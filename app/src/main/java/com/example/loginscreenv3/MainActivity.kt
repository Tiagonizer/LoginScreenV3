package com.example.loginscreenv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loginscreenv3.ui.theme.LoginScreenV3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenV3Theme {
                MyApp()

            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController=navController,startDestination = "Login"){

        composable("Login"){
            LoginScreen(navController = navController)
        }

        composable("CadastroScreen") {
            CadastroScreen(navController = navController)
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginScreen(navController: NavController) {
//
//    val context = LocalContext.current
//
//    val usuario = "exemplo@gmail.com"
//    val senha = "123456"
//
//    var textFieldUsuario by remember { mutableStateOf("") }
//    var textFieldSenha by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                "\"App\"",
//                fontSize = 32.sp,
//                fontWeight = FontWeight.Bold,
//            )
//        }
//
//        Spacer(modifier = Modifier.height(66.dp))
//
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .padding()) {
//            OutlinedTextField(
//                value = textFieldUsuario,
//                onValueChange = { textFieldUsuario = it },
//                label = { Text("Usuário") },
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//
//        Spacer(modifier = Modifier.height(12.dp))
//
//        Box(modifier = Modifier
//            .fillMaxWidth()
//            .padding()) {
//            OutlinedTextField(
//                value = textFieldSenha,
//                onValueChange = { textFieldSenha = it },
//                label = { Text("Senha") },
//                modifier = Modifier.fillMaxWidth(),
//                visualTransformation = PasswordVisualTransformation()
//            )
//        }
//
//        Spacer(modifier = Modifier.height(38.dp))
//
//        Row(modifier = Modifier.padding(10.dp),verticalAlignment = Alignment.CenterVertically) {
//            //Box(modifier = Modifier
//            //    .fillMaxWidth()
//            //    .padding(10.dp),
//            //    contentAlignment = Alignment.Center) {
//                Button(modifier = Modifier.padding(10.dp), onClick = {
//
//                    if (textFieldUsuario != usuario) {
//                        Toast.makeText(context, "Usuario incorreto.", Toast.LENGTH_SHORT).show()
//                        return@Button
//                    }
//
//                    if (textFieldSenha != senha) {
//                        Toast.makeText(context, "Senha Incorreta", Toast.LENGTH_SHORT).show()
//                        return@Button
//                    }
//
//                    Toast.makeText(context, "Login bem sucedido.", Toast.LENGTH_SHORT).show()
//
//
//                if (textFieldUsuario==usuario){
//                    //Toast.makeText(context, "Usuario correto.", Toast.LENGTH_SHORT).show()
//                    if (textFieldSenha == senha) {
//                        Toast.makeText(context, "Login bem sucedido.", Toast.LENGTH_SHORT).show()
//                    } else {
//                        Toast.makeText(context, "Login falhou.", Toast.LENGTH_SHORT).show()
//                    }
//              }else{
//                    Toast.makeText(context, "Usuario incorreto.", Toast.LENGTH_SHORT).show()
//                }
//
//                }) {
//                    Text(text = "Entrar")
//                }
//           //}
//
//            //Box(modifier = Modifier
//            //    .fillMaxWidth()
//           //    .padding(10.dp),
//            //    contentAlignment = Alignment.Center){
//                Button(modifier = Modifier.padding(10.dp),onClick = {
//                    val isClicked = true
//                    if (isClicked) {
//                        navController.navigate("CadastroScreen")
//                    }
//
//                }) {
//                    Text(text = "Cadastrar-se")
//                }
//            //}
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    MyApp()
}

