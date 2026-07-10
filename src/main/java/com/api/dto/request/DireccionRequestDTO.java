package com.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DireccionRequestDTO(
        @NotBlank(message = "No puede ir vacio el titulo")
        String titulo,

        @NotBlank(message = "No puede ir vacio la calle")
        String calle,

        @NotBlank(message = "No puede ir vacio la ciudad")
        String ciudad,

        @NotBlank(message = "No puede ir vacio la provincia")
        String provincia,

        @NotBlank(message = "No puede ir vacio el codigo postal")
        @Size(min = 5, max = 5)
        String codigoPostal,

        @NotBlank(message = "No puede ir vacio el pais")
        String pais
) {}
