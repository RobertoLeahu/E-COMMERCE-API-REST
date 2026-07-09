package com.api.exceptions;

public class ProfileAlreadyAssignedException extends RuntimeException {
    public ProfileAlreadyAssignedException(Long id) {
        super("El usuario ya tiene un perfil asignado con id " + id);
    }
}
