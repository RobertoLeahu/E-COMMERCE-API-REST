package com.api.services;

import com.api.domain.models.Categoria;
import com.api.dto.response.CategoriaResponseDTO;
import com.api.mapper.CategoriaMapper;
import com.api.respositories.CategoriaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    // INYECCIÓN POR CONSTRUCTOR
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public List<CategoriaResponseDTO> obtenerCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaResponseDTO obtenerCategoriaPorId(Long id) {
        Categoria categoria = categoriaRepository.findById(id);

        if (categoria == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La categoría con ID " + id + " no existe.");
        }

        return categoriaMapper.toResponse(categoria);
    }
}