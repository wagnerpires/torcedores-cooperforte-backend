package br.com.desafio.cooperforteservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_perfil")
public class Perfil implements GrantedAuthority {
    @Id
    private Long id;

    @Column(name = "papel")
    private String nome;

    @Override
    public String getAuthority() {
        return nome;
    }

}
