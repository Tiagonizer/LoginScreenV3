package com.example.loginscreenv3

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreenv3.R

@Composable
fun IconScreen() {
    // Variável de estado para o contador de ofensivas
    var streakCount by remember { mutableIntStateOf(3) } // Exemplo de contador de ofensivas

    val iconList = listOf(
        R.drawable.icon_agua,
        R.drawable.icon_dieta,
        R.drawable.icon_fastfood,
        R.drawable.icon_higiene,
        R.drawable.icon_maca
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Exibe o contador de "ofensivas" no topo
        Text(
            text = "Ofensivas: $streakCount",
            style = MaterialTheme.typography.headlineLarge, // Usando headlineLarge no lugar de h4
            modifier = Modifier.padding(16.dp)
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(iconList) { index, iconId ->
                IconRow(iconId = iconId, isLeft = index % 2 == 0)
            }
        }
    }
}

@Composable
fun IconRow(iconId: Int, isLeft: Boolean) {
    var selected by remember { mutableStateOf(false) }

    // Organiza o layout dos ícones para serem intercalados entre esquerda e direita
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = if (isLeft) Arrangement.Start else Arrangement.End
    ) {
        // Coloca o ícone e a seta
        IconWithArrow(iconId = iconId, selected = selected, isLeft = isLeft, onSelect = { selected = it })
    }
}

@Composable
fun IconWithArrow(iconId: Int, selected: Boolean, isLeft: Boolean, onSelect: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isLeft) Arrangement.Start else Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (isLeft) {
            // Ícone do desafio na esquerda
            IconWithLine(iconId = iconId, selected = selected, onSelect = onSelect)

            // Seta à direita do ícone (apontando para baixo e à direita)
            Image(
                painter = painterResource(id = R.drawable.direitabaixo), // Seta para baixo e direita
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 8.dp)

            )
        } else {
            // Seta à esquerda do ícone (apontando para baixo e à esquerda)
            Image(
                painter = painterResource(id = R.drawable.esquerdabaixo), // Seta para baixo e esquerda
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 8.dp)
            )

            // Ícone do desafio na direita
            IconWithLine(iconId = iconId, selected = selected, onSelect = onSelect)
        }
    }
}

@Composable
fun IconWithLine(iconId: Int, selected: Boolean, onSelect: (Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .clickable { onSelect(!selected) }
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
                .padding(8.dp)
                .let { if (selected) it else it }
        )

        if (selected) {
            Surface(
                shape = CircleShape,
                color = Color.Green.copy(alpha = 0.3f),
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            ) {}
        }
    }

    // Desenha a linha
    Canvas(
        modifier = Modifier
            .height(100.dp)
            .width(2.dp)
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(0f, 0f),
            end = Offset(0f, size.height),
            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconScreen() {
    IconScreen()
}
