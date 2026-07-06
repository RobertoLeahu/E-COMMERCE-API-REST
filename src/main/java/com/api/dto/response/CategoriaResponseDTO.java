package com.api.dto.response;

import com.api.domain.models.Producto;

import java.util.List;

public record CategoriaResponseDTO(
        Long id,
        String nombre,
        String descripcion
) {}
