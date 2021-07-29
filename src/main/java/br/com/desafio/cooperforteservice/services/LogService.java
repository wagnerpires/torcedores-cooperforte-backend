package br.com.desafio.cooperforteservice.services;

import br.com.desafio.cooperforteservice.entities.Torcedor;
import br.com.desafio.cooperforteservice.entities.Logs;
import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import br.com.desafio.cooperforteservice.repositories.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class LogService {

    private AutenticacaoService autenticacaoService;
    private LogRepository logRepository;

    public void registrar(OperacaoEnum operacaoEnum, Torcedor torcedor) {

        Logs log = Logs.builder()
                .operacao(operacaoEnum)
                .data(LocalDateTime.now())
                .torcedor(torcedor)
                .autor(autenticacaoService
                        .obterUsuarioLogado())
                .build();

        logRepository.save(log);
    }
}
