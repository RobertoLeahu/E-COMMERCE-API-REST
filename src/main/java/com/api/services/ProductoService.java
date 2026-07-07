package com.api.services;

import com.api.domain.models.Producto;
import com.api.dto.request.ProductoRequestDTO;
import com.api.dto.response.ProductoResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProductoService{
    ProductoResponseDTO guardarProducto(ProductoRequestDTO productoRequestDTO);
    List<ProductoResponseDTO> obtenerProductos();
    ProductoResponseDTO obtenerProductoPorId(Long id);
    String borrarProducto(Long id);
}