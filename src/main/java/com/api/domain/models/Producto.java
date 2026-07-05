package com.api.domain.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String titulo;

    @Column(nullable = false, length = 150)
    private String calle;

    @Column(nullable = false, length = 100)
    private String ciudad;

    @Column(nullable = false, length = 100)
    private String estado;

    @Column(name = "codigo_postal", nullable = false, length = 15)
    private String codigoPostal;

    @Column(nullable = false, length = 100)
    private String pais;

    // Relación ManyToOne con la Categoría
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
