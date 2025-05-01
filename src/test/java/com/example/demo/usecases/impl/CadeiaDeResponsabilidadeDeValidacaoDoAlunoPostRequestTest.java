package com.example.demo.usecases.impl;

import com.example.demo.gateways.requests.AlunoPostRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequestTest {

    @Mock
    private EloValidaRegistroDoAlunoPostRequest elo;

    @InjectMocks
    private CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest cadeia;

    @Test
    void deveValidarAlunoComSucesso() {
        AlunoPostRequest request = new AlunoPostRequest("nome", "12345678900", "RA001");

        when(elo.validar(request)).thenReturn(true);

        assertTrue(cadeia.validar(request));
        verify(elo).validar(request);
    }
}
