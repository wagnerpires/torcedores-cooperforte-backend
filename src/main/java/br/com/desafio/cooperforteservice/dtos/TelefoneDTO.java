package br.com.desafio.cooperforteservice.dtos;

import br.com.desafio.cooperforteservice.enums.TipoTelefoneEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneDTO {
    private Long id;

    @NotNull
    @NotBlank
    private TipoTelefoneEnum tipo;

    @NotNull
    @NotBlank
    private String telefone;

    private String principal;
}
