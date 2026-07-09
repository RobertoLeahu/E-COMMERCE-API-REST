package com.api.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DireccionRequestDTO(
        @NotNull(message = "No puede ir vacio el titulo")
        String titulo,

        @NotNull(message = "No puede ir vacio la calle")
        String calle,

        @NotNull(message = "No puede ir vacio la ciudad")
        String ciudad,

        @NotNull(message = "No puede ir vacio la provincia")
        String provincia,

        @NotNull(message = "No puede ir vacio el codigo postal")
        @Size(min = 5, max = 5)
        String codigoPostal,

        @NotNull(message = "No puede ir vacio el pais")
        String pais
) {}
