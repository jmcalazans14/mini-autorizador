package com.desafio.vr.miniautorizador.controller.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.vr.miniautorizador.controller.ITransacoes;

@SpringBootTest
public class TransacoesValeRefeicaoTest {

    @Autowired
    ITransacoes svcTransacao;
    
    
    @Test
    void testTransacaoSaldoPositivo() {

        assertEquals(201, svcTransacao.transacao(1234123412341234L, 1234,10L).getStatusCodeValue());        

    }

    @Test
    void testTransacaoSaldoInsuficiente(){

        assertEquals(422, svcTransacao.transacao(1234123412341234L, 1234,1000000000L).getStatusCodeValue());        


    }

}
