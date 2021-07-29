package br.com.desafio.cooperforteservice.services.mappers;

import br.com.desafio.cooperforteservice.dtos.TorcedorDTO;
import br.com.desafio.cooperforteservice.entities.Torcedor;
import br.com.desafio.cooperforteservice.entities.Email;
import br.com.desafio.cooperforteservice.entities.Telefone;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

public class TorcedorDTOMapper {

    public static  TorcedorDTO parseParaDTO(Torcedor torcedor) {

        return TorcedorDTO.builder()
                .id(torcedor.getId())
                .nome(torcedor.getNome())
                .cpf(torcedor.getCpf())
                .uf(torcedor.getUf())
                .cidade(torcedor.getCidade())
                .logradouro(torcedor.getLogradouro())
                .complemento(torcedor.getComplemento())
                .bairro(torcedor.getBairro())
                .cep(torcedor.getCep())
                .emails(EmailDTOMapper.parseParaDTO(torcedor.getEmails()))
                .telefones(TelefoneDTOMapper.parseParaDTO(torcedor.getTelefones()))
                .build();
    }


    public static Torcedor parseParaEntity(TorcedorDTO torcedorDTO) {

        return Torcedor.builder()
                .id(torcedorDTO.getId())
                .nome(torcedorDTO.getNome())
                .cpf(torcedorDTO.getCpf())
                .uf(torcedorDTO.getUf())
                .cidade(torcedorDTO.getCidade())
                .logradouro(torcedorDTO.getLogradouro())
                .complemento(torcedorDTO.getComplemento())
                .bairro(torcedorDTO.getBairro())
                .cep(torcedorDTO.getCep())
                .emails(EmailDTOMapper.parseParaEntidade(torcedorDTO.getEmails()))
                .telefones(TelefoneDTOMapper.parseParaEntidade(torcedorDTO.getTelefones()))
                .dataCriacao(LocalDateTime.now())
                .dataUltimaAtualizacao(LocalDateTime.now())
                .build();
    }

    public static Torcedor atualizarEntity(TorcedorDTO torcedorDTO, Torcedor torcedor) {
        List<Email> emails = EmailDTOMapper.parseParaEntidade(torcedorDTO.getEmails());
        List<Telefone> telefones = TelefoneDTOMapper.parseParaEntidade(torcedorDTO.getTelefones());

        torcedor.setNome(torcedorDTO.getNome());
        torcedor.setCpf(torcedorDTO.getCpf());
        torcedor.setUf(torcedorDTO.getUf());
        torcedor.setCidade(torcedorDTO.getCidade());
        torcedor.setLogradouro(torcedorDTO.getLogradouro());
        torcedor.setComplemento(torcedorDTO.getComplemento());
        torcedor.setBairro(torcedorDTO.getBairro());
        torcedor.setCep(torcedorDTO.getCep());
        torcedor.getEmails().clear();
        torcedor.getEmails().addAll(emails);
        torcedor.getTelefones().clear();
        torcedor.getTelefones().addAll(telefones);
        torcedor.setDataUltimaAtualizacao(LocalDateTime.now());

        return torcedor;

    }
}
