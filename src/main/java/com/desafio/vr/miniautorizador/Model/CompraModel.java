package com.desafio.vr.miniautorizador.Model;

import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class CompraModel {

    @ApiModelProperty(value = "Valor da compra")
    Long valor;   
    
}
