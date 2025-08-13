package com.example.clashzimdoscria.ui.theme.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.navigation.NavHostController
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
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
import com.example.clashzimdoscria.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TropasScreen(navController: NavHostController) {

    val context = LocalContext.current

    val tropas = listOf(
        Tropa("CAVALEIRO", R.drawable.knight,
            "Guerreiro versátil. Dano moderado, ataca um único inimigo."),
        Tropa("MAGO DE FOGO", R.drawable.fire_mage,
            "Atira bolas de fogo que atingem inimigos em terra e ar."),
        Tropa("MAGO DE GELO", R.drawable.ice_wizard,
            "Dano moderado, mas gela os inimigos e os torna lentos e vulneráveis a " +
                    "ataques."),
        Tropa("BÁRBAROS", R.drawable.barbarians,
            "Cinco bárbaros que atacam um único alvo. Atributos moderados, só atacam " +
                    "no chão."),
        Tropa("PORCOS REAIS", R.drawable.royal_hog,
            "Quatro porcos com vida moderada e dano baixo. São rápidos e vão direto " +
                    "para a torre inimiga."),
        Tropa("BANDIDA", R.drawable.bandit,
            "Rápida e rasteira, mata rapidamente os inimigos. Porém, é vulnerável e " +
                    "morre facilmente para tropas fortes..."),
        Tropa("BÁRBAROS DE ELITE", R.drawable.elite_barbarians,
            "Uma dupla de bárbaros. São fortes, mas se distraem facilmente e morrem " +
                    "facilmente para grupos de inimigos."),
        Tropa("FORNALHA", R.drawable.furnace,
            "Fornalha mecânica que ataca de longe. Invoca Espíritos de fogo a cada cinco " +
                    "segundos, detonando grupos de inimigos e botando pressão."),
        Tropa("BRUXA NOTURNA", R.drawable.night_witch,
            "A irmã-má da bruxa, vida e dano moderado. Mas invoca morcegos, que ajudam o " +
                    "jogador a pressionar o inimigo."),
        Tropa("CURANDEIRA DE BATALHA", R.drawable.battle_healer,
            "Vida alta e dano mediano, ela cura a si mesma e aos aliados próximos. " +
                    "Apesar de voar, não ataca inimigos voadores..."),
        Tropa("EXECUTOR", R.drawable.executioner,
            "Vida alta e um machado devastador que acerta tanto no chão quanto no ar. " +
                    "Seu ataque estilo bumerangue é letal, mas é lento e fica vulnerável a grandes " +
                    "grupos de inimigos..."),
        Tropa("DRAGÃO BEBÊ", R.drawable.baby_dragon,
            "Possui vida alta e rápido ataque, além do seu dano em área. Ele é um " +
                    "mini-tanque, mas é fraco contra inimigos com dano alto e demora a matar os " +
                    "inimigos..."),
        Tropa("FAÍSCA", R.drawable.sparky,
            "Dano absurdo e com muita vida, pulveriza o inimigo a cada quatro segundos. " +
                    "Porém é muito lento, tornando-se um alvo fácil e também se distrai por outros " +
                    "inimigos..."),
        Tropa("MEGA CAVALEIRO", R.drawable.mega_knight,
            "Assim que pousa, causa dano aos inimigos. Em seguida, pula até o inimigo " +
                    "mais próximo. Caso ele não pule, manda uma tapa que causa dano em área. Apesar " +
                    "do alto dano, é vagaroso e pode ser eliminado facilmente por inimigos poderosos. "),
        Tropa("VALQUÍRIA", R.drawable.valkyrie,
            "Possui muita vida, usa seu machado em um ataque 360 graus e é um ótimo " +
                    "suporte às suas tropas. Porém, só ataca inimigos no solo e sua lerdeza a " +
                    "tornam vulnerável a inimigos de longa distância..."),
        Tropa("RECRUTAS REAIS", R.drawable.royal_recruits,
            "Seis soldados durões que aparecem em formação horizontal. Servem para " +
                    "distrair e repelir danos massivos com seus escudos, ajudando tropas na " +
                    "retaguarda."),
        Tropa("TRÊS MOSQUETEIRAS", R.drawable.three_musketeers,
            "Três atiradoras com vida média e alcance longo. Acertam quase tudo com seus " +
                    "mosquetes, porém cuidado! Custam 9 de elixir e são vulneráveis a magias " +
                    "destrutivas!"),
        Tropa("LENHADOR", R.drawable.lumberjack,
            "O famoso 'canhão de vidro', ele tem vida média mas tem velocidade e dano " +
                    "alto. Ele destói desde tanques a torres, com ataques rápidos e destrutivos " +
                    "sendo ideal para uma estratégia de defesa ou ataque." ),
        Tropa("DOMADORA DE CARNEIROS", R.drawable.ram_rider,
            "Assim que entra na arena, seu fiel carneiro avança para o castelo inimigo " +
                    "enquanto ela usa Bolas contra os inimigos. Ela também pula o rio, sendo rápida " +
                    "e versátil por 5 de elixir!" )
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
                            text = "Wiki do jogo Clash Royale, site com TODAS as tropas do jogo",
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
                                    Uri.parse("https://clashroyale.fandom.com/wiki/Category:Troop_Cards"))
                                context.startActivity(intent)
                            }
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.troop_cards),
                                contentDescription = "Troop_Cards - Clique para acessar o site",
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
                    ClashCard(
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
fun ClashCard(
    title: String,
    imageRes: Int,
    description: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x801A2A6C) // Azul escuro semi-transparente
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color(0xFFFFD700)) // Borda dourada
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(imageRes),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black,
                color = Color(0xFFFFD700), // Dourado
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

data class Tropa(
    val nome: String,
    val imagemRes: Int,
    val descricao: String
)