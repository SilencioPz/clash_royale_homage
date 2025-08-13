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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
fun ModosScreen(navController: NavHostController) {

    val context = LocalContext.current

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
                        text = "ARENAS",
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
                contentPadding = PaddingValues(vertical = 16.dp)
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
                            text = "Wiki do jogo Clash Royale, site com TODAS as Arenas do jogo. " +
                                    "São 25 (contando o tutorial) ao todo, você pode juntar novas " +
                                    "cartas até a arena 18.",
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
                                        Uri.parse("https://clashroyale.fandom.com/wiki/Arenas"))
                                    context.startActivity(intent)
                                }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.arenas),
                                contentDescription = "Arenas - Clique para acessar o site",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.height(150.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}