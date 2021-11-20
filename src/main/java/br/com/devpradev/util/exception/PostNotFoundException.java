package br.com.devpradev.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostNotFoundException extends Exception{
    public PostNotFoundException(long id){
        super("Post não encontrado para o ID " + id);
    }

}
