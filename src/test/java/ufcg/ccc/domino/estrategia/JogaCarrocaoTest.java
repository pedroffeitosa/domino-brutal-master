package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

class JogaCarrocaoTest {

    private Mesa mesa;

    @BeforeEach
    void setUp() throws Exception {
        mesa = new Mesa();
        mesa.jogaNaDireita(new Peca(1, 2));
        mesa.jogaNaEsquerda(new Peca(1, 1));
    }

    @Test
    void testPassa() {
        JogaCarrocao estrategia = new JogaCarrocao();
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(0, 3)));
        assertEquals(TipoJogada.PASSA, j1.getTipo());
    }

    @Test
    void testJogaCarrocao() {
        JogaCarrocao estrategia = new JogaCarrocao();
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 2), new Peca(2, 6), new Peca(2, 1)));
        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(2, j1.getPeca().getNumEsquerdo());
        assertEquals(2, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaPrimeiraSeNaoTemCarrocao() {
        JogaCarrocao estrategia = new JogaCarrocao();
        Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(2, 1), new Peca(1, 2)));
        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(1, j1.getPeca().getNumEsquerdo());
        assertEquals(2, j1.getPeca().getNumDireito());
    }

    @Test
    void testJogaMaiorCarrocaoNoInicio() {
        JogaCarrocao estrategia = new JogaCarrocao();
        Mesa mesaVazia = new Mesa();
        Jogada j1 = estrategia.decideJogada(mesaVazia, List.of(new Peca(2, 2), new Peca(6, 6), new Peca(3, 3)));
        assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
        assertEquals(6, j1.getPeca().getNumEsquerdo());
        assertEquals(6, j1.getPeca().getNumDireito());
    }
} 