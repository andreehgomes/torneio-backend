package br.com.pardalzada.torneioapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ListResourceEmptyException extends RuntimeException {

    public ListResourceEmptyException() {
        super("A lista de elementos está vazia.");
    }
}
