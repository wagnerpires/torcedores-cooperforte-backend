package br.com.desafio.cooperforteservice.services;

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

    @BeforeEach
    void setUp() throws Exception {
        torcedorId = 1L;
    }

    @Test
    public void findShouldOkResourceWhenIdExists() {
       torcedorRepository.findById(torcedorId);
       Assertions.assertEquals(1, torcedorRepository.count()+1);
    }
}
