package br.com.pardalzada.torneioapi.handler;

import br.com.pardalzada.torneioapi.exceptions.ListResourceEmptyException;
import br.com.pardalzada.torneioapi.exceptions.RepositoryException;
import br.com.pardalzada.torneioapi.exceptions.ResourceDuplicatedException;
import br.com.pardalzada.torneioapi.exceptions.ResourceNotFoundException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerHandler extends ResponseEntityExceptionHandler {

    private static final String ELEMTENTO_DATA_HORA = "Data Hora";
    private static final String ELEMENTO_MENSAGEM = "Mensagem";

    @ExceptionHandler(ListResourceEmptyException.class)
    public ResponseEntity<Object> handleListResourceEmptyException(ListResourceEmptyException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(ELEMTENTO_DATA_HORA, gerarDataHoraFormatada());
        body.put(ELEMENTO_MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RepositoryException.class)
    public ResponseEntity<Object> handleRepositoryException(RepositoryException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(ELEMTENTO_DATA_HORA, gerarDataHoraFormatada());
        body.put(ELEMENTO_MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceDuplicatedException.class)
    public ResponseEntity<Object> handleResourceDuplicatedException(ResourceDuplicatedException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(ELEMTENTO_DATA_HORA, gerarDataHoraFormatada());
        body.put(ELEMENTO_MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put(ELEMTENTO_DATA_HORA, gerarDataHoraFormatada());
        body.put(ELEMENTO_MENSAGEM, ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private String gerarDataHoraFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(formatter);
    }
}
