package id.ac.ui.cs.advprog.authuserservice.service;

import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationRequest;
import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationResponse;
import id.ac.ui.cs.advprog.authuserservice.model.auth.User;
import id.ac.ui.cs.advprog.authuserservice.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JwtService jwtService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationService authenticationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        User user = User.builder()
                .firstname("John")
                .lastname("Doe")
                .email("user@example.com")
                .password(passwordEncoder.encode("password"))
                .role("USER")
                .active(true)
                .build();

        when(userRepository.findByEmail("user@example.com")).thenReturn(Optional.of(user));
        when(jwtService.generateToken(any(User.class))).thenReturn("fake-jwt-token");
    }

    @Test
    public void testAuthenticate() {
        AuthenticationRequest request = new AuthenticationRequest();
        request.setEmail("user@example.com");
        request.setPassword("password");

        AuthenticationResponse response = authenticationService.authenticate(request);

        assertEquals("fake-jwt-token", response.getToken());
    }
}
