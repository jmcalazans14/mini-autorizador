package com.desafio.vr.miniautorizador.controller.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.vr.miniautorizador.Model.CartaoModel;
import com.desafio.vr.miniautorizador.Model.CompraModel;

import com.desafio.vr.miniautorizador.controller.ITransacoes;
import com.desafio.vr.miniautorizador.util.UtilityMethods;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Transacoes", description = "Transações do Cartão Vale Refeição" , produces = MediaType.APPLICATION_JSON_VALUE)
public class TransacoesValeRefeicao implements ITransacoes {  

    @Autowired
    CartaoModel cartao; 

    @Autowired
    CompraModel compra;    

    @Override
    @ApiOperation(value = "Transaçoes cartão")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Transação realizada com sucesso"),
        @ApiResponse(code = 422, message = "Impossível realizar a Transação")        
    })
    @PostMapping(value = "/transacoes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> transacao(Long numeroCartao, int senhaCartao, Long valorCompra) {  
        
    
        cartao.setNumeroCartao(numeroCartao);
        cartao.setSenha(senhaCartao);
        cartao.setSaldo(UtilityMethods.generateSaldoRandom());

        compra.setValor(valorCompra);  

        Gson gson = new Gson();
        
        if (cartao.getSaldo() > compra.getValor()){

            cartao.setListCompras(new ArrayList<>());
            cartao.getListCompras().add(compra);        
            

            return ResponseEntity.status(201).body(gson.toJson("OK"));
        }
        else{
            
            return ResponseEntity.status(422).body(gson.toJson("SALDO_INSUFICIENTE")) ;
            
        } 
        
    }    
    
}
