package com.api.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long id){
        super("Categoria con id " + id + " no encontrada");
    }
}
