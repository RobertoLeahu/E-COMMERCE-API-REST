package com.api.mapper;

import com.api.domain.models.Categoria;
import com.api.dto.response.CategoriaResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaResponseDTO toResponse(Categoria categoria) {
        if (categoria == null) {
            return null;
        }

        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getDescripcion()
        );
    }
}
