package br.com.pardalzada.torneioapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ResourceDuplicatedException extends RuntimeException {

    public ResourceDuplicatedException(Long id) {
        super(String.format("O elemento com o ID %d já se encontra cadastrado", id));
    }
}
