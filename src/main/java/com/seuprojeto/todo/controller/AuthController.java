
package com.seuprojeto.todo.controller;

import com.seuprojeto.todo.dto.*;
import com.seuprojeto.todo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequestDTO dto) {

        service.register(dto);

        return ResponseEntity.ok("Usuário criado com sucesso");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(
            @RequestBody LoginRequestDTO dto) {

        return ResponseEntity.ok(service.login(dto));
    }
}
