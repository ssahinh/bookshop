package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dtos.auth.TokenResponseDto;
import com.bookshop.bookshop.requests.auth.LoginRequest;
import com.bookshop.bookshop.services.AuthService;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> login(@RequestBody LoginRequest loginRequest) throws Exception {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @GetMapping("/me")
    public String getMyself() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}
