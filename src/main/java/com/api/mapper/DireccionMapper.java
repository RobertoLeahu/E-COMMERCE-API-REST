package com.api.mapper;

import com.api.domain.models.Direccion;
import com.api.domain.models.Usuario;
import com.api.dto.request.DireccionRequestDTO;
import com.api.dto.response.DireccionResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class DireccionMapper {

    public Direccion toEntity(DireccionRequestDTO direccionRequestDTO, Usuario usuario){

        if (direccionRequestDTO == null) {
            return null;
        }

        Direccion direccion = new Direccion();
        direccion.setTitulo(direccionRequestDTO.titulo());
        direccion.setCalle(direccionRequestDTO.calle());
        direccion.setCiudad(direccionRequestDTO.ciudad());
        direccion.setProvincia(direccionRequestDTO.provincia());
        direccion.setCodigoPostal(direccionRequestDTO.codigoPostal());
        direccion.setPais(direccionRequestDTO.pais());
        direccion.setUsuario(usuario);

        return direccion;
    }

    public DireccionResponseDTO toResponse(Direccion direccion){

        if (direccion == null) {
            return null;
        }

        return new DireccionResponseDTO(
                direccion.getTitulo(),
                direccion.getCalle(),
                direccion.getCiudad(),
                direccion.getProvincia(),
                direccion.getCodigoPostal(),
                direccion.getPais(),
                direccion.getUsuario().getId()
        );
    }
}
