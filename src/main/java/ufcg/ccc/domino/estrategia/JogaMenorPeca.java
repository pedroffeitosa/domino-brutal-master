package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Estratégia que sempre joga a peça de menor valor que encaixa.
 * Se houver múltiplas peças que encaixam, escolhe a que tem a menor soma.
 * Em caso de empate, prioriza jogar na direita.
 */
public class JogaMenorPeca implements EstrategiaDeJogo {

    @Override
    public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
        // Se a mesa estiver vazia, joga a primeira peça
        if (mesa.getNumPecas() == 0) {
            return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
        }

        Peca melhorPeca = null;
        TipoJogada melhorLado = null;
        int menorSoma = Integer.MAX_VALUE;

        // Procura a peça com menor soma que encaixa
        for (Peca peca : mao) {
            if (peca.encaixa(mesa.getNumNaDireita())) {
                int soma = peca.getNumDireito() + peca.getNumEsquerdo();
                if (soma < menorSoma) {
                    menorSoma = soma;
                    melhorPeca = peca;
                    melhorLado = TipoJogada.NA_DIREITA;
                }
            }
            if (peca.encaixa(mesa.getNumNaEsquerda())) {
                int soma = peca.getNumDireito() + peca.getNumEsquerdo();
                if (soma < menorSoma) {
                    menorSoma = soma;
                    melhorPeca = peca;
                    melhorLado = TipoJogada.NA_ESQUERDA;
                }
            }
        }

        // Se encontrou uma peça que encaixa, joga ela
        if (melhorPeca != null) {
            return new Jogada(melhorPeca, melhorLado);
        }

        // Se não encontrou nenhuma peça que encaixa, passa a vez
        return new Jogada();
    }
} 