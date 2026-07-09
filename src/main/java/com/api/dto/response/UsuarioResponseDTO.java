package com.api.dto.response;

import com.api.domain.enums.Rol;

public record UsuarioResponseDTO(
        Long id,
        String email,
        Rol rol
) {}
