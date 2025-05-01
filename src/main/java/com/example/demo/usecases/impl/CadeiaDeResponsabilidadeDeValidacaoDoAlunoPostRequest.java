package com.example.demo.usecases.impl;

import com.example.demo.gateways.requests.AlunoPostRequest;

public class CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest {

    private final EloValidaRegistroDoAlunoPostRequest elo;

    public CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest(EloValidaRegistroDoAlunoPostRequest elo) {
        this.elo = elo;
    }

    public boolean validar(AlunoPostRequest request) {
        return elo.validar(request);
    }
}

