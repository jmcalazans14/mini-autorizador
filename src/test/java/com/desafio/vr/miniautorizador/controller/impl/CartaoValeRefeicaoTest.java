package com.desafio.vr.miniautorizador.controller.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.vr.miniautorizador.controller.ICartoes;

@SpringBootTest
public class CartaoValeRefeicaoTest {

    @Autowired
    ICartoes svcCartao;


    @Test
    void testAdicionaCartaoSucesso() {        

        assertEquals(201, svcCartao.AdicionaCartao(1234123412341234L, 1234).getStatusCodeValue());
    }

    @Test
    void testObterSaldoSucesso() {

        assertEquals(200, svcCartao.obterSaldo(1234123412341234L).getStatusCodeValue());
    }
    
}
