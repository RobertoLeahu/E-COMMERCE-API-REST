package com.api.controllers;

import com.api.dto.request.UsuarioRequestDTO;
import com.api.dto.response.UsuarioResponseDTO;
import com.api.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController (UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> crearUsuarioCliente(@Valid @RequestBody UsuarioRequestDTO usuarioRequestDTO){
        UsuarioResponseDTO usuarioGuardado = usuarioService.crearUsuarioCliente(usuarioRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> mostrarUsuarios() {
        List<UsuarioResponseDTO> usuarios = usuarioService.mostrarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> mostrarUsuariosPorId(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.mostrarUsuariosPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable Long id) {
        String usuarioBorrado = usuarioService.borrarUsuario(id);
        return ResponseEntity.ok(usuarioBorrado);
    }
}
