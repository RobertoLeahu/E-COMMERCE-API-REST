package com.api.dto.response;

public record DireccionResponseDTO(
        String titulo,
        String calle,
        String ciudad,
        String provincia,
        String codigoPostal,
        String pais,
        Long idUsuario
) {}
