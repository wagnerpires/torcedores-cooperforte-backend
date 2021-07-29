package br.com.desafio.cooperforteservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "tb_torcedor")
public class Torcedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 3, max = 100)
    @NotEmpty
    private String nome;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "torcedor_id", nullable = false)
    @Size(min = 1)
    @Fetch(FetchMode.SUBSELECT)
    private List<Email> emails = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "torcedor_id", nullable = false)
    @Size(min = 1)
    @Fetch(FetchMode.SUBSELECT)
    private List<Telefone> telefones = new ArrayList<>();

    @Column(nullable = false)
    @Size(min = 8, max = 8)
    private String cep;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private String bairro;

    @NotEmpty
    @Column(nullable = false)
    private String uf;

    @Column(nullable = false)
    private boolean excluido = false;

    @Column(nullable = true)
    private String complemento;

    @OneToOne
    @JsonIgnore
    private Usuario usuarioCriador;

    @OneToOne
    @JsonIgnore
    private Usuario usuarioUltimaAtualizacao;

    @JsonIgnore
    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @JsonIgnore
    @Column(nullable = false)
    private LocalDateTime dataUltimaAtualizacao;

}
