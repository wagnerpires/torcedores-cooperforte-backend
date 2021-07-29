package br.com.desafio.cooperforteservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TorcedorNotFound extends RuntimeException {
    public TorcedorNotFound(String mensagem) {
        super(mensagem);
    }
}
