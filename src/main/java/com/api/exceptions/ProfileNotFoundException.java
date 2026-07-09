package com.api.exceptions;

public class ProfileNotFoundException extends RuntimeException {
    public ProfileNotFoundException(Long id) {
        super("Perfil con id " + id + " no encontrado");
    }
}
