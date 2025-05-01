package com.example.demo.usecases.impl;

import com.example.demo.configs.RabbitMQConfig;
import com.example.demo.domains.Aluno;
import com.example.demo.gateways.AlunoRepository;
import com.example.demo.usecases.CadastrarAluno;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarAlunoImpl implements CadastrarAluno {

  private final AlunoRepository alunoRepository;
  private final RabbitTemplate rabbitTemplate;
  private final ObjectMapper objectMapper;

  @Override
  public Aluno executa(Aluno alunoParaSerCadastrado) {
    Aluno alunoSalvo = alunoRepository.save(alunoParaSerCadastrado);

    try {
      String mensagemJson = objectMapper.writeValueAsString(alunoSalvo);

      rabbitTemplate.convertAndSend(
              RabbitMQConfig.EXCHANGE_NAME,
              RabbitMQConfig.ROUTING_KEY,
              mensagemJson
      );
    } catch (JsonProcessingException e) {
      System.err.println("Erro ao converter aluno para JSON: " + e.getMessage());
    }

    return alunoSalvo;
  }

  public void helloWorld() {  }
}
