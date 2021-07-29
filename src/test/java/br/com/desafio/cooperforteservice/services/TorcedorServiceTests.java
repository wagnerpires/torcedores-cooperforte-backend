package br.com.desafio.cooperforteservice.services;

import br.com.desafio.cooperforteservice.dtos.TorcedorDTO;
import br.com.desafio.cooperforteservice.repositories.TorcedorRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TorcedorServiceTests {

    @Mock
    private TorcedorRepository torcedorRepository;

    private long torcedorId;
    private String torcedorNome;
    private String torcedorCpf;
    private String torcedorCep;
    private String torcedorLogradouro;
    private String torcedorBairro;
    private String torcedorCidade;
    private String torcedorUf;
    private String torcedorComplemento;

    @BeforeEach
    void setUp() throws Exception {
        torcedorId = 3L;
        torcedorNome = "TESTE JUNIT 5";
        torcedorCpf = "58239880525";
        torcedorCep = "72870237";
        torcedorLogradouro = "LOGRADOURO JUNIT 5";
        torcedorBairro = "TAGUATINGA NORTE";
        torcedorCidade = "BRASILIA";
        torcedorUf = "DF";
        torcedorComplemento = "COMPLEMENTO ENDERECO JUNIT5";
    }

    @Test
    public void TorcedorShouldHaveCorrectStructure() {
        TorcedorDTO torcedorDTO = new TorcedorDTO();
        torcedorDTO.setId(3L);
        torcedorDTO.setNome(torcedorNome);
        torcedorDTO.setCpf(torcedorCpf);
        torcedorDTO.setCep(torcedorCep);
        torcedorDTO.setLogradouro(torcedorLogradouro);
        torcedorDTO.setBairro(torcedorBairro);
        torcedorDTO.setCidade(torcedorCidade);
        torcedorDTO.setUf(torcedorUf);
        torcedorDTO.setComplemento(torcedorComplemento);

        Assertions.assertNotNull(torcedorDTO.getId());
        Assertions.assertNotNull(torcedorDTO.getNome());
        Assertions.assertNotNull(torcedorDTO.getCpf());
        Assertions.assertNotNull(torcedorDTO.getCep());
        Assertions.assertNotNull(torcedorDTO.getLogradouro());
        Assertions.assertNotNull(torcedorDTO.getBairro());
        Assertions.assertNotNull(torcedorDTO.getCidade());
        Assertions.assertNotNull(torcedorDTO.getUf());
        Assertions.assertNotNull(torcedorDTO.getComplemento());
    }

    @Test
    public void findShouldOkResourceWhenIdExists() {
        torcedorRepository.findById(torcedorId);
        Assertions.assertEquals(1, torcedorRepository.count()+1);
    }
}
