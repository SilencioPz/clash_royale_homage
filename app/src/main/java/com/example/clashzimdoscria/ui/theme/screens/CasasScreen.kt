package com.example.clashzimdoscria.ui.theme.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.clashzimdoscria.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CasasScreen(navController: NavHostController) {
    val casas = listOf(
        Casa("TORRE BOMBA", R.drawable.bomb_tower, "Ideal contra " +
                "grupos de inimigos, a torre é ideal para dano em área. Ataca devagar, contra " +
                "tanques não é efetiva..."),
        Casa("CANHÃO", R.drawable.cannon, "Vida moderada, dano e " +
                "dura pouco se comparada com outras Casas. Mas com a estratégia e o ciclo certo, " +
                "esta carta será muito útil aliada a outras cardas e com sua evolução - bem mais " +
                "poderosa e versátil!"),
        Casa("MORTEIRO", R.drawable.mortar, "Foca no castelo inimigo," +
                " vida moderada e ignora inimigos próximos. Contudo, deve ter aliados ao redor para " +
                "continuar seu ataque, que é lento."),
        Casa("TESLA", R.drawable.tesla, "Custa 4 de elixir, vida e " +
                "dano moderado e eletrifica inimigos. Também se esconde de inimigos distantes, " +
                "sendo vulnerável ao Terremoto e Congelar. Sua evolução valhe a pena."),
        Casa("GAIOLA DE DUENDE", R.drawable.goblin_cage, "O duende " +
                "dentro da gaiola chama a atenção de inimigos próximos, que a destróem e o " +
                "libertam, iniciando uma briga. O duende causa dano alto, porém tem vida moderada. " +
                "Excelente para defesa do castelo!"),
        Casa("CABANA DE DUENDE", R.drawable.goblin_hut, "Ao custo de " +
                "4 de elixir, invoca duendes da cabana a cada 1.9 segundos SE um inimigo estiver a " +
                "6 blocos dela. Se não tiver inimigos, fica dormente. Por fim, quando a cabana se " +
                "destrói, um duende solitário sai ao ataque. Ideal para defesa da torre ou de uma " +
                "unidade tanque."),
        Casa("LÁPIDE", R.drawable.tombstone, "Vida moderada e fácil " +
                "de invocar, ao custo de 3 de elixir. Invoca dois esqueletos a cada 3.5 segundos, " +
                "e invoca quatro esqueletos quando se destrói. Pode tanto atacar quanto distrair " +
                "unidades próximas, sendo uma Casa muito versátil."),
        Casa("TORRE INFERNO", R.drawable.inferno_tower, "Ao custo de " +
                "5 de elixir, este incinerador pulveriza tanques e inimigos de suporte rapidamente. " +
                "Mas cuidado! Grupos de pequenos inimigos e eletricidade atordoam esta Casa " +
                "rapidamente..."),
        Casa("CABANA DE BÁRBARO", R.drawable.barbarian_hut, "Custa " +
                "6 de elixir e invoca três bárbaros a cada 15 segundos. Porém, os bárbaros são " +
                "mortos facilmente e custa muito invocar esta Casa..."),
        Casa("COLETOR DE ELIXIR", R.drawable.elixir_collector, "Esta " +
                "Casa tem vida moderada e te dá um bônus máximo de 8 de elixir enquanto viva. Dois " +
                "grandes poréns: não aparece na mão inicial e é vulnerável a magias."),
        Casa("ARCO-X", R.drawable.x_bow, "Este arco de 6 de elixir " +
                "tem: vida moderada, dano baixo, alcance longo e velocidade alta de ataque. Porém, " +
                "se distrai facilmente e é um alvo fácil de magias e grandes grupos de inimigos."),
        Casa("FURADEIRA DUENDE", R.drawable.goblin_drill, "Custando " +
                "4 de elixir, esta máquina é invocada em qualquer lugar da arena e dentro dela sai " +
                "vários duendes. Quando é destruída, saem dois duendes. É recomendado evoluir esta " +
                "Casa, pois é ainda mais destrutiva contra o castelo inimigo.")
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
                        text = "CASAS",
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
                items(casas) { casa ->
                    ClashCard2(
                        title = casa.nome,
                        imageRes = casa.imagemRes,
                        description = casa.descricao
                    )
                }
            }
        }
    }
}

@Composable
fun ClashCard2(
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

data class Casa(
    val nome: String,
    val imagemRes: Int,
    val descricao: String
)