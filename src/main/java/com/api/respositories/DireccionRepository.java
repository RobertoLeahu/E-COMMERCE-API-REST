package com.api.respositories;

import com.api.domain.models.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface DireccionRepository extends JpaRepository<Direccion, Long> {
}
