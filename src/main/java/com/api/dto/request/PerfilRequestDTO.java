package com.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PerfilRequestDTO(
        @NotBlank(message = "EL nombre no puede ir vacio")
        String nombre,

        @NotBlank(message = "No puede ir vacio el apellido")
        String apellido,

        @NotBlank(message = "No puede ir vacio el numero de teléfono")
        @Size(max = 9)
        String telefono,

        @NotNull(message = "El id de usuario no puede ir vacio")
        Long idUsuario
) {}
