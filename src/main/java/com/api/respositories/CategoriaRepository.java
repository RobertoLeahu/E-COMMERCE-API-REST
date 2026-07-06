package com.api.respositories;

import com.api.domain.models.Categoria;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends Repository<Categoria, Long> {
    List<Categoria>findAll();
    Categoria findById(Long id);
}