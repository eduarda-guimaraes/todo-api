
package com.seuprojeto.todo.service;

import com.seuprojeto.todo.dto.*;
import com.seuprojeto.todo.entity.User;
import com.seuprojeto.todo.repository.UserRepository;
import com.seuprojeto.todo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequestDTO dto) {

        User user = User.builder()
                .username(dto.getUsername())
                .password(encoder.encode(dto.getPassword()))
                .build();

        repository.save(user);
    }

    public AuthResponseDTO login(LoginRequestDTO dto) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        String token = jwtService.generateToken(dto.getUsername());

        return new AuthResponseDTO(token);
    }
}
