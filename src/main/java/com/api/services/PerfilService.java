package com.api.services;

import com.api.dto.request.PerfilRequestDTO;
import com.api.dto.response.PerfilResponseDTO;

import java.util.List;

public interface PerfilService {
    PerfilResponseDTO crearPerfil(PerfilRequestDTO perfilRequestDTO);
    List<PerfilResponseDTO> obtenerPerfiles();
    PerfilResponseDTO obtenerPerfilPorIdDeUsuario(Long idUsuario);
    PerfilResponseDTO actualizarPerfil(Long idUsuario, PerfilRequestDTO perfilRequestDTO);
}