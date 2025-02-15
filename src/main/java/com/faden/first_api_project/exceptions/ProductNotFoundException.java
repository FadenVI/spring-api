package com.faden.first_api_project.exceptions;

// Cria uma exceção que trata de um erro específico
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
