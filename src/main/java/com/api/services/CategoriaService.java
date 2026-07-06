package com.api.services;

import com.api.domain.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<Categoria> obtenerCategorias();
    Optional<Categoria> obtenerCategoriaPorId(Long id);
}