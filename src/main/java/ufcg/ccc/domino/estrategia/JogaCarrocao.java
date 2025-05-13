package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Peca;

/**
 * Estratégia que prioriza jogar peças duplas (carroções).
 * Se houver um carroção que encaixa, joga ele.
 * Se não houver carroção que encaixe, joga a primeira peça que encaixa.
 */
public class JogaCarrocao implements EstrategiaDeJogo {

    @Override
    public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
        // Se a mesa estiver vazia, procura um carroção para jogar
        if (mesa.getNumPecas() == 0) {
            // Procura o maior carroção
            for (int i = 6; i >= 0; i--) {
                for (Peca peca : mao) {
                    if (peca.getNumDireito() == i && peca.getNumEsquerdo() == i) {
                        return new Jogada(peca, TipoJogada.NA_DIREITA);
                    }
                }
            }
            // Se não encontrou carroção, joga a primeira peça
            return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);
        }

        // Procura primeiro um carroção que encaixe
        for (Peca peca : mao) {
            if (peca.getNumDireito() == peca.getNumEsquerdo()) {
                if (peca.encaixa(mesa.getNumNaDireita())) {
                    return new Jogada(peca, TipoJogada.NA_DIREITA);
                }
                if (peca.encaixa(mesa.getNumNaEsquerda())) {
                    return new Jogada(peca, TipoJogada.NA_ESQUERDA);
                }
            }
        }

        // Se não encontrou carroção que encaixe, joga a primeira peça que encaixa
        for (Peca peca : mao) {
            if (peca.encaixa(mesa.getNumNaDireita())) {
                return new Jogada(peca, TipoJogada.NA_DIREITA);
            }
            if (peca.encaixa(mesa.getNumNaEsquerda())) {
                return new Jogada(peca, TipoJogada.NA_ESQUERDA);
            }
        }

        // Se não encontrou nenhuma peça que encaixa, passa a vez
        return new Jogada();
    }
} 