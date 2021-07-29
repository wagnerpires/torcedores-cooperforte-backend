package br.com.desafio.cooperforteservice.kafka;

import br.com.desafio.cooperforteservice.dtos.TorcedorDTO;
import br.com.desafio.cooperforteservice.entities.Torcedor;
import org.springframework.stereotype.Service;

@Service
public class TorcedorKafka {

    // private KafkaTemplate<String, String> kafkaTemplate

    public void torcedorCadastrado(TorcedorDTO torcedorDTO) {
        // Integração com o Kafka
        // kafkaTemplate.send("TorcedorCadastrado", torcedorDTO.getCpf());
    }

    public void torcedorDesligado(Torcedor torcedor) {
        // Integração com o Kafka
        // kafkaTemplate.send("TorcedorDesligado", torcedorDTO.getCpf());
    }
}
