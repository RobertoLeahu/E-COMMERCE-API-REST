package com.api.mapper;

import com.api.domain.models.Usuario;
import com.api.dto.request.UsuarioRequestDTO;
import com.api.dto.response.UsuarioResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponseDTO toResponse(Usuario usuario){
        if (usuario == null) {
            return null;
        }

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getRol()
        );
    }

    public Usuario toEntity(UsuarioRequestDTO usuarioRequestDTO){
        if (usuarioRequestDTO == null) {
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setPassword(usuarioRequestDTO.password());

        return usuario;
    }
}
