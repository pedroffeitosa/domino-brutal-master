package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

class JogaMenorPecaTest {

    private Mesa mesa;

    @BeforeEach
    void setUp() throws Exception {
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(1, 2));
        mesa.jogaNaEsquerda(new Peca(1, 1));
    }

    @Test
    void testPassa() {
        JogaMenorPeca estrategia = new JogaMenorPeca();
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(0, 3)));
        assertEquals(TipoJogada.PASSA, j1.getTipo());
    }

    @Test
    void testJogaMenorPeca() {
        JogaMenorPeca estrategia = new JogaMenorPeca();
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 2), new Peca(2, 6), new Peca(2, 1)));
        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(2, j1.getPeca().getNumEsquerdo());
        assertEquals(1, j1.getPeca().getNumDireito());
    }

    @Test
    void testPrefereDireitaEmEmpate() {
        JogaMenorPeca estrategia = new JogaMenorPeca();
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 1), new Peca(1, 2)));
        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(1, j1.getPeca().getNumEsquerdo());
        assertEquals(2, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaNaEsquerdaSeMenor() {
        JogaMenorPeca estrategia = new JogaMenorPeca();
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(1, 3), new Peca(2, 1)));
        assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
        assertEquals(1, j1.getPeca().getNumEsquerdo());
        assertEquals(3, j1.getPeca().getNumDireito());
    }
} 