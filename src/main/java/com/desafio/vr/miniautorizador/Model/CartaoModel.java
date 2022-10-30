package com.desafio.vr.miniautorizador.Model;

import java.util.List;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CartaoModel {

    @ApiModelProperty(value = "Número do Cartão")
    Long numeroCartao;    

    @ApiModelProperty(value = "Senha do cartão")
    int senhaCartao;

    @ApiModelProperty(value = "Lista de compras")
    List<CompraModel> listCompras;
    
}
