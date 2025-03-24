# App Motivation 

Aplicativo feito para fins de estudo, onde inserimos o nome de usuário e somos direcionados à um tela onde podemos escolher tipos de frases, onde esses tipos são como momentos, e recebo 
uma frase pelo filtro que eu escolhi.

<img width="200" alt="Captura de Tela 2025-03-24 às 18 51 06" src="https://github.com/user-attachments/assets/da0fe9da-40bd-4fea-ab61-b20281124c30" />  
<img width="200" alt="Captura de Tela 2025-03-24 às 18 51 29" src="https://github.com/user-attachments/assets/4f7f8ed0-4765-4328-a85e-5df9c4f2f327" />

## Filtros 
Simbolo Infinty = Qualquer frase sobre qualquer momento, de forma randomica  
Simbolo Happy = Frases motivacionais sobre o bem-estar geral  
Simbolo Sunny = Frases para motivação do dia a dia  



  
# Código
Feito totalmente me kotlin, as pastas são organizadas da seguinte forma:  
  
•*UI*: MainActivity, HomeActivity e PhraseRepository - Interação do usuário onde insere o seu nome na pagina main, passa para o home onde recebe as frases, e essas frases estão armazenadas na classe PhraseRepository
  
•*Utils*: AppConstants - Constantes do app onde armazeno as keys.  
  
•*Business*: SecurityPreferences - Armazenamento do nome do usuário para autenticação e replica-lo em outras Activits.  
