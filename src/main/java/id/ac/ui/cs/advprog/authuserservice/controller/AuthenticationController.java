package id.ac.ui.cs.advprog.authuserservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationRequest;
import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationResponse;
import id.ac.ui.cs.advprog.authuserservice.dto.RegisterRequest;
import id.ac.ui.cs.advprog.authuserservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public CompletableFuture<ResponseEntity<AuthenticationResponse>> register(@RequestBody RegisterRequest request) {
        return authenticationService.registerAsync(request)
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login (
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
