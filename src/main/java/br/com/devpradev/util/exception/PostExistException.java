package br.com.devpradev.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PostExistException extends Exception {
    public PostExistException(long id){
        super("Post não encontrado para o ID " + id);
    }
}
