package com.api.dto.response;

public record PerfilResponseDTO(
        String nombre,
        String apellido,
        String telefono,
        Long idUsuario
) {}