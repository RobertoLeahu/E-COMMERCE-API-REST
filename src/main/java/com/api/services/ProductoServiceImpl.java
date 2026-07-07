package com.api.services;

import com.api.domain.models.Categoria;
import com.api.domain.models.Producto;
import com.api.dto.request.ProductoRequestDTO;
import com.api.dto.response.ProductoResponseDTO;
import com.api.exceptions.ProductNotFoundException;
import com.api.mapper.ProductoMapper;
import com.api.respositories.CategoriaRepository;
import com.api.respositories.ProductoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService{

    final private ProductoRepository productoRepository;
    final private ProductoMapper productoMapper;
    final private CategoriaRepository categoriaRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper, CategoriaRepository categoriaRepository){
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ProductoResponseDTO guardarProducto(ProductoRequestDTO productoRequestDTO) {

        Long categoriaId = productoRequestDTO.categoriaId();

        Categoria categoria = categoriaRepository.findById(categoriaId);
        if (categoria == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La categoría con ID " + categoriaId + " no existe.");
        }

        Producto productoNuevo = productoMapper.toEntity(productoRequestDTO, categoria);
        Producto productoGuardado = productoRepository.save(productoNuevo);
        return productoMapper.toResponse(productoGuardado);
    }

    @Override
    public ProductoResponseDTO obtenerProductoPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return productoMapper.toResponse(producto);
    }

    @Override
    public List<ProductoResponseDTO> obtenerProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream()
                .map(productoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public String borrarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }

        productoRepository.deleteById(id);
        return "Producto con id " + id + " borrado correctamente";
    }
}
