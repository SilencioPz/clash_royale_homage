package com.example.clashzimdoscria.ui.theme.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
fun SobreScreen(navController: NavHostController) {

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
                        text = "SOBRE O JOGO",
                        color = Color(0xFFFFD700)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBack,
                            "Voltar",
                            tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black)
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Black
            ) {
                Column {
                    Button(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF8B0000),
                            contentColor = Color(0xFFFFD700)
                        )
                    ) {
                        Text("VOLTAR AO MENU")
                    }
                }
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(clashGradient),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "RECOMENDAÇÕES CLASHZEIRAS",
                    color = Color(0xFFFFD700),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Supercell - site oficial do jogo Clash Royale",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://supercell.com/en/games/clashroyale/"))
                            context.startActivity(intent)
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.clash_royale),
                            contentDescription = "Supercell - Clique para acessar o site"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Clash Royale Wiki - site com tudo sobre Clash Royale",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://clashroyale.fandom.com/wiki/Clash_Royale_Wiki"))
                            context.startActivity(intent)
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.clash_royale_wiki),
                            contentDescription = "ClashRoyaleWiki - Clique para acessar o site"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "SilencioPz - dev deste app! XD",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier.clickable {
                            val intent = Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://silenciopz.neocities.org/"))
                            context.startActivity(intent)
                        }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.silencio_pz_site),
                            contentDescription = "SilencioPz - Clique para acessar o site"
                        )
                    }
                }
            }
        }
    }
}