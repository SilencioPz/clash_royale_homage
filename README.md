# 👑 **CLASHZIM DOS CRIA**  

### *O APP DAS ESTRATÉGIAS CLASH ROYALE QUE VAI TURBINAR SEU JOGO!*  

*(Porque vencer no clash é arte, e arte a gente estuda! 👊🔥)*  

----------------------------------------------------------------------------------------------------
## 🎮 **FUNCIONALIDADES**  

### 🏰 **TROPAS DO JOGO**  

Apanhado sobre algumas tropas usadas e um link para um site que fala sobre todas.

### 🃏 **BARALHO DO CRIA**  

Estratégias de três decks testados e aprovados pela irmão do desenvolvedor.  

### 🌐 **WIKI INTEGRADA**  

Links diretos para a wiki oficial.  
----------------------------------------------------------------------------------------------------
## 🛠️ **TECNOLOGIAS**  

| Componente       | Tecnologia Usada          |  

|------------------|--------------------------|  

| Linguagem        | Kotlin 2.0 + Jetpack Compose |  

| UI               | 100% Compose (Material 3) |  

| Navegação        | Navigation Compose        |  

| Imagens          | Drawable + Zoom customizado |  

----------------------------------------------------------------------------------------------------
## 📂 **ESTRUTURA DO PROJETO**  

ClashzimDosCria/  

├── app/  

│   ├── src/main/java/com/example/clashzimdoscria/  

│   │   ├── screens/      # MenuScreen, ModosScreen, EstrategiasScreen...

│   │   ├── MainActivity.kt  

│   │   └── theme/        # Cores no estilo Clash (azul, vermelho, dourado)  

├── build.gradle.kts      # Dependências principais  

├── libs.versions.toml    # Controle de versões  

----------------------------------------------------------------------------------------------------
📜 DEPENDÊNCIAS (já configuradas no projeto)

// Jetpack Compose  

implementation(libs.androidx.activity.compose)  

implementation(platform(libs.androidx.compose.bom))  

implementation(libs.androidx.material3)  

// Navegação  

implementation(libs.androidx.navigation.compose)  

----------------------------------------------------------------------------------------------------
🔧 VERSÕES CRÍTICAS

    Gradle: 8.12

    JDK: 11 (Requisito do Kotlin 2.0)

    Android Studio: Electric Eel ou superior
----------------------------------------------------------------------------------------------------
💻 COMO RODAR (Linux/Windows)

Terminal (Linux/macOS):

git clone https://github.com/seu-usuario/ClashzimDosCria.git
cd ClashzimDosCria
./gradlew assembleDebug
----------------------------------------------------------------------------------------------------
PowerShell (Windows):

git clone https://github.com/seu-usuario/ClashzimDosCria.git
cd ClashzimDosCria
.\gradlew.bat assembleDebug

----------------------------------------------------------------------------------------------------
Android Studio:

    Abra o projeto.

    Build > Make Project.

    Rode no emulador (Pixel 5 com API 34+ recomendado).
----------------------------------------------------------------------------------------------------
🎨 PREVIEW

https://imgur.com/a/bFkofw6
---------------------------------------------------------------------------------------------------
🚀 ROADMAP

Feature	                            Status

Calculadora de Elixir	              💡 Planejado

Estratégias de um jogador ativo     ✅ Pronto
---------------------------------------------------------------------------------------------------
📌 LICENÇA

Open-source sob MIT - use, modifique e batalhe como um verdadeiro clashzeiro!

Feito com raiva de Torre Inferno e amor por 3 coroas em Rondonópolis/MT!
"Se não tá ganhando, é porque não viu esse app ainda!" 😎📱
