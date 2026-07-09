package com.api.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Usuarios con id " + id + " no encontrado");
    }
}
