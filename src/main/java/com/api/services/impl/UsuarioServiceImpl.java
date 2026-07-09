package com.api.services.impl;

import com.api.domain.enums.Rol;
import com.api.domain.models.Usuario;
import com.api.dto.request.UsuarioRequestDTO;
import com.api.dto.response.UsuarioResponseDTO;
import com.api.exceptions.EmailAlreadyExistsException;
import com.api.exceptions.ProductNotFoundException;
import com.api.exceptions.UserNotFoundException;
import com.api.mapper.UsuarioMapper;
import com.api.respositories.UsuarioRepository;
import com.api.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    final private UsuarioRepository usuarioRepository;
    final private UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl (UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper){
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioResponseDTO crearUsuarioCliente(UsuarioRequestDTO usuarioRequestDTO){
        if (usuarioRepository.existsByEmail(usuarioRequestDTO.email())) {
            throw new EmailAlreadyExistsException(usuarioRequestDTO.email());
        }

        Usuario nuevoUsuario = usuarioMapper.toEntity(usuarioRequestDTO);
        nuevoUsuario.setRol(Rol.CLIENTE);

        Usuario usuarioGuardado = usuarioRepository.save(nuevoUsuario);

        return usuarioMapper.toResponse(usuarioGuardado);
    }

    @Override
    public List<UsuarioResponseDTO> mostrarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioResponseDTO mostrarUsuariosPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return usuarioMapper.toResponse(usuario);
    }

    @Override
    public String borrarUsuario(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        usuarioRepository.deleteById(id);

        return "Usuario con id " + id + " borrado correctamente";
    }
}
