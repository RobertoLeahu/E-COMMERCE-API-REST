package com.api.services.impl;

import com.api.domain.models.Direccion;
import com.api.domain.models.Usuario;
import com.api.dto.request.DireccionRequestDTO;
import com.api.dto.response.DireccionResponseDTO;
import com.api.exceptions.UserNotFoundException;
import com.api.mapper.DireccionMapper;
import com.api.respositories.DireccionRepository;
import com.api.respositories.UsuarioRepository;
import com.api.services.DireccionService;
import org.springframework.stereotype.Service;

@Service
public class DireccionServiceImpl implements DireccionService {

    final private DireccionRepository direccionRepository;
    final private DireccionMapper direccionMapper;
    final private UsuarioRepository usuarioRepository;

    public DireccionServiceImpl(DireccionRepository direccionRepository, DireccionMapper direccionMapper, UsuarioRepository usuarioRepository) {
        this.direccionRepository = direccionRepository;
        this.direccionMapper = direccionMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public DireccionResponseDTO crearDireccion(Long idUsuario, DireccionRequestDTO direccionRequestDTO) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UserNotFoundException(idUsuario));

        Direccion direccion = direccionMapper.toEntity(direccionRequestDTO, usuario);

        Direccion direccionGuardada = direccionRepository.save(direccion);

        return direccionMapper.toResponse(direccionGuardada);
    }
}
