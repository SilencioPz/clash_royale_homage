package com.example.clashzimdoscria.ui.theme.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.clashzimdoscria.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstrategiasScreen(navController: NavHostController) {
    val context = LocalContext.current

    val tropas = listOf(
        Estrategia("ESTRATEGIA 1", R.drawable.main_dudu,
            "Deck principal do meu irmão. Usa 5 tropas de diferentes raridades e 3 " +
                    "magias para vencer a partida."),
        Estrategia("ESTRATEGIA 2", R.drawable.secondary_dudu,
            "Deck secundário dele, usa 7 tropas de diferentes raridades e uma Casa usada" +
                    "para defesa, em um primeiro momento."),
        Estrategia("ESTRATÉGIA 3", R.drawable.tertiary_dudu,
            "Deck terciário dele, usa 6 tropas de diferentes raridades e duas magias. A " +
                    "única carta voltada para defesa são os Recrutas Reais, deck altamente ofensivo.")
    )

    val clashGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1A2A6C),  // Azul escuro
            Color(0xFFB21F1F),  // Vermelho
            Color(0xFFFDBB2D)   // Amarelo
        )
    )

    Scaffold(
    topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "TROPAS",
                    color = Color(0xFFFFD700), // Dourado
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        "Voltar",
                        tint = Color.White
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFF1A2A6C) // Azul escuro do Clash
            )
        )
    },
    bottomBar = {
        BottomAppBar(
            containerColor = Color(0xFF1A2A6C) // Azul escuro do Clash
        ) {
            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB21F1F), // Vermelho do Clash
                    contentColor = Color(0xFFFFD700)   // Dourado
                ),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Color(0xFFFFD700))
            ) {
                Text("VOLTAR AO MENU", fontWeight = FontWeight.Bold)
            }
        }
    },
    containerColor = Color.Transparent
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(clashGradient)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 8.dp)
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 24.dp)
                            .background(
                                color = Color(0x801A2A6C),
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Wiki do jogo Clash Royale, site com Estratégias de Deck da comunidade.",
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(bottom = 12.dp),
                            textAlign = TextAlign.Center
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .clickable {
                                    val intent = Intent(Intent.ACTION_VIEW,
                                        Uri.parse("https://clashroyale.fandom.com/wiki/Category:Battle_Decks"))
                                    context.startActivity(intent)
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.battle_decks),
                                contentDescription = "Battle_Decks - Clique para acessar o site",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.height(150.dp)
                            )
                        }
                    }
                }

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .height(1.dp)
                            .background(Color(0xFFFFD700).copy(alpha = 0.5f))
                    )
                }

                items(tropas) { tropa ->
                    ClashCard3(
                        title = tropa.nome,
                        imageRes = tropa.imagemRes,
                        description = tropa.descricao
                    )
                }
            }
        }
    }
}

@Composable
fun ClashCard3(
    title: String,
    imageRes: Int,
    description: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x801A2A6C)
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color(0xFFFFD700))
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ZoomableItemCard(
                imageRes = imageRes,
                contentDescription = title
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                color = Color(0xFFFFD700),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = description,
                fontSize = 14.sp,
                lineHeight = 18.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun ZoomableItemCard(
    imageRes: Int,
    contentDescription: String
) {
    var zoomLevel by remember { mutableFloatStateOf(1f) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { zoomLevel = (zoomLevel - 0.2f).coerceAtLeast(1f) },
                    enabled = zoomLevel > 1f
                ) {
                    Icon(
                        Icons.Default.Close,
                        contentDescription = "Diminuir zoom",
                        tint = if (zoomLevel > 1f) Color(0xFFFFD700) else Color.Gray
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Zoom: ${(zoomLevel * 100).toInt()}%",
                        color = Color(0xFFFFD700),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Slider(
                        value = zoomLevel,
                        onValueChange = { zoomLevel = it },
                        valueRange = 1f..3f,
                        modifier = Modifier.fillMaxWidth(),
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFFFFD700),
                            activeTrackColor = Color(0xFFFFD700),
                            inactiveTrackColor = Color.Gray
                        )
                    )
                }

                IconButton(
                    onClick = { zoomLevel = (zoomLevel + 0.2f).coerceAtMost(3f) },
                    enabled = zoomLevel < 3f
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Aumentar zoom",
                        tint = if (zoomLevel < 3f) Color(0xFFFFD700) else Color.Gray
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(MaterialTheme.shapes.medium)
            ) {
                Image(
                    painter = painterResource(imageRes),
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            scaleX = zoomLevel
                            scaleY = zoomLevel
                        },
                    contentScale = ContentScale.Fit
                )
            }
        }
    }
}

data class Estrategia(
    val nome: String,
    val imagemRes: Int,
    val descricao: String
)