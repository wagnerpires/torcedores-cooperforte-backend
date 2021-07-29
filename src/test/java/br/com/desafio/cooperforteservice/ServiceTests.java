package br.com.desafio.cooperforteservice;

import br.com.desafio.cooperforteservice.entities.Torcedor;
import br.com.desafio.cooperforteservice.exceptions.TorcedorNotFound;
import br.com.desafio.cooperforteservice.repositories.TorcedorRepository;
import br.com.desafio.cooperforteservice.services.TorcedorService;
import br.com.desafio.cooperforteservice.services.exceptions.DatabaseException;
import br.com.desafio.cooperforteservice.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
public class ServiceTests {

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
