package com.desafio.vr.miniautorizador.Model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.annotations.Expose;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CartaoModel {

    @Expose
    @ApiModelProperty(value = "Número do Cartão")
    Long numeroCartao;    

    @Expose
    @ApiModelProperty(value = "Senha do cartão")
    int senha;
    
    @ApiModelProperty(value = "Saldo do cartão")
    double saldo;

    @ApiModelProperty(value = "Lista de compras")
    List<CompraModel> listCompras;
    
}
