package br.com.desafio.cooperforteservice.services.mappers;

import br.com.desafio.cooperforteservice.dtos.EmailDTO;
import br.com.desafio.cooperforteservice.entities.Email;

import java.util.List;
import java.util.stream.Collectors;

public class EmailDTOMapper {

    public static List<Email> parseParaEntidade(List<EmailDTO> emails) {
        return emails.stream().map(email -> Email.builder()
                .id(email.getId())
                .email(email.getEmail())
                .build())
                .collect(Collectors.toList());
    }

    public static List<EmailDTO> parseParaDTO(List<Email> emails) {
        return emails.stream().map(email -> EmailDTO.builder()
                        .id(email.getId())
                        .email(email.getEmail())
                        .build())
                .collect(Collectors.toList());
    }




}
