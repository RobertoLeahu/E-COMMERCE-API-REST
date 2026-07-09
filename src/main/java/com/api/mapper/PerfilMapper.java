package com.api.mapper;

import com.api.domain.models.Perfil;
import com.api.domain.models.Usuario;
import com.api.dto.request.PerfilRequestDTO;
import com.api.dto.response.PerfilResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class PerfilMapper {

    public Perfil toEntity(PerfilRequestDTO perfilRequestDTO, Usuario usuario){

        if (perfilRequestDTO == null) {
            return null;
        }

        Perfil perfil = new Perfil();
        perfil.setNombre(perfilRequestDTO.nombre());
        perfil.setApellido(perfilRequestDTO.apellido());
        perfil.setTelefono(perfilRequestDTO.telefono());
        perfil.setUsuario(usuario);

        return perfil;
    }

    public PerfilResponseDTO toResponse(Perfil perfil){

        if (perfil == null) {
           return null;
        }

        return new PerfilResponseDTO(
                perfil.getNombre(),
                perfil.getApellido(),
                perfil.getTelefono(),
                perfil.getUsuario() != null ? perfil.getUsuario().getId() : null
        );
    }
}
