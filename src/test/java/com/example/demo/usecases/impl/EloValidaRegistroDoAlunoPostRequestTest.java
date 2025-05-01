package com.example.demo.usecases.impl;

import com.example.demo.gateways.requests.AlunoPostRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EloValidaRegistroDoAlunoPostRequestTest {

    @InjectMocks
    private EloValidaRegistroDoAlunoPostRequest elo;

    @Test
    void deveRetornarTrueParaAlunoValido() {
        AlunoPostRequest request = new AlunoPostRequest("nome", "12345678900", "RA001");
        assertTrue(elo.validar(request));
    }

    @Test
    void deveRetornarFalseParaCPFInvalido() {
        AlunoPostRequest request = new AlunoPostRequest("nome", "123", "RA001");
        assertFalse(elo.validar(request));
    }
}
