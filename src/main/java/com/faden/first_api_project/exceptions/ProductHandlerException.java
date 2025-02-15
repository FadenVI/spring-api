package com.faden.first_api_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// ControllerAdvice que irá realizar o tratamento dos erros.
// Pode haver um global para os erros mais gerais ou específicos para cada entidade
// Esse aqui retorna na requisição da API, é necessário chamar no service para acusar o erro no terminal de comando

@RestControllerAdvice
public class ProductHandlerException {

    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
    }
}
