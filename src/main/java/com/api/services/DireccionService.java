package com.api.services;

import com.api.dto.request.DireccionRequestDTO;
import com.api.dto.response.DireccionResponseDTO;

public interface DireccionService {
    DireccionResponseDTO crearDireccion(Long idUsuario, DireccionRequestDTO direccionRequestDTO);
}
