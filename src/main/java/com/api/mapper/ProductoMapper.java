package com.api.mapper;

import com.api.domain.models.Categoria;
import com.api.domain.models.Producto;
import com.api.dto.request.ProductoRequestDTO;
import com.api.dto.response.ProductoResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {

    public ProductoResponseDTO toResponse(Producto producto) {
        if (producto == null) {
            return null;
        }

        return new ProductoResponseDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getStock(),
                producto.getImagenUrl(),
                producto.getCategoriaId().getNombre() != null ? producto.getCategoriaId().getNombre(): null
        );
    }

    public Producto toEntity(ProductoRequestDTO productoRequestDTO, Categoria categoria) {

        if (productoRequestDTO == null) {
            return null;
        }

        Producto producto = new Producto();
        producto.setNombre(productoRequestDTO.nombre());
        producto.setDescripcion(productoRequestDTO.descripcion());
        producto.setPrecio(productoRequestDTO.precio());
        producto.setStock(productoRequestDTO.stock());
        producto.setImagenUrl(productoRequestDTO.imagenUrl());
        producto.setCategoriaId(categoria);

        return producto;
    }
}