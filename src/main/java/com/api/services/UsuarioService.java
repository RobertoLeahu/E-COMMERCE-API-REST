package com.api.services;

import com.api.dto.request.UsuarioRequestDTO;
import com.api.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioResponseDTO crearUsuarioCliente(UsuarioRequestDTO usuarioRequestDTO);
    List<UsuarioResponseDTO> mostrarUsuarios();
    UsuarioResponseDTO mostrarUsuariosPorId(Long id);
    String borrarUsuario(Long id);
}