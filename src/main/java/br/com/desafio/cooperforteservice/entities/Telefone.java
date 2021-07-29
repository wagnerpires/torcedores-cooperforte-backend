package br.com.desafio.cooperforteservice.entities;

import br.com.desafio.cooperforteservice.enums.TipoTelefoneEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tb_telefone")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoTelefoneEnum tipo;

    @NotEmpty
    @Column(nullable = false)
    private String telefone;

    private String principal;

}
