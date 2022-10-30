package com.desafio.vr.miniautorizador.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping
public interface ITransacoes {

    @PostMapping(value = "/transacoes", produces = MediaType.APPLICATION_JSON_VALUE)
    public String transacao(@RequestParam ( required = true) Long numeroCartao, 
                            @RequestParam(required = true) int senhaCartao,
                            @RequestParam (required = true) Long valorCompra);
    
}
