package com.api.services;

import com.api.domain.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService{
    Producto guardarProducto(Producto producto);
    Optional<Producto> obtenerProductoPorId(Long id);
    List<Producto> obtenerProductos();
    String borrarProducto(Long id);
}
