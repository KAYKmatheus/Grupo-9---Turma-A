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

        }
    }
}