package com.example.demo.usecases.impl;

import com.example.demo.gateways.requests.AlunoPostRequest;

public class EloValidaRegistroDoAlunoPostRequest {

    public boolean validar(AlunoPostRequest request) {
        String cpf = request.documento();
        return cpf != null && cpf.matches("\\d{11}");
    }
}
