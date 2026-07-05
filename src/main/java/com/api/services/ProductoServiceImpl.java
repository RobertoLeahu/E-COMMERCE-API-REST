package com.api.services;

import com.api.domain.models.Producto;
import com.api.respositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public String borrarProducto(Long id) {
        productoRepository.deleteById(id);
        return "Producto con id " + id + " borrado correctamente";
    }
}
