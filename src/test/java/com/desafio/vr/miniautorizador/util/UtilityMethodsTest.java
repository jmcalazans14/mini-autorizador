package com.desafio.vr.miniautorizador.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilityMethodsTest {
    
    @Test
    void testGenerateSaldoRandom() {

        assertTrue(UtilityMethods.generateSaldoRandom() > 0 );        

    }
}
