package com.api.controllers;

import com.api.dto.request.DireccionRequestDTO;
import com.api.dto.response.DireccionResponseDTO;
import com.api.services.impl.DireccionServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {

    final private DireccionServiceImpl direccionService;

    public DireccionController(DireccionServiceImpl direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping("/{idUsuario}")
    public ResponseEntity<DireccionResponseDTO> crearDireccion(@PathVariable Long idUsuario, @RequestBody DireccionRequestDTO direccionRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(direccionService.crearDireccion(idUsuario, direccionRequestDTO));
    }
}
