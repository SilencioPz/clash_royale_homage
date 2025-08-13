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
fun MagiasScreen(navController: NavHostController) {

    val magias = listOf(
        Magia("FOGUETE", R.drawable.rocket, "Aparato de alto poder " +
                "destrutivo. Demora para invocar, tente não errar quando vier..."),
        Magia("RAIVA", R.drawable.rage, "Aumenta a velocidade de " +
                "ataque e movimento de suas tropas. Ideal para tropas próximas da torre inimiga."),
        Magia("ESPELHO", R.drawable.mirror, "Invoca um extra da " +
                "última carta usada, adicionando +1 ponto de elixir. Não invoca campeões."),
        Magia("BOLA DE FOGO", R.drawable.fireball, "Essa bola de fogo " +
                "de alcance curto destrói inimigos tanto no chão quanto no céu. " +
                "Também pode ser usada diretamente contra o castelo inimigo."),
        Magia("BÁRBARO NO BARRIL", R.drawable.barbarian_barrel, "Essa" +
                " magia invoca um bárbaro que depois que o barril quebra " +
                "em um determinado alvo, ele começa o ataque. Use como a carta A Tora, que é muito " +
                "parecida com esta."),
        Magia("FLECHAS", R.drawable.arrows, "Ao custo de 3 de elixir, " +
                "essa chuva de flechas ajuda a eliminar hordas de inimigos. É útil contra inimigos " +
                "fracos, contra tanques e mesmo contra o castelo não faz muita coisa..."),
        Magia("ZAP", R.drawable.zap, "Dois de elixir, efeito " +
                "instantâneo e ainda deixa o inimigo paralisado. Super efetivo contra grupos de " +
                "inimigos."),
        Magia("BOLA DE NEVE GIGANTE", R.drawable.giant_snowball, "Por " +
                "2 de elixir, essa bola irá gelar os inimigos e deixá-los lentos por 3 segundos. " +
                "Mais eficiente contra inimigos fracos e menores, os fortes e maiores apenas atrasa " +
                "mesmo."),
        Magia("ENTREGA REAL", R.drawable.royal_delivery, "Um recruta " +
                "real direto do céu para a cabeça de um inimigo desavisado. Causa dano a inimigos " +
                "aéreos ou do solo, porém serve apenas para defesa já que não pode ser invocado no " +
                "campo inimigo..."),
        Magia("TERREMOTO", R.drawable.earthquake, "Destrói pequenos " +
                "grupos de inimigos, atrasa unidades e causa danos ao castelo inimigo! Contudo, " +
                "NÃO CAUSA dano a unidades aéreas! XP"),
        Magia("DUENDE NO BARRIL", R.drawable.goblin_barrel, "Três " +
                "duendes que voam dentro de um barril e perfeitos para um ataque surpresa! Muito " +
                "usandos quando o castelo inimigo está próximo de ser destruído, é uma excelente " +
                "forma de gastar 3 de elixir."),
        Magia("RAIO", R.drawable.lightning, "Três raios destrutivos " +
                "caem sobre o alvo selecionado, destruindo-o ou tirando muita vida. Também deixa o " +
                "inimigo atordoado por meio segundo."),
        Magia("CONGELAR", R.drawable.freeze, "Atordoa por 4 segundos, " +
                "assim como danifica inimigos. Efetiva se usada como surpresa contra o inimigo, pois " +
                "se não tiver tropas defensivas os inimigos descongelados se juntarão com os normais " +
                "e aí meu amigo...já era!"),
        Magia("VENENO", R.drawable.poison, "Uma magia de 4 de elixir " +
                "que invoca uma nuvem de veneno em uma área e causa dano ENQUANTO o inimigo estiver " +
                "dentro da mesma. O bom é que se tem inimigos dentro da área, deixa-os lentos e " +
                "suscetíveis ao veneno."),
        Magia("MALDIÇÃO DO DUENDE", R.drawable.goblin_curse, "Causa " +
                "pouco dano, MAS caso mate inimigos os transforma em Duendes e os inimigos atacados " +
                "por estes recebem 20% a mais de dano! Versátil contra grupos e tanques!!! XD"),
        Magia("CLONE", R.drawable.clone, "Clona um aliado. O clonado " +
                "tem dano dobrado, ao custo de 1 ponto de vida apenas! Cuidado com dano em área, " +
                "não é efetivo com cartas de campeões e não funciona com Casas!"),
        Magia("TORNADO", R.drawable.tornado, "Junta inimigos em um " +
                "local só e causa um pouco de dano. Ideal para um ataque de tornado + bola de fogo " +
                "ou tornado + flechas, pois os inimigos estarão agrupados em um local fácil de " +
                "atingir."),
        Magia("VAZIO", R.drawable.void_spell, "Por 3 de elixir, é " +
                "invocado um buraco negro que causa 3 ataques a um inimigo. Pode causar ainda mais " +
                "dano contra grupos de 2-4 ou 5 ou mais inimigos."),
        Magia("A TORA", R.drawable.the_log, "Ao custo de 2 de elixir, " +
                "essa tora causa dano moderado e lança pra trás inimigos. Recomendada contra " +
                "inimigos fracos no solo, NÃO FUNCIONA contra aéreos!"),
        Magia("CEMITÉRIO", R.drawable.graveyard, "Custando 5 de " +
                "elixir, invoca pequenos esqueletos em QUALQUER LUGAR da arena. Efetiva contra " +
                "castelos inimigos sem proteção ou uma distração de último minuto de jogo.")
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
                        text = "MAGIA",
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
                items(magias) { magia ->
                    ClashCard1(
                        title = magia.nome,
                        imageRes = magia.imagemRes,
                        description = magia.descricao
                    )
                }
            }
        }
    }
}

@Composable
fun ClashCard1(
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

data class Magia(
    val nome: String,
    val imagemRes: Int,
    val descricao: String
)