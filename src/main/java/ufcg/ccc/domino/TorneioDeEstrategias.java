package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaCarrocao;
import ufcg.ccc.domino.estrategia.JogaMaiorPeca;
import ufcg.ccc.domino.estrategia.JogaMenorPeca;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

/**
 * Torneio entre todas as estratégias disponíveis.
 * Cada estratégia joga contra todas as outras em uma série de partidas.
 */
public class TorneioDeEstrategias {

    public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
        // Lista de todas as estratégias
        EstrategiaDeJogo[] estrategias = {
            new JogaPrimeiraPossivel(),
            new JogaMaiorPeca(),
            new JogaMenorPeca(),
            new JogaCarrocao()
        };

        String[] nomesEstrategias = {
            "JogaPrimeiraPossivel",
            "JogaMaiorPeca",
            "JogaMenorPeca",
            "JogaCarrocao"
        };

        // Matriz para armazenar resultados
        int[][] resultados = new int[estrategias.length][estrategias.length];
        int[] vitorias = new int[estrategias.length];
        int[] empates = new int[estrategias.length];

        // Número de jogos entre cada par de estratégias
        int numJogos = 1000;

        // Realiza os jogos
        for (int i = 0; i < estrategias.length; i++) {
            for (int j = i + 1; j < estrategias.length; j++) {
                System.out.println("\n" + nomesEstrategias[i] + " vs " + nomesEstrategias[j]);
                
                int vitoriasI = 0, vitoriasJ = 0, empatesIJ = 0;

                for (int k = 0; k < numJogos; k++) {
                    Jogo jogo = new Jogo("E" + i, estrategias[i], "E" + j, estrategias[j], 12);
                    HistoricoDeJogo historico = jogo.jogaJogoCompleto();

                    if (historico.isEmpate()) {
                        empatesIJ++;
                        empates[i]++;
                        empates[j]++;
                    } else if (historico.getVencedor().equals("E" + i)) {
                        vitoriasI++;
                        vitorias[i]++;
                    } else {
                        vitoriasJ++;
                        vitorias[j]++;
                    }
                }

                resultados[i][j] = vitoriasI;
                resultados[j][i] = vitoriasJ;

                System.out.println(nomesEstrategias[i] + ": " + vitoriasI + " vitórias");
                System.out.println(nomesEstrategias[j] + ": " + vitoriasJ + " vitórias");
                System.out.println("Empates: " + empatesIJ);
            }
        }

        // Imprime o resumo final
        System.out.println("\n=== RESUMO DO TORNEIO ===");
        System.out.println("Total de jogos por confronto: " + numJogos);
        System.out.println("\nVitórias por estratégia:");
        for (int i = 0; i < estrategias.length; i++) {
            System.out.println(nomesEstrategias[i] + ": " + vitorias[i] + " vitórias, " + empates[i] + " empates");
        }

        System.out.println("\nMatriz de confrontos diretos:");
        System.out.print("          ");
        for (String nome : nomesEstrategias) {
            System.out.printf("%-15s", nome);
        }
        System.out.println();

        for (int i = 0; i < estrategias.length; i++) {
            System.out.printf("%-10s", nomesEstrategias[i]);
            for (int j = 0; j < estrategias.length; j++) {
                if (i == j) {
                    System.out.printf("%-15s", "X");
                } else {
                    System.out.printf("%-15d", resultados[i][j]);
                }
            }
            System.out.println();
        }
    }
} 