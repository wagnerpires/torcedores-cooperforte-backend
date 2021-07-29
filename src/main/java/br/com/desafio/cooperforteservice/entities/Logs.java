package br.com.desafio.cooperforteservice.entities;

import br.com.desafio.cooperforteservice.enums.OperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tb_transacao")
public class Logs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private OperacaoEnum operacao;

    @OneToOne
    @NotNull
    private Usuario autor;

    @NotNull
    private LocalDateTime data;

    @OneToOne
    @NotNull
    private Torcedor torcedor;


}
