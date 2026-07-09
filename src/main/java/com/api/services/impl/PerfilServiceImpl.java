package com.api.services.impl;

import com.api.domain.models.Perfil;
import com.api.domain.models.Usuario;
import com.api.dto.request.PerfilRequestDTO;
import com.api.dto.response.PerfilResponseDTO;
import com.api.exceptions.ProfileAlreadyAssignedException;
import com.api.exceptions.ProfileNotFoundException;
import com.api.exceptions.UserNotFoundException;
import com.api.mapper.PerfilMapper;
import com.api.respositories.PerfilRepository;
import com.api.respositories.UsuarioRepository;
import com.api.services.PerfilService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PerfilServiceImpl implements PerfilService {

    final private PerfilRepository perfilRepository;
    final private UsuarioRepository usuarioRepository;
    final private PerfilMapper perfilMapper;

    public PerfilServiceImpl(PerfilRepository perfilRepository, UsuarioRepository usuarioRepository, PerfilMapper perfilMapper) {
        this.perfilRepository = perfilRepository;
        this.usuarioRepository = usuarioRepository;
        this.perfilMapper = perfilMapper;
    }

    @Override
    public PerfilResponseDTO crearPerfil(PerfilRequestDTO perfilRequestDTO) {

        Usuario usuario = usuarioRepository.findById(perfilRequestDTO.idUsuario())
                .orElseThrow(() -> new UserNotFoundException(perfilRequestDTO.idUsuario()));

        if (perfilRepository.existsById(usuario.getId())) {
            throw new ProfileAlreadyAssignedException(usuario.getId());
        }

        Perfil perfil = perfilMapper.toEntity(perfilRequestDTO, usuario);
        Perfil perfilNuevo = perfilRepository.save(perfil);

        return perfilMapper.toResponse(perfilNuevo);
    }

    @Override
    public List<PerfilResponseDTO> obtenerPerfiles() {
        List<Perfil> perfiles = perfilRepository.findAll();
        return perfiles.stream()
                .map(perfilMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PerfilResponseDTO obtenerPerfilPorIdDeUsuario(Long idUsuario) {

        Perfil perfil = perfilRepository.findById(idUsuario)
                .orElseThrow(() -> new ProfileNotFoundException(idUsuario));

        return perfilMapper.toResponse(perfil);
    }

    @Override
    public PerfilResponseDTO actualizarPerfil(Long idUsuario, PerfilRequestDTO perfilRequestDTO) {

        Perfil perfilExistente = perfilRepository.findById(idUsuario)
                .orElseThrow(() -> new ProfileNotFoundException(idUsuario));

        // Validaciones de campos
        if (perfilRequestDTO.nombre() != null && !perfilRequestDTO.nombre().equals(perfilExistente.getNombre())) {
            perfilExistente.setNombre(perfilRequestDTO.nombre());
        }
        if (perfilRequestDTO.apellido() != null && !perfilRequestDTO.apellido().equals(perfilExistente.getApellido())) {
            perfilExistente.setApellido(perfilRequestDTO.apellido());
        }
        if (perfilRequestDTO.telefono() != null && !perfilRequestDTO.telefono().equals(perfilExistente.getTelefono())) {
            perfilExistente.setTelefono(perfilRequestDTO.telefono());
        }

        // Persistir
        Perfil perfilActualizado = perfilRepository.save(perfilExistente);

        return perfilMapper.toResponse(perfilActualizado);
    }
}
