package com.desafio.vr.miniautorizador.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.vr.miniautorizador.Model.CartaoModel;
import com.desafio.vr.miniautorizador.controller.ICartoes;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = "Cartoes", description = "Cadastro e saldo do Cartão Vale Refeição" , produces = MediaType.APPLICATION_JSON_VALUE)
public class CartaoValeRefeicao implements ICartoes  {

    @Autowired
    ICartoes cartoes;

    @Autowired
    CartaoModel cartao;
    
    @Override
    @ApiOperation(value = "Obter saldo do Cartão")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Saldo obtido com sucesso"),
        @ApiResponse(code = 404, message = "Cartão inexistente"),
        @ApiResponse(code = 500, message = "Erro"),
    })
    @GetMapping(value = "/cartoes/{numeroCartao}", produces = MediaType.APPLICATION_JSON_VALUE )
    public String obterSaldo(@PathVariable Long numeroCartao) {

        cartao = new CartaoModel();

        cartao.setNumeroCartao(numeroCartao);           

        return "Saldo";
    }

    @Override
    @ApiOperation(value = "Cadastra o cartão")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Cartão cadastrado com sucesso"),
        @ApiResponse(code = 403, message = "O cartão já existe na base"),
        @ApiResponse(code = 500, message = "Erro"),
    })
    @PostMapping(value = "/cartoes", produces = MediaType.APPLICATION_JSON_VALUE )
    public String AdicionaCartao (@RequestParam ( required = true) Long numeroCartao, 
                                @RequestParam(required = true) int senha) {        
        
        
        cartao.setNumeroCartao(numeroCartao);
        cartao.setSenhaCartao(senha);        

        return "Cadastro";
    }    
   

    
    
}
