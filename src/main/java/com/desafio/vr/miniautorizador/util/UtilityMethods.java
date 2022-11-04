package com.desafio.vr.miniautorizador.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UtilityMethods {

    public Double generateSaldoRandom() {

        return (Math.random() * ((500.0 - 100.0) + 1)) + 0.0;        
    }
    
}
