package br.com.pardalzada.torneioapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RepositoryException extends RuntimeException {

    public RepositoryException() {
        super("Erro ao manipular no banco de dados.");
    }
}
