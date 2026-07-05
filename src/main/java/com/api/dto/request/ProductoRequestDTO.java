package com.api.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductoRequestDTO(
        @NotBlank(message = "El nombre no puede ir vacio")
        String nombre,

        @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
        String descripcion,

        @NotBlank(message = "El precio no puede ir vacio")
        @DecimalMin(value = "0.01", message = "El precio minimo debe ser 0.01")
        BigDecimal precio,

        @NotBlank(message = "El stock es obligatorio")
        @Min(value = 0, message = "La cantidad de stock no puede ser negativo")
        Integer stock,

        @Size(max = 500)
        String imagenUrl,

        @NotBlank(message = "El numero de identificación de la categoría del producto no puede ir vacia")
        String categoriaId
) {}