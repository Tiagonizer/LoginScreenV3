package com.example.loginscreenv3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginscreenv3.ui.theme.LoginScreenV3Theme

@Composable
fun Postagens(navController: NavController) {
    LoginScreenV3Theme {
        PostagensScreenContent()
    }
}
@Composable
fun PostagensScreen(navController: NavController) {
    LoginScreenV3Theme {
        PostagensScreenContent() // Conteúdo da tela
    }
}

@Composable
fun PostagensScreenContent() {
    // Usando LazyColumn para a barra de rolagem
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Vamos criar 10 postagens de exemplo
        items(10) {
            PostagemItem()
            Spacer(modifier = Modifier.height(16.dp)) // Espaço entre as postagens
        }
    }
}

@Composable
fun PostagemItem() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        // Linha de informações do usuário
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagem circular do usuário
            Image(
                painter = painterResource(id = R.drawable.avatar1), // Substitua pelo ID da sua imagem de usuário
                contentDescription = "Foto do Usuário",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .background(Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))

            // Nome do usuário
            Text(
                text = "Nome do Usuário",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Imagem da postagem
        Image(
            painter = painterResource(id = R.drawable.post_image_1), // Substitua pela imagem da postagem
            contentDescription = "Imagem da Postagem",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Hora da postagem
        Text(
            text = "Postado há 1 hora",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostagensScreenPreview() {
    LoginScreenV3Theme {
        PostagensScreenContent()
    }
}
