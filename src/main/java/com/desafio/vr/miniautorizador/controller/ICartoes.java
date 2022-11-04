package com.desafio.vr.miniautorizador.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping
public interface ICartoes {
    
    
    public ResponseEntity<String> AdicionaCartao (@RequestParam ( required = true) Long numeroCartao, 
                                @RequestParam(required = true) int senha);

    public ResponseEntity<String> obterSaldo(@PathVariable Long numeroCartao);    

}
