package com.api.services;

import com.api.domain.models.Categoria;
import com.api.dto.response.CategoriaResponseDTO;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaResponseDTO> obtenerCategorias();
    CategoriaResponseDTO obtenerCategoriaPorId(Long id);
}