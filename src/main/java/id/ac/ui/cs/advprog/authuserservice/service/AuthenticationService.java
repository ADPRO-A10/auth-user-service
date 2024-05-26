package id.ac.ui.cs.advprog.authuserservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationRequest;
import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationResponse;
import id.ac.ui.cs.advprog.authuserservice.dto.RegisterRequest;
import id.ac.ui.cs.advprog.authuserservice.exceptions.UserAlreadyExistException;
import id.ac.ui.cs.advprog.authuserservice.model.auth.User;
import id.ac.ui.cs.advprog.authuserservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var checkUser = userRepository.findByEmail(request.getEmail()).orElse(null);

        if(checkUser != null) {
            throw new UserAlreadyExistException();
        }

        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .active(true)
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Async
    public CompletableFuture<AuthenticationResponse> registerAsync(RegisterRequest request) {
        return CompletableFuture.supplyAsync(() -> register(request));
    }

}

