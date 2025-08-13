package com.example.clashzimdoscria.ui.theme.screens

import androidx.compose.ui.geometry.Offset
import androidx.navigation.NavHostController
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clashzimdoscria.R

@Composable
fun MenuScreen(navController: NavHostController) {

    val clashGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF1A2A6C),  // Azul escuro
            Color(0xFFB21F1F),  // Vermelho
            Color(0xFFFDBB2D)   // Amarelo
        )
    )

    Box(modifier = Modifier
        .fillMaxSize()
        .background(clashGradient)
    ) {
        Image(
            painter = painterResource(id = R.drawable.clash_background_pattern),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(Color(0x40000000))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(
                    colors = listOf(Color.Transparent, Color(0x80000000))
                ))
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                val infiniteTransition = rememberInfiniteTransition()
                val glowIntensity by infiniteTransition.animateFloat(
                    initialValue = 0.8f,
                    targetValue = 1.2f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(1000, easing = FastOutSlowInEasing),
                        repeatMode = RepeatMode.Reverse
                    )
                )

                Image(
                    painter = painterResource(id = R.drawable.king_smiling_human),
                    contentDescription = "Rei Sorridente",
                    modifier = Modifier
                        .size(120.dp)
                        .shadow(16.dp, shape = CircleShape),
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.colorMatrix(
                        ColorMatrix().apply {
                            setToScale(
                                redScale = glowIntensity * 1.2f,
                                greenScale = glowIntensity * 1.2f,
                                blueScale = glowIntensity * 0.9f,
                                alphaScale = 1f
                            )
                        }
                    )
                )

                Text(
                    text = "CLASHZIM DOS CRIA",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFFFFD700),
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 8.dp),
                    style = MaterialTheme.typography.headlineLarge.copy(
                        shadow = Shadow(
                            color = Color(0xFF8B0000),
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    )
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ClashButton(
                    text = "TROPAS",
                    iconRes = R.drawable.ic_card_icon,
                    onClick = { navController.navigate("tropas") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                ClashButton(
                    text = "CASAS",
                    iconRes = R.drawable.ic_house_icon,
                    onClick = { navController.navigate("casas") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                ClashButton(
                    text = "MAGIAS",
                    iconRes = R.drawable.ic_magic_icon,
                    onClick = { navController.navigate("magias") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                ClashButton(
                    text = "ARENAS",
                    iconRes = R.drawable.ic_arena_icon,
                    onClick = { navController.navigate("modos") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                ClashButton(
                    text = "ESTRATÉGIAS",
                    iconRes = R.drawable.ic_strategy_icon,
                    onClick = { navController.navigate("estrategias") }
                )

                Spacer(modifier = Modifier.height(12.dp))

                ClashButton(
                    text = "SOBRE",
                    iconRes = R.drawable.ic_info_icon,
                    onClick = { navController.navigate("sobre") }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Clash Royale é um produto da Supercell. Todos os direitos reservados.",
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 16.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Um projeto de entusiasta aos fãs de Clash Royale! XD",
                    color = Color.White,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall.copy(
                        shadow = Shadow(
                            color = Color.Black,
                            offset = Offset(1f, 1f),
                            blurRadius = 2f
                        )
                    )
                )
            }
        }
    }
}

@Composable
private fun ClashButton(
    text: String,
    iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(0.7f)
            .height(52.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                spotColor = Color(0x40FFD700)
            ),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1A2A6C),
            contentColor = Color(0xFFFFD700)
        ),
        border = BorderStroke(
            width = 2.dp,
            color = Color(0xFFFFD700)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp),
                colorFilter = ColorFilter.tint(Color(0xFFFFD700))
            )
            Text(
                text = text,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.labelLarge.copy(
                    shadow = Shadow(
                        color = Color.Black,
                        offset = Offset(1f, 1f),
                        blurRadius = 2f
                    )
                )
            )
        }
    }
}