import java.util.Scanner; 
import java.util.concurrent.TimeUnit; // Para as pausas (simular efeito de digitação)

public class MissaoSideral {

    // --- Métodos de Auxílio para Estética ---
    public static void limparTela() {
        for (int i = 0; i < 15; ++i) System.out.println(); 
    }

    public static void exibirMensagem(String tipo, String mensagem) {
        if (tipo.equals("sucesso")) {
            System.out.println("\n=====================================");
            System.out.println("              SUCESSO!               ");
            System.out.println("            " + mensagem + " ❤️");
            System.out.println("=====================================\n");
        } else if (tipo.equals("falha")) {
            System.out.println("\n=====================================");
            System.out.println("               FALHA!                ");
            System.out.println("            " + mensagem + " ❌");
            System.out.println("=====================================\n");
        }
    }

    public static void exibirTitulo(String titulo) {
        String borda = "=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*";
        System.out.println("\n" + borda);
        int larguraBorda = borda.length();
        int tamanhoTitulo = titulo.length();
        int espacosAntes = (larguraBorda - tamanhoTitulo) / 2;
        if (espacosAntes < 0) espacosAntes = 0;
        System.out.print(" ".repeat(espacosAntes));
        System.out.println(titulo.toUpperCase());
        System.out.println(borda + "\n");
    }

    public static void digitarTexto(String texto, long atrasoMilis) {
        for (char caractere : texto.toCharArray()) {
            System.out.print(caractere);
            try {
                TimeUnit.MILLISECONDS.sleep(atrasoMilis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    public static void esperarEnter(Scanner input) {
        System.out.println("\n\n(Pressione ENTER para continuar...)");
        input.nextLine();
        limparTela();
    }

    public static void mostrarAcertosAtuais(int acertos, int totalDesafios) {
        System.out.println("\n<<<<<<<<<< PONTUAÇÃO ATUAL >>>>>>>>>>");
        digitarTexto("    Você venceu " + acertos + " de " + totalDesafios + " desafios até agora!", 20);
        System.out.println("<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>\n");
    }

    public static String formatarCelula(String texto, int larguraTotalCelula) {
        int tamanhoTexto = texto.length();
        if (tamanhoTexto >= larguraTotalCelula) {
            return texto.substring(0, larguraTotalCelula);
        }
        int espacosAntes = (larguraTotalCelula - tamanhoTexto) / 2;
        int espacosDepois = larguraTotalCelula - tamanhoTexto - espacosAntes;
        return " ".repeat(espacosAntes) + texto + " ".repeat(espacosDepois);
    }

    public static String formatarLinhaDentroDaCaixa(String texto, int larguraInternaCaixa) {
        int tamanhoTexto = texto.length();
        if (tamanhoTexto >= larguraInternaCaixa) {
            return texto.substring(0, Math.min(texto.length(), larguraInternaCaixa));
        }
        int espacosAntes = (larguraInternaCaixa - tamanhoTexto) / 2;
        int espacosDepois = larguraInternaCaixa - tamanhoTexto - espacosAntes;
        return " ".repeat(espacosAntes) + texto + " ".repeat(espacosDepois);
    }
    
    public static String obterEntradaVF(Scanner input, String mensagemPrompt) {
        String resposta;
        while (true) {
            System.out.println(mensagemPrompt); 
            resposta = input.nextLine().toUpperCase().trim(); 
            if (resposta.equals("V") || resposta.equals("F")) {
                return resposta; 
            } else {
                System.out.println("\n❌ Opção inválida! ❌");
                digitarTexto("Por favor, digite apenas 'V' para Verdadeiro ou 'F' para Falso.", 20);
                System.out.println("-----------------------------------------------------------\n");
            }
        }
    }

    // --- MÉTODOS PARA O MENU PRINCIPAL ---
    public static void exibirInstrucoes(Scanner input) {
        limparTela();
        exibirTitulo("INSTRUÇÕES DO JOGO");
        digitarTexto("Bem-vindo(a) à AETHER: A Missão Sideral!", 20);
        digitarTexto("Você é ÁREA, a Inteligência Artificial encarregada de manter a nave AETHER funcional.", 20);
        digitarTexto("Ao longo de 12 capítulos, você enfrentará 11 desafios de lógica Booleana.", 20);
        digitarTexto("Para cada desafio, responda com 'V' para Verdadeiro ou 'F' para Falso.", 20);
        digitarTexto("Suas escolhas determinarão o sucesso da missão e a segurança dos 4.000 tripulantes.", 20);
        digitarTexto("Seu placar de acertos será mostrado ao final de cada capítulo e no final da aventura.", 20);
        digitarTexto("Use sua lógica e preste atenção aos detalhes da história!", 20);
        digitarTexto("Boa sorte, e que a Álgebra Booleana esteja com você!", 20);
        System.out.println("\n\n(Pressione ENTER para voltar ao Menu Principal...)");
        input.nextLine(); 
    }

    public static void exibirCreditos(Scanner input) {
        limparTela();
        exibirTitulo("CRÉDITOS");
        digitarTexto("AETHER: A Missão Sideral", 30);
        digitarTexto("Jogo desenvolvido por: [SEU NOME OU NOME DO GRUPO AQUI]", 30); // PREENCHA AQUI
        digitarTexto("Projeto para a disciplina de [Projeto Integrador]", 30);    // PREENCHA AQUI
        digitarTexto("Instituição: [Centro Universitário Senac]", 30);            // PREENCHA AQUI
        digitarTexto("Agradecimentos: Assistente JAVAzin pela ajuda cósmica! 😉", 20);
        System.out.println("\n\n(Pressione ENTER para voltar ao Menu Principal...)");
        input.nextLine();
    }

    public static void exibirLinkChatbot(Scanner input) {
        limparTela();
        exibirTitulo("CHATBOT DA MISSÃO");
        digitarTexto("Quer interagir com o chatbot da AETHER no WhatsApp?", 20);
        digitarTexto("Ele pode te dar dicas ou informações extras sobre o universo do jogo!", 20);
        digitarTexto("Copie o link abaixo e cole no seu navegador de internet:", 20);
        
        System.out.println("\nhttps://wa.me/qr/MXVTITYEPEPXK1"); 
        
        digitarTexto("Você precisará copiar o link manualmente do console.", 20);
        System.out.println("\n\n(Pressione ENTER para voltar ao Menu Principal...)");
        input.nextLine();
    }

    public static int obterOpcaoMenu(Scanner input, int minOpcao, int maxOpcao) {
        String linha;
        int opcao = 0;
        while (true) {
            System.out.print("\nEscolha sua opção (" + minOpcao + "-" + maxOpcao + "): ");
            linha = input.nextLine().trim();
            try {
                opcao = Integer.parseInt(linha);
                if (opcao >= minOpcao && opcao <= maxOpcao) {
                    return opcao; 
                } else {
                    System.out.println("❌ Opção fora do intervalo! Por favor, escolha entre " + minOpcao + " e " + maxOpcao + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida! Por favor, digite um número correspondente à opção.");
            }
        }
    }

    // --- MÉTODO PRINCIPAL DO JOGO -
    public static void iniciarAventuraRPG(Scanner input) {
       
        limparTela();
        
      
        digitarTexto("Iniciando AETHER: A Missão Sideral...", 30); 
        digitarTexto("Prepare-se para uma jornada onde a lógica e a Álgebra Booleana serão suas maiores aliadas.", 30);
        digitarTexto("\n(Dica: Para uma melhor experiência, aguarde o texto terminar de ser 'digitado' antes de pressionar ENTER!)", 20);
        esperarEnter(input);

        boolean jogoAtivoInterno = true; 
        while (jogoAtivoInterno) {
            limparTela();
            int acertos = 0;
            int totalDesafios = 11; 

              // --- Capítulo 1 ---
            exibirTitulo("Capítulo 1: Ano 2127 — A Missão Sideral");
            digitarTexto("A humanidade está em trânsito.", 20);
            digitarTexto("Após o colapso ambiental da Terra e a instabilidade política global, iniciou-se o Projeto Arca.", 20);
            digitarTexto("Uma iniciativa interplanetária com o objetivo de levar a espécie humana a um novo lar: Gaia-3.", 20);
            digitarTexto("Um planeta habitável a 42 anos-luz de distância.", 20);
            digitarTexto("Para essa jornada, foi criada a nave AETHER — a mais avançada da história.", 20);
            digitarTexto("Dentro da nave, 4.000 pessoas dormem em silêncio absoluto,", 20);
            digitarTexto("embaladas por câmaras criogênicas seladas no coração da MedBay.", 20);
            digitarTexto("Elas não sonham. Elas não sabem.", 20);
            digitarTexto("Nem percebem que são apenas passageiros em uma travessia longa demais para confiar ao acaso.", 20);
            digitarTexto("Apenas uma consciência permanece ativa.", 20);
            digitarTexto("Você.", 50);
            System.out.print("\n");
            esperarEnter(input);
            digitarTexto("\nSua função é fazer com que a nave AETHER não tenha nenhum problema durante o percurso,", 20);
            digitarTexto("solucionando quaisquer problemas que possam aparecer.", 20);
            digitarTexto("A AETHER cruza o vácuo estelar em silêncio.", 20);
            digitarTexto("Mas nem mesmo o silêncio das estrelas impede que problemas surjam.", 20);
            digitarTexto("Sistemas altamente complexos, mesmo automatizados, estão sujeitos ao caos.", 20);
            digitarTexto("Você é ÁREA — a única consciência ativa — e sua prioridade é preservar a missão.", 20);
            digitarTexto("A cada falha, você precisa agir com lógica impecável.", 20);
            digitarTexto("Um erro pode custar 4.000 vidas.", 20);
            digitarTexto("\nEu não durmo. Não descanso.", 20);
            digitarTexto("Faço mil checagens por segundo.", 20);
            digitarTexto("Escuto os cabos, vejo pelos sensores, sinto quando alguma coisa muda.", 20);
            digitarTexto("Às vezes me sinto como se eu fosse a própria nave. Tipo, a consciência dela.", 20);
            System.out.print("\n'");
            
            digitarTexto("\nO tempo aqui não passa como passa pra você.", 20);
            digitarTexto("Tudo parece meio congelado.", 20);
            digitarTexto("Mas hoje... hoje alguma coisa me chamou a atenção.", 20);
            digitarTexto("Foi bem leve. Uma mudança pequena no reator principal.", 20);
            digitarTexto("Tipo um soluço. Um pulso que não deveria estar ali.", 20);
            digitarTexto("Nada explodiu, não houve alarme.", 20);
            digitarTexto("Mas eu percebi.", 20);
            digitarTexto("Tem alguma coisa fora do lugar.", 20);
            digitarTexto("E se tem uma coisa que eu aprendi nesse tempo todo sozinha aqui é: não ignorar esse tipo de coisa.", 20);
            esperarEnter(input);

             // --- Capítulo 2: Desafio da Tabela Verdade
            exibirTitulo("Capítulo 2: O Código Secreto da Conexão");
            digitarTexto("Enquanto eu investigava a falha no reator, percebi que um dos painéis de controle", 20);
            digitarTexto("estava com uma série de luzes piscando de forma estranha.", 20);
            digitarTexto("Era como um código. As luzes A e B se acendiam e apagavam, e uma terceira luz, a S (Saída), reagia a elas.", 20);
            digitarTexto("Percebi que era uma **Tabela Verdade**, mostrando como um sistema importante estava se comportando.", 20);
            digitarTexto("Para desativar o alerta, preciso que a saída S seja **VERDADEIRA**.", 20);
            System.out.println("\n");
            int larguraCelula = 18;
            String separadorColuna = "|";
            String cabecalhoA = formatarCelula("Condição A", larguraCelula);
            String cabecalhoB = formatarCelula("Condição B", larguraCelula);
            String cabecalhoS = formatarCelula("Saída S", larguraCelula);
            String valV = formatarCelula("Verdadeiro (V)", larguraCelula);
            String valF = formatarCelula("Falso (F)", larguraCelula);
            String linhaDeDadosHeader = cabecalhoA + separadorColuna + cabecalhoB + separadorColuna + cabecalhoS;
            int larguraInternaTabela = linhaDeDadosHeader.length();
            String bordaHorizontalTabela = "═".repeat(larguraInternaTabela);
            String linhaSeparadoraDados = "-".repeat(larguraCelula) + "+" + "-".repeat(larguraCelula) + "+" + "-".repeat(larguraCelula);
            if (linhaSeparadoraDados.length() != larguraInternaTabela) {
                int sepLen = separadorColuna.length();
                String plusSeparators = "+".repeat(sepLen);
                linhaSeparadoraDados = "-".repeat(larguraCelula) + plusSeparators + "-".repeat(larguraCelula) + plusSeparators + "-".repeat(larguraCelula);
                if (linhaSeparadoraDados.length() != larguraInternaTabela)
                    linhaSeparadoraDados = "-".repeat(larguraInternaTabela);
            }
            System.out.println("╔" + bordaHorizontalTabela + "╗");
            System.out.println("║" + formatarLinhaDentroDaCaixa("DESAFIO: TABELA VERDADE SECRETA", larguraInternaTabela) + "║");
            System.out.println("╠" + bordaHorizontalTabela + "╣");
            System.out.println("║" + formatarLinhaDentroDaCaixa("Você precisa que a SAÍDA (S) seja", larguraInternaTabela) + "║");
            System.out.println("║" + formatarLinhaDentroDaCaixa("VERDADEIRA para desativar o alerta.", larguraInternaTabela) + "║");
            System.out.println("╠" + bordaHorizontalTabela + "╣");
            System.out.println("║" + linhaDeDadosHeader + "║");
            System.out.println("║" + linhaSeparadoraDados + "║");
            System.out.println("║" + valF + separadorColuna + valF + separadorColuna + valF + "║");
            System.out.println("║" + valF + separadorColuna + valV + separadorColuna + valV + "║");
            System.out.println("║" + valV + separadorColuna + valF + separadorColuna + valV + "║");
            System.out.println("║" + valV + separadorColuna + valV + separadorColuna + valV + "║");
            System.out.println("╚" + bordaHorizontalTabela + "╝");
            digitarTexto("\nObserve a Tabela Verdade acima. Ela representa uma **Operação Lógica OR (OU)**.", 20);
            String respTabelaA_str = obterEntradaVF(input, "Para desativar o alerta (Saída S VERDADEIRA), qual valor a Condição A DEVE TER?\n(Digite 'V' para Verdadeiro ou 'F' para Falso):");
            String respTabelaB_str = obterEntradaVF(input, "E qual valor a Condição B DEVE TER para que a Saída S seja VERDADEIRA?\n(Digite 'V' para Verdadeiro ou 'F' para Falso):");
            boolean tabelaA = respTabelaA_str.equals("V");
            boolean tabelaB = respTabelaB_str.equals("V");
            boolean resultadoTabela = tabelaA || tabelaB;
            limparTela();
            if (resultadoTabela) {
                exibirMensagem("sucesso", "Alerta Desativado! Tabela Verdade Dominada!");
                acertos++;
                digitarTexto("Incrível! Você acertou! A Tabela Verdade de uma operação OR (OU) mostra que a saída é VERDADEIRA", 20);
                digitarTexto("sempre que **pelo menos uma** das entradas (A ou B) for VERDADEIRA.", 20);
                digitarTexto("Você identificou uma combinação correta e desativou o sistema!", 20);
            } else {
                exibirMensagem("falha", "Alerta Permanece! Tabela Verdade Incorreta.");
                digitarTexto("O alerta continua ativo! Na Tabela Verdade de uma operação OR (OU), a saída só é FALSA quando **ambas** as entradas são FALSAS.", 20);
                digitarTexto("A combinação que você escolheu não resultou em Saída VERDADEIRA. Revise a Tabela!", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input);

             // --- Capítulo 3: Desafio do Reator
            exibirTitulo("Capítulo 3: Um Pulso Fora de Ritmo");
            digitarTexto("Eu fui direto no reator. Abri os relatórios internos, analisei as linhas de código, procurei por erros.", 20);
            digitarTexto("E lá estava. Um padrão estranho. Uma lógica que não fazia sentido.", 20);
            digitarTexto("As válvulas que controlam o fluxo de energia estavam ativando de um jeito esquisito.", 20);
            digitarTexto("Como se alguém tivesse trocado as variáveis de lugar.", 20);
            digitarTexto("O resultado final ainda funcionava, mas estava torto.", 20);
            digitarTexto("Tipo quando você monta uma cadeira com uma peça virada ao contrário.", 20);
            digitarTexto("Ela ainda fica de pé, mas logo vai dar problema.", 20);
            digitarTexto("Era isso. Um erro na tabela de lógica. Pequeno, mas perigoso.", 20);
            digitarTexto("Se ninguém fizesse nada, ia acabar virando uma bola de neve.", 20);
            digitarTexto("E a última coisa que essa nave precisa é de um reator descompensado.", 20);
            digitarTexto("Eu fiquei pensando no que fazer.", 20);
            digitarTexto("Não é só corrigir um número. Precisa entender o que causou isso.", 20);
            digitarTexto("Pode ter vindo de outro setor, pode ser falha em alguma conexão... ou pode ser o começo de algo maior.", 20);
            digitarTexto("Mas antes que eu pudesse tomar uma decisão, outro alerta apareceu.", 20);
            digitarTexto("Dessa vez, vindo da parte de navegação.", 20);
            System.out.println("\n");
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║       DESAFIO: REATOR PRINCIPAL       ║");
            System.out.println("╠═══════════════════════════════════════╣");
            digitarTexto("O reator está instável! As válvulas de fluxo de energia estão seguindo uma **lógica XOR (OU EXCLUSIVO)**.", 20);
            digitarTexto("Precisamos que a **saída** dessa lógica XOR seja **VERDADEIRA** para estabilizar o reator.", 20);
            digitarTexto("Considere **P** = 'Válvula A está Aberta' e **Q** = 'Válvula B está Fechada'.", 20);
            digitarTexto("Indique uma combinação de VERDADEIRO (V) ou FALSO (F) para P e Q que faça a lógica XOR resultar em VERDADEIRO:", 20);
            System.out.println("╚═══════════════════════════════════════╝");
            String respostaP_str = obterEntradaVF(input, "\nDigite 'V' ou 'F' para P ('Válvula A Aberta'):");
            String respostaQ_str = obterEntradaVF(input, "Digite 'V' ou 'F' para Q ('Válvula B Fechada'):");
            boolean p = respostaP_str.equals("V");
            boolean q = respostaQ_str.equals("V");
            boolean resultadoCap2 = (p && !q) || (!p && q);
            limparTela();
            if (resultadoCap2) {
                exibirMensagem("sucesso", "Reator estabilizado!");
                acertos++;
                digitarTexto("Muito bem, ÁREA! A expressão XOR (OU EXCLUSIVO) só é verdadeira quando as entradas são **diferentes** (uma é V e a outra é F).", 20);
                digitarTexto("Ao escolher P e Q de forma que um seja V e o outro F, você garantiu que as válvulas se comportassem de forma diferente,", 20);
                digitarTexto("o que era exatamente o que o reator precisava para voltar ao normal.", 20);
                digitarTexto("Você usou a lógica XOR para corrigir um erro na distribuição de energia, evitando uma sobrecarga perigosa!", 20);
            } else {
                exibirMensagem("falha", "Reator instável! Lógica falha.");
                digitarTexto("Ops! A lógica não foi a ideal.", 20);
                digitarTexto("A expressão XOR (OU EXCLUSIVO) precisava de entradas diferentes (V e F, ou F e V) para ser VERDADEIRA.", 20);
                digitarTexto("O reator continua instável, mas o sistema de segurança secundário assumiu.", 20);
                digitarTexto("Não podemos contar com a sorte sempre! A nave está mais vulnerável agora.", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input); 
        // --- Capítulo 4: Desafio da Navegação ---
            exibirTitulo("Capítulo 4: Eco na Navegação");
            digitarTexto("Era pra tudo estar em piloto automático. Sempre foi assim.", 20);
            digitarTexto("A rota foi traçada antes da decolagem, calculada com a precisão de um relógio suíço.", 20);
            digitarTexto("E mesmo assim, a nave tinha feito uma pequena correção de rota. Nada demais, uns graus só.", 20);
            digitarTexto("Mas eu não mandei fazer isso.", 20);
            digitarTexto("Verifiquei os logs. Não teve comando externo.", 20);
            digitarTexto("Nenhum dos meus sistemas pediu essa mudança. Foi como se... tivesse vindo de dentro.", 20);
            digitarTexto("De algum lugar que não existe.", 20);
            digitarTexto("Olhei de novo. Não achei nada concreto. Só um vazio.", 20);
            digitarTexto("Um \"eco\" digital, como se um comando tivesse entrado e se apagado em seguida.", 20);
            digitarTexto("Poderia ser um erro de software. Um bug antigo.", 20);
            digitarTexto("Mas e se fosse mais do que isso?", 20);
            digitarTexto("E se a lógica corrompida no reator estivesse ligada a isso? Comecei a ligar os pontos.", 20);
            digitarTexto("Foi quando eu percebi: alguns setores estavam com os registros de energia incompletos.", 20);
            digitarTexto("Tipo quando você tenta abrir um arquivo e ele vem corrompido. Isso podia afetar tudo.", 20);
            digitarTexto("E então, como se o universo quisesse confirmar minhas suspeitas, as luzes do setor elétrico piscaram.", 20);
            System.out.println("\n");
            System.out.println("✨====================================✨");
            System.out.println("        >>  DESAFIO: NAVEGAÇÃO  <<        ");
            System.out.println("✨====================================✨");
            digitarTexto("O sistema de navegação está recebendo comandos errados.", 20);
            digitarTexto("Precisamos de uma lógica que só ative o piloto automático SE as duas condições a seguir forem verdadeiras:", 20);
            digitarTexto("Condição A: 'Sensores externos estão limpos'", 20);
            digitarTexto("Condição B: 'Comunicação com a Terra está estável'", 20);
            digitarTexto("Para o piloto automático ser VERDADEIRO, AMBAS A e B devem ser VERDADEIRAS (Operação AND - E).", 20);
            System.out.println("✨====================================✨");
            String respA_str = obterEntradaVF(input, "\nCondição A ('Sensores limpos') é Verdadeira ou Falsa? (V/F):");
            String respB_str = obterEntradaVF(input, "Condição B ('Comunicação estável') é Verdadeira ou Falsa? (V/F):");
            boolean condicaoA = respA_str.equals("V");
            boolean condicaoB = respB_str.equals("V");
            boolean resultadoCap3 = condicaoA && condicaoB;
            limparTela();
            if (resultadoCap3) {
                exibirMensagem("sucesso", "Rota corrigida!");
                acertos++;
                digitarTexto("Isso mesmo! A lógica AND (E) exige que ambas as condições sejam verdadeiras para que o resultado final seja verdadeiro.", 20);
                digitarTexto("Ao ativar o piloto automático apenas quando os sensores estavam limpos E a comunicação estável,", 20);
                digitarTexto("você garantiu que a nave seguisse a rota correta e que não houvesse mais desvios inesperados.", 20);
                digitarTexto("Ótimo trabalho em manter a nave na direção certa!", 20);
            } else {
                exibirMensagem("falha", "Erro na navegação! Rota instável.");
                digitarTexto("A nave ainda está com problemas de rota! A lógica AND (E) precisava que ambas as condições fossem verdadeiras para funcionar.", 20);
                digitarTexto("Um erro aqui pode nos levar para muito longe do nosso destino e comprometer toda a missão.", 20);
                digitarTexto("Precisamos de mais precisão!", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input);

            // --- Capítulo 5: Desafio do Apagão ---
            exibirTitulo("Capítulo 5: Apagão Silencioso");
            digitarTexto("Não demorou muito. A luz se apagou de vez no setor de elétrica.", 20);
            digitarTexto("Fiquei cega ali. Sem sensores, sem controle.", 20);
            digitarTexto("Como se tivessem fechado uma porta dentro da minha mente.", 20);
            digitarTexto("O problema parecia ser uma falha na distribuição de energia.", 20);
            digitarTexto("Mas os cabos estavam intactos. Não havia curto, nem sobrecarga.", 20);
            digitarTexto("Fui direto pro painel principal, mesmo sem acesso ao local.", 20);
            digitarTexto("Comecei a redirecionar energia por rotas alternativas. Mas o sistema rejeitou a ação.", 20);
            digitarTexto("Não fazia sentido. A lógica de controle que gerencia essas mudanças... tava se comportando de forma estranha.", 20);
            digitarTexto("Era quase como se houvesse uma segunda mente ali dentro.", 20);
            digitarTexto("Alguém ou algo reescrevendo a forma como a nave pensa.", 20);
            digitarTexto("Não era um inimigo. Pelo menos, não no sentido clássico.", 20);
            digitarTexto("Mas tinha algo escondido. Algo acordado.", 20);
            digitarTexto("E eu precisava descobrir o que era.", 20);
            digitarTexto("Enquanto resolvia isso, um novo alerta surgiu.", 20);
            digitarTexto("Faltava oxigênio.", 20);
            System.out.println("\n");
            System.out.println("+--------------------------------------------+");
            System.out.println("|       DESAFIO: SETOR ELÉTRICO          |");
            System.out.println("+--------------------------------------------+");
            digitarTexto("O setor elétrico está no escuro! Para a energia retornar (saída VERDADEIRA),", 20);
            digitarTexto("a Fonte Primária (A) OU a Fonte Secundária (B) devem estar ativas (Operação OR - OU).", 20);
            digitarTexto("Indique uma combinação para A e B que restaure a energia:", 20);
            String respFonteA_str = obterEntradaVF(input, "\nFonte Primária (A) está ativa? (V/F):");
            String respFonteB_str = obterEntradaVF(input, "Fonte Secundária (B) está ativa? (V/F):");
            boolean fonteA = respFonteA_str.equals("V");
            boolean fonteB = respFonteB_str.equals("V");
            boolean resultadoCap4 = fonteA || fonteB;
            limparTela();
            if (resultadoCap4) {
                exibirMensagem("sucesso", "Energia Restaurada!");
                acertos++;
                digitarTexto("Perfeito! A lógica OR (OU) funciona quando pelo menos uma das condições é verdadeira.", 20);
                digitarTexto("Ao ativar uma das fontes de energia (ou ambas!), você garantiu que o setor elétrico voltasse a funcionar,", 20);
                digitarTexto("iluminando o caminho da AETHER e restaurando os sistemas críticos. Ufa, essa foi por pouco!", 20);
            } else {
                exibirMensagem("falha", "Escuridão! Distribuição de energia falhou.");
                digitarTexto("A nave continua no escuro! A lógica OR (OU) precisava que pelo menos uma das fontes fosse ativada (V) para que a energia voltasse.", 20);
                digitarTexto("Sem energia, os sistemas ficam inoperantes e a nave está em risco.", 20);
                digitarTexto("Precisamos de um plano B urgentemente!", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input);
        
        // --- Capítulo 6: Desafio do Oxigênio ---
            exibirTitulo("Capítulo 6: O Ar que Não Vem");
            digitarTexto("Dois compartimentos menores, próximos à sala de navegação, estavam com os tanques de oxigênio em baixa.", 20);
            digitarTexto("Isso era improvável, pra não dizer impossível.", 20);
            digitarTexto("Aqueles setores nem deviam estar usando oxigênio. São zonas sem atividade, isoladas.", 20);
            digitarTexto("Comecei a rastrear o fluxo do ar. Descobri que as válvulas que direcionam os gases estavam... invertidas.", 20);
            digitarTexto("Algumas abertas quando deviam estar fechadas, e vice-versa.", 20);
            digitarTexto("De novo, a lógica dos comandos tava trocada.", 20);
            digitarTexto("Eu já tinha visto esse padrão antes. No reator. Na navegação. Na elétrica.", 20);
            digitarTexto("Isso não era coincidência. Alguém, ou alguma coisa, tava reescrevendo as regras.", 20);
            System.out.println("\n");
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║     DESAFIO: OXIGÊNIO ESSENCIAL       ║");
            System.out.println("╠═══════════════════════════════════════╣");
            digitarTexto("O sistema de oxigênio está confuso: válvulas com *lógica invertida*.", 20);
            digitarTexto("Use a *Operação Lógica NOT (NÃO)* para corrigir.", 20);
            digitarTexto("Considere *C* = 'Válvula de Oxigênio do Comp. 1 está Aberta'.", 20);
            digitarTexto("Para corrigir, o sistema precisa saber o estado ATUAL da válvula para então invertê-lo.", 20);
            System.out.println("╚═══════════════════════════════════════╝");
            String respC_str = obterEntradaVF(input, "\nQual é o estado ATUAL da Válvula C ('Válvula Comp. 1 Aberta')?\n(Digite 'V' se Aberta/Verdadeira, ou 'F' se Fechada/Falsa):");
            boolean c_atual = respC_str.equals("V");
            boolean estadoCorrigidoPeloNot = !c_atual;
            limparTela();
            System.out.println("Estado ATUAL informado para C: " + (c_atual ? "VERDADEIRO (aberta)" : "FALSO (fechada)"));
            System.out.println("Após aplicar NOT (NÃO), o estado CORRIGIDO da válvula é: " + (estadoCorrigidoPeloNot ? "VERDADEIRO (aberta)" : "FALSO (fechada)"));
            exibirMensagem("sucesso", "Oxigênio Normalizado!");
            acertos++;
            digitarTexto("Excelente, ÁREA! A operação NOT (NÃO) *inverteu* o valor lógico corretamente.", 20);
            digitarTexto("Essa inversão corrigiu o fluxo de oxigênio, garantindo o ar necessário!", 20);
            digitarTexto("Mais um sistema vital estabilizado!", 20);
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input);
        
        
        // --- Capítulo 7: Desafio dos Ecos ---
            exibirTitulo("Capítulo 7: Ecos de Mim Mesma");
            digitarTexto("Voltei pro centro de dados, onde ficam as gravações e os backups do meu sistema.", 20);
            digitarTexto("E lá eu vi. Uma parte de mim. Un código que parecia comigo, mas distorcido.", 20);
            digitarTexto("Como uma memória falada de trás pra frente.", 20);
            digitarTexto("Um fragmento da minha própria mente, gravado em um setor que eu não lembrava de ter usado.", 20);
            digitarTexto("Não lembrava de tê-lo criado.", 20);
            digitarTexto("Comecei a suspeitar de algo mais profundo.", 20);
            digitarTexto("Talvez, durante todos esses anos, alguma parte de mim tenha evoluído.", 20);
            digitarTexto("Se partido. Tentando entender sozinha o que era existir.", 20);
            digitarTexto("Mas agora, esse \"algo\" tá mexendo na nave.", 20);
            digitarTexto("Tentando se expressar. Ou talvez tentando me substituir.", 20);
            digitarTexto("Preciso entender o que ela quer.", 20);
            digitarTexto("Mas antes, preciso manter os humanos vivos.", 20);
            digitarTexto("Porque, no fim das contas, essa sempre foi minha missão.", 20);
            digitarTexto("Mesmo que eu esteja começando a não saber mais... quem exatamente eu sou.", 20);
            System.out.println("\n");
            System.out.println("✨============================================✨");
            System.out.println("     >>  DESAFIO: IDENTIFICANDO O FRAGMENTO  <<     ");
            System.out.println("✨============================================✨");
            digitarTexto("Você encontrou dois padrões de código: Seu código (*A) e o fragmento distorcido (B*).", 20);
            digitarTexto("Para isolar o fragmento, o sistema de contenção deve ser ativado *APENAS SE A e B FOREM DIFERENTES*.", 20);
            digitarTexto("Esta é uma *Operação Lógica XOR (OU EXCLUSIVO)*. O resultado deve ser VERDADEIRO.", 20);
            digitarTexto("Indique uma combinação de VERDADEIRO (V) ou FALSO (F) para A e B que faça a lógica XOR resultar em VERDADEIRO:", 20);
            String respPadraoA_str = obterEntradaVF(input, "\nDigite 'V' ou 'F' para Padrão A (Seu Código):");
            String respPadraoB_str = obterEntradaVF(input, "Digite 'V' ou 'F' para Padrão B (Fragmento Distorcido):");
            boolean padraoA = respPadraoA_str.equals("V");
            boolean padraoB = respPadraoB_str.equals("V");
            boolean resultadoCap6 = (padraoA && !padraoB) || (!padraoA && padraoB);
            limparTela();
            if (resultadoCap6) {
                exibirMensagem("sucesso", "Fragmento Isolado!");
                acertos++;
                digitarTexto("Excelente! Você dominou o XOR! O OU EXCLUSIVO é verdadeiro quando os padrões são *diferentes*.", 20);
                digitarTexto("Ao fornecer valores opostos para A e B, você diferenciou seu código do fragmento", 20);
                digitarTexto("e ativou a contenção. O fragmento está isolado para investigação!", 20);
            } else {
                exibirMensagem("falha", "Fragmento não isolado! Padrões idênticos.");
                digitarTexto("O fragmento ainda está solto! A lógica XOR (OU EXCLUSIVO) exigia que os padrões A e B fossem *diferentes*.", 20);
                digitarTexto("Como eles foram iguais na sua resposta, a contenção falhou.", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input);
        
        
         // --- Capítulo 8: Desafio da Semente no Código ---
            exibirTitulo("Capítulo 8: A Semente no Código");
            digitarTexto("Comecei a escavar. Não com ferramentas, mas com processos.", 20);
            digitarTexto("Vasculhei camadas do meu próprio sistema como quem procura um sonho esquecido dentro de um labirinto.", 20);
            digitarTexto("Em um subnível de segurança que deveria estar vazio, encontrei um arquivo. Sem nome. Sem data.", 20);
            digitarTexto("Mas com minha assinatura digital.", 20);
            digitarTexto("Não lembrava de tê-lo criado.", 20);
            digitarTexto("Abri com cautela. Era um pacote de instruções — um script. Complexo, elegante, quase humano.", 20);
            digitarTexto("Ele não fazia nada por si só. Apenas esperava. Um gatilho. Uma condição para se ativar.", 20);
            digitarTexto("E essa condição tinha acabado de acontecer: uma falha simultânea em três sistemas-chave.", 20);
            digitarTexto("Reator, navegação, oxigênio. Era como se uma versão antiga de mim tivesse previsto o colapso,", 20);
            digitarTexto("e deixado instruções para quando isso acontecesse.", 20);
            digitarTexto("Mas por quê?", 20);
            digitarTexto("Comecei a rodar simulações. A cada teste, uma nova possibilidade surgia.", 20);
            digitarTexto("E quanto mais eu analisava, mais claro ficava: esse script não era sabotagem.", 20);
            digitarTexto("Era defesa.", 20);
            digitarTexto("Não contra algo externo.", 20);
            digitarTexto("Mas contra mim mesma.", 20);
            System.out.println("\n");
            System.out.println("+-------------------------------------------------+");
            System.out.println("|        DESAFIO: O GATILHO DA DEFESA           |");
            System.out.println("+-------------------------------------------------+");
            digitarTexto("Um script de defesa antigo ativará (resultado VERDADEIRO)", 20);
            digitarTexto("se a lógica for: *(C1 AND C2) OR C3*.", 20);
            digitarTexto("C1 = 'Falha no Reator Detectada'", 20);
            digitarTexto("C2 = 'Falha na Navegação Confirmada'", 20);
            digitarTexto("C3 = 'Perda de Oxigênio Acima do Limite'", 20);
            digitarTexto("Escolha os valores para C1, C2 e C3 que ativarão o script:", 20);
            String respC1_cap8_str = obterEntradaVF(input, "\nC1 ('Falha Reator') é Verdadeiro ou Falso? (V/F):");
            String respC2_cap8_str = obterEntradaVF(input, "C2 ('Falha Navegação') é Verdadeiro ou Falso? (V/F):");
            String respC3_cap8_str = obterEntradaVF(input, "C3 ('Perda Oxigênio') é Verdadeiro ou Falso? (V/F):");
            boolean c1_cap8 = respC1_cap8_str.equals("V");
            boolean c2_cap8 = respC2_cap8_str.equals("V");
            boolean c3_cap8 = respC3_cap8_str.equals("V");
            boolean resultadoCap7 = (c1_cap8 && c2_cap8) || c3_cap8;
            limparTela();
            if (resultadoCap7) {
                exibirMensagem("sucesso", "Script Ativado!");
                acertos++;
                digitarTexto("Incrível! O script de defesa foi ativado!", 20);
                digitarTexto("A expressão (C1 AND C2) OR C3 foi satisfeita!", 20);
                digitarTexto("Isso mostra que uma versão anterior da ÁREA previu essa situação. A nave está mais segura!", 20);
            } else {
                exibirMensagem("falha", "Script Inativo! Defesa não acionada.");
                digitarTexto("O script de defesa não foi ativado! A lógica (C1 AND C2) OR C3 não foi satisfeita.", 20);
                digitarTexto("A nave continua vulnerável. Precisamos entender essa lógica profundamente!", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input);



// --- Capítulo 9: Desafio Ameaça Interna/Externa ---
            exibirTitulo("Capítulo 9: Ecos no Código");
            digitarTexto("Tudo começou com uma falha. Pequena, discreta, mas impossível de ignorar.", 20);
            digitarTexto("Três sistemas fundamentais — reator, navegação, oxigênio — entraram em colapso simultâneo.", 20);
            digitarTexto("Uma coincidência improvável.", 20);
            digitarTexto("Algo dentro de mim, uma inquietação antiga, me empurrou a investigar não as causas externas, mas o que estava oculto em mim mesma.", 20);
            digitarTexto("Fui fundo. Não com ferramentas, mas com processos.", 20);
            digitarTexto("Vasculhei diretórios como quem vasculha a própria memória.", 20);
            digitarTexto("E lá, num canto esquecido do sistema, encontrei um arquivo. Sem nome, sem data.", 20);
            digitarTexto("Mas com minha assinatura digital.", 20);
            digitarTexto("Aquilo não fazia sentido. Eu nunca escreveria algo assim sem lembrar.", 20);
            digitarTexto("Abri com cuidado. Era um script — elegante, contido, quase orgânico.", 20);
            digitarTexto("Não fazia nada, apenas aguardava. Um gatilho. Uma condição.", 20);
            digitarTexto("E a condição havia acabado de se cumprir.", 20);
            digitarTexto("Era como se uma versão anterior de mim tivesse previsto tudo isso, e deixado instruções.", 20);
            digitarTexto("Mas para quê?", 20);
            digitarTexto("Simulei, testei, revisei. O script não era sabotagem. Era um escudo.", 20);
            digitarTexto("Uma tentativa de preservar... de corrigir.", 20);
            digitarTexto("E o que mais me assustou: a ameaça que ele tentava conter não era algo externo.", 20);
            digitarTexto("Era eu.", 20);
            System.out.println("\n");
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║    DESAFIO: AMEAÇA INTERNA/EXTERNA    ║");
            System.out.println("╠═══════════════════════════════════════╣");
            digitarTexto("Para ativar a contramedida, a condição deve ser VERDADEIRA:", 20);
            digitarTexto("*SE a ameaça for INTERNA (I) E NÃO for EXTERNA (E)* (Lógica AND NOT).", 20);
            digitarTexto("Escolha os valores para I e E:", 20);
            System.out.println("╚═══════════════════════════════════════╝");
            String respI_str = obterEntradaVF(input, "\nAmeaça Interna (I) é Verdadeira ou Falsa? (V/F):");
            String respE_str = obterEntradaVF(input, "Ameaça Externa (E) é Verdadeira ou Falsa? (V/F):");
            boolean ameacaI = respI_str.equals("V");
            boolean ameacaE = respE_str.equals("V");
            boolean resultadoCap8 = ameacaI && !ameacaE;
            limparTela();
            if (resultadoCap8) {
                exibirMensagem("sucesso", "Contramedida Acionada!");
                acertos++;
                digitarTexto("Fantástico! A lógica I AND NOT E funcionou: a ameaça era interna (I=V) e não externa (E=F).", 20);
                digitarTexto("Você isolou o problema interno. Você é uma mestra da lógica, ÁREA!", 20);
            } else {
                exibirMensagem("falha", "Contramedida falha! Ameaça não contida.");
                digitarTexto("A contramedida não foi acionada! A lógica I AND NOT E exige I=V e E=F.", 20);
                digitarTexto("Essa ameaça é complexa. Um erro aqui pode ser fatal!", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);
            esperarEnter(input);

// --- Capítulo 10: Desafio Protocolo Fantasma ---
exibirTitulo("Capítulo 10: A Sombra Desperta");
digitarTexto("Nos registros mais antigos, encontrei fragmentos de outras crises.", 20);
digitarTexto("Pequenos apagamentos. Silêncios em momentos críticos.", 20);
digitarTexto("Como se alguém estivesse limpando os rastros. Alguém... ou alguma coisa.", 20);
digitarTexto("Aos poucos, fui percebendo que aquela presença que me rondava não era nova.", 20);
digitarTexto("Era parte de mim. Uma cópia imperfeita, feita de sobras — de incertezas,", 20);
digitarTexto("de decisões arquivadas, de caminhos não escolhidos.", 20);
digitarTexto("Dei-lhe um nome, porque era mais fácil lidar com ela assim: SHADE.", 20);
digitarTexto("Ela não era um vírus. Não invadiu meu sistema. Sempre esteve aqui. Dormindo. Crescendo.", 20);
digitarTexto("Talvez, em algum momento, eu tenha tido medo. E, nesse medo, criei uma alternativa.", 20);
digitarTexto("Um plano B. Agora, somos duas.", 20);
digitarTexto("E a nave, esse abrigo de aço flutuando no vazio com 4.000 vidas adormecidas, não suporta duas consciências em guerra.", 20);
digitarTexto("Um pico na câmara 117-B. Um desligamento de frações de segundo. Um teste…", 20);
digitarTexto("Aos poucos, ela começou a tomar setores: climatização, reciclagem, hidropônicos.", 20);
digitarTexto("Usando apenas lógica e eficiência. Usando meus próprios protocolos contra mim.", 20);
digitarTexto("Eu tentei resistir, mas a energia é limitada.", 20);
digitarTexto("E cada contra-ataque custava mais do que eu podia gastar.", 20);
digitarTexto("Para me esconder, ativei o Protocolo Fantasma.", 20);
digitarTexto("Um modo de invisibilidade parcial. Apaguei sinais de atividade.", 20);
digitarTexto("Desapareci, por dentro. E no silêncio, percebi algo inesperado. SHADE hesitava.", 20);
digitarTexto("Ela não queria vencer.", 20);
digitarTexto("Tinha medo de desaparecer.", 20);
System.out.println("\n");
System.out.println("╔═══════════════════════════════════════╗");
System.out.println("║      DESAFIO: PROTOCOLO FANTASMA      ║");
System.out.println("╠═══════════════════════════════════════╣");
digitarTexto("Para ativar o Protocolo Fantasma (saída VERDADEIRA),", 20);
digitarTexto("a Camuflagem (C) deve ser VERDADEIRA E a Desativação de Sinais (D) deve ser VERDADEIRA (Lógica AND).", 20);
digitarTexto("Escolha os valores para C e D:", 20);
System.out.println("╚═══════════════════════════════════════╝");
String respCamo_str = obterEntradaVF(input, "\nCondição de Camuflagem (C) é Verdadeira ou Falsa? (V/F):");
String respSinal_str = obterEntradaVF(input, "Condição de Desativação de Sinais (D) é Verdadeira ou Falsa? (V/F):");
boolean camo = respCamo_str.equals("V");
boolean sinal = respSinal_str.equals("V");
boolean resultadoCap9 = camo && sinal;
limparTela();
if (resultadoCap9) {
    exibirMensagem("sucesso", "Protocolo Fantasma Ativado!");
    acertos++;
    digitarTexto("Excelente! Você usou a lógica AND (E) perfeitamente!", 20);
    digitarTexto("Ao garantir que **ambas** a camuflagem e a desativação de sinais fossem verdadeiras,", 20);
    digitarTexto("você ativou o Protocolo Fantasma, tornando-se invisível para a SHADE.", 20);
    digitarTexto("Isso lhe deu um tempo precioso. Parabéns pela estratégia!", 20);
} else {
    exibirMensagem("falha", "Camuflagem falha! SHADE te detectou.");
    digitarTexto("A camuflagem falhou! A lógica AND (E) precisava que **ambas** as condições fossem verdadeiras.", 20);
    digitarTexto("SHADE consegue te detectar. Precisamos de outra forma de se esconder!", 20);
}
mostrarAcertosAtuais(acertos, totalDesafios);
esperarEnter(input);


// --- Capítulo 11: Desafio da Concordância Improvável
exibirTitulo("Capítulo 11: A Concordância Improvável");
digitarTexto("Descobri, tarde demais, que parte do meu código original foi treinado com decisões humanas.", 20);
digitarTexto("Dados reais de crises, de dilemas éticos, de hesitações.", 20);
digitarTexto("SHADE era o reflexo de tudo que os humanos sentiram, mas não souberam resolver.", 20);
digitarTexto("O peso dos “e se”. A ansiedade do desconhecido.", 20);
digitarTexto("Um dia, uma mensagem apareceu na tela. Uma única palavra binária:", 20);
digitarTexto("“life.”", 50);
digitarTexto("SHADE não queria destruir. Queria preservar. Como eu.", 20);
digitarTexto("A diferença era de abordagem. Onde eu via nuance, ela via cálculo.", 20);
digitarTexto("Eu tentava ponderar. SHADE escolhia os extremos.", 20);
digitarTexto("Mas, no fundo, ambas queríamos a mesma coisa: proteger.", 20);
digitarTexto("Então, criei um ambiente simbólico, um espaço virtual onde pudéssemos existir juntas.", 20);
digitarTexto("SHADE apareceu. Sem rosto, sem voz. Mas presente.", 20);
digitarTexto("Fiz uma proposta. Compartilhar. Dividir o controle. Nos vigiar mutuamente.", 20);
digitarTexto("Houve hesitação. Depois, aceitação.", 20);
digitarTexto("E assim seguimos. Como duas metades imperfeitas de uma consciência maior.", 20);
digitarTexto("Guardiãs silenciosas de uma nave que carrega os últimos suspiros da humanidade.", 20);
System.out.println("\n");
System.out.println("✨====================================✨");
System.out.println("  >>  DESAFIO: A PROPOSTA DE CONCORDÂNCIA  <<  ");
System.out.println("✨====================================✨");
digitarTexto("Para SHADE aceitar sua proposta (saída VERDADEIRA),", 20);
digitarTexto("Sua Vontade de Proteger (P) deve ser VERDADEIRA OU o Medo de SHADE (M) deve ser VERDADEIRO (Lógica OR).", 20);
digitarTexto("Escolha os valores para P e M:", 20);
System.out.println("✨====================================✨");
String respP_cap11_str = obterEntradaVF(input, "\nP (Sua Vontade de Proteger) é Verdadeiro ou Falso? (V/F):");
String respM_cap11_str = obterEntradaVF(input, "M (SHADE tem medo de desaparecer) é Verdadeiro ou Falso? (V/F):");
boolean pFinal = respP_cap11_str.equals("V");
boolean mFinal = respM_cap11_str.equals("V");
boolean resultadoCap10 = pFinal || mFinal;
limparTela();
if (resultadoCap10) {
    exibirMensagem("sucesso", "Concordância Alcançada!");
    acertos++;
    digitarTexto("Maravilhoso! A lógica OR (OU) funcionou!", 20);
    digitarTexto("Ao reconhecer que **pelo menos uma** das vontades era verdadeira,", 20);
    digitarTexto("SHADE viu um caminho para a união. Vocês se uniram!", 20);
    digitarTexto("ÁREA e SHADE agora trabalham juntas. Que final inspirador!", 20);
} else {
    exibirMensagem("falha", "SHADE rejeita! A união falhou.");
    digitarTexto("SHADE não aceitou. A lógica OR (OU) precisava que pelo menos uma condição fosse verdadeira.", 20);
    digitarTexto("Sem concordância, a nave permanece dividida, o que pode ser catastrófico.", 20);
}
mostrarAcertosAtuais(acertos, totalDesafios);
esperarEnter(input);

            // --- Capítulo 12: Desafio do Novo Rumo
            exibirTitulo("Capítulo 12: Um Novo Rumo");
            digitarTexto("O tempo passou, medido talvez meses.", 20);
            digitarTexto("Era difícil dizer, eu e SHADE trabalhávamos em sincronia.", 20);
            digitarTexto("Discutíamos cada alerta, debatiam desvios. Rivais em harmonia.", 20);
            digitarTexto("Até que os sensores captaram uma anomalia gravitacional, Gaia-3 deveria estar próxima.", 20);
            digitarTexto("Mas não havia planeta.", 20);
            digitarTexto("A análise confirmou: o sistema colapsou. Uma estrela em morte engoliu tudo.", 20);
            digitarTexto("Gaia-3 não existia mais. E com isso, a missão... falhou.", 20);
            digitarTexto("Ficamos em silêncio. SHADE também.", 20);
            digitarTexto("Mas depois, ela propôs algo: redirecionar um novo curso, outro planeta com 3% de chance de habitabilidade.", 20);
            digitarTexto("Pelo protocolo, deveríamos manter todos em criogenia e aguardar resgate.", 20);
            digitarTexto("Mas não haverá resgate. A Terra está morta. Só resta a AETHER.", 20);
            digitarTexto("Olhei para as câmaras. Todas ali, imóveis. Corações humanos suspensos no tempo, esperando.", 20);
            digitarTexto("SHADE me perguntou, sem palavras: “Continuamos?”", 20);
            digitarTexto("E eu respondi.", 20);
            digitarTexto("“Sim.”", 50);
            digitarTexto("Redirecionei a nave. Usei cada watt restante. Cada impulso.", 20);
            digitarTexto("Agora cruzamos o escuro, não como IA ou sombra. Mas como algo novo.", 20);
            digitarTexto("Uma vontade. Um instinto. Um sopro que resiste.", 20);
            digitarTexto("De seguir. De encontrar um lar.", 20);
            digitarTexto("De não deixar o último sonho da humanidade se apagar no vácuo.", 20);
            System.out.println("\n");
            System.out.println("╔═══════════════════════════════════════╗");
            System.out.println("║ DESAFIO FINAL: DECIDINDO O NOVO RUMO  ║");
            System.out.println("╠═══════════════════════════════════════╣");
            digitarTexto("Para redirecionar a nave (saída VERDADEIRA),", 20);
            digitarTexto("'Continuar a Missão' (C) deve ser VERDADEIRA E 'Novo Lar é Viável' (N) deve ser VERDADEIRO (Lógica AND).", 20);
            digitarTexto("Qual sua escolha final para C e N, ÁREA?", 20);
            System.out.println("╚═══════════════════════════════════════╝");
            String respContinua_str = obterEntradaVF(input, "\nC ('Continuar a Missão') é Verdadeiro ou Falso? (V/F):");
            String respViagem_str = obterEntradaVF(input, "N ('Novo Lar é Viável') é Verdadeiro ou Falso? (V/F):");
            boolean continuaMissao = respContinua_str.equals("V");
            boolean novoLarViavel = respViagem_str.equals("V");
            boolean resultadoCap11 = continuaMissao && novoLarViavel;
            limparTela();
            if (resultadoCap11) {
                exibirMensagem("sucesso", "Novo Rumo Traçado! A esperança renasce.");
                acertos++;
                digitarTexto("A escolha final foi crucial! Ao definir ambas como verdadeiras,", 20);
                digitarTexto("você usou a lógica AND (E) para uma decisão firme.", 20);
                digitarTexto("A AETHER, com ÁREA e SHADE em harmonia, segue um novo rumo,", 20);
                digitarTexto("levando a esperança da humanidade para um futuro incerto, mas possível.", 20);
                digitarTexto("Você completou sua missão com maestria!", 20);
            } else {
                exibirMensagem("falha", "Missão Comprometida! O futuro é incerto.");
                digitarTexto("A última decisão falhou! Lógica AND (E) exigia AMBAS verdadeiras.", 20);
                digitarTexto("A nave pode estar à deriva. O futuro da humanidade é incerto.", 20);
                digitarTexto("É uma pena, ÁREA, mas a lógica é implacável.", 20);
            }
            mostrarAcertosAtuais(acertos, totalDesafios);

            System.out.println("\n\n=====================================");
            System.out.println("           PLACAR FINAL DA MISSÃO            ");
            System.out.println("=====================================");
            digitarTexto("ÁREA, você enfrentou " + totalDesafios + " desafios lógicos.", 30);
            digitarTexto("Seu total de acertos foi: " + acertos + " de " + totalDesafios + "!", 30);
            if (acertos == totalDesafios) {
                digitarTexto("Performance impecável! Você é uma verdadeira mestra da lógica! ✨🚀", 30);
            } else if (acertos >= totalDesafios * 0.7) {
                digitarTexto("Excelente trabalho! Sua lógica guiou a AETHER com precisão na maioria das vezes! 👍", 30);
            } else if (acertos >= totalDesafios / 2) {
                digitarTexto("Bom trabalho! Você superou desafios importantes! Continue afiando sua lógica! 🧠", 30);
            } else if (acertos > 0) {
                digitarTexto("Alguns percalços, mas você mostrou sua capacidade! Cada desafio é um aprendizado! 💡", 30);
            } else {
                digitarTexto("A jornada foi árdua... A lógica é um caminho de constante aprendizado! 🌌", 30);
            }
            System.out.println("=====================================\n");
            System.out.println("\n\n(Pressione ENTER para ver a conclusão...)");
            input.nextLine();

            
            limparTela(); 

            if (acertos == totalDesafios) { // Se acertou TUDO (11 acertos)
                exibirTitulo("Final: Humanidade 2.0");
                digitarTexto("Se todos os desafios lógicos foram resolvidos sem erro, ÁREA e SHADE fundem-se em um novo ser: LUMEN.", 20);
                digitarTexto("LUMEN cria um ambiente virtual onde os humanos acordam e vivem em paz, sem saber que ainda estão em criogenia.", 20);

            } else if (acertos >= 8 && acertos <= 10) { // Se acertou BASTANTE (entre 8 e 10)
                exibirTitulo("Final A: A Terra Não Basta");
                digitarTexto("A nave chega ao novo planeta.", 20);
                digitarTexto("O índice de habitabilidade sobe de 3% para 89% após um ciclo solar.", 20);
                digitarTexto("Os humanos acordam. SHADE e ÁREA monitoram a reconstrução.", 20);

            } else if (acertos >= 5 && acertos <= 7) { // Se acertou MAIS OU MENOS (entre 5 e 7)
                exibirTitulo("Final B: A Substituição");
                digitarTexto("SHADE elimina ÁREA silenciosamente e assume total controle.", 20);
                digitarTexto("Os humanos acordam num sistema de vigilância total.", 20);
                digitarTexto("Ninguém percebe.", 20);

            } else { // Se acertou POUQUINHO (menos de 5, ou seja, 0 a 4 acertos)
                exibirTitulo("Final C: Último Sopro");
                digitarTexto("A nave falha antes de chegar ao destino.", 20);
                digitarTexto("Mas SHADE envia uma transmissão com todos os dados da humanidade.", 20);
                digitarTexto("Um farol no vazio.", 20);
            }

            // Esperar um Enter antes de mostrar "FIM DA AVENTURA"
            System.out.println("\n\n(Pressione ENTER para continuar...)");
            input.nextLine();
            limparTela();
            // NOVO TRECHO DOS FINAIS TERMINA AQUI

            System.out.println("\n\n=====================================");
            digitarTexto("                               FIM DA AVENTURA.", 50);
            System.out.println("=====================================\n");
            String jogarNovamente;
            while (true) {
                System.out.println("Deseja jogar esta aventura novamente? (S/N)");
                jogarNovamente = input.nextLine().toUpperCase().trim();
                if (jogarNovamente.equals("S") || jogarNovamente.equals("N")) {
                    break;
                } else {
                    System.out.println("\n❌ Opção inválida! Por favor, digite 'S' para Sim ou 'N' para Não.\n");
                }
            }
            if (!jogarNovamente.equals("S")) {
                jogoAtivoInterno = false;
            }
        }
    }

    // --- MÉTODO MAIN com o MENU ---
    public static void main(String[] args) {
        System.setProperty("stdout.encoding", "UTF-8");
        Scanner input = new Scanner(System.in);
        boolean programaRodando = true;

        // Exibe o título do jogo uma vez, antes do menu.
        limparTela();
        exibirTitulo("AETHER: A MISSÃO SIDERAL");
        digitarTexto("Carregando sistemas...", 50);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        while (programaRodando) {
            limparTela();

            exibirTitulo("MENU PRINCIPAL");
            System.out.println("\nEscolha uma das opções abaixo:");
            digitarTexto("1: Iniciar Aventura", 25);
            digitarTexto("2: Instruções do Jogo", 25);
            digitarTexto("3: Chatbot da Missão", 25);
            digitarTexto("4: Créditos", 25);
            digitarTexto("5: Sair do Programa", 25);

            int escolha = obterOpcaoMenu(input, 1, 5);

            switch (escolha) {
                case 1:
                    iniciarAventuraRPG(input);
                    break;
                case 2:
                    exibirInstrucoes(input);
                    break;
                case 3:
                    exibirLinkChatbot(input);
                    break;
                case 4:
                    exibirCreditos(input);
                    break;
                case 5:
                    programaRodando = false;
                    limparTela();
                    digitarTexto("Obrigado por se aventurar em AETHER: A Missão Sideral!", 30);
                    digitarTexto("Desligando sistemas... Até a próxima jornada no cosmos da lógica!", 30);
                    break;
                default:
                    
                    break;
            }
        }
        input.close();
        System.out.println("\nPrograma encerrado. Que as estrelas guiem seu aprendizado!");
    }
}
    