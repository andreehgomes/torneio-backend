package br.com.pardalzada.torneioapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Long id) {
        super(String.format("Não existe o elemento com o ID %d.", id));
    }
    
    public ResourceNotFoundException(String cpf) {
//       super(String.format("Não existe o elemento com o CPF %d.", cpf));
       super("Não existe o elemento com o CPF " + cpf);
    }
    
    public ResourceNotFoundException(Object object) {
        super(String.format("Não existe o elemento com o CPF %d.", object));
    }
}
