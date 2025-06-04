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
        }
    }
}