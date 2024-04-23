package id.ac.ui.cs.advprog.authuserservice.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import id.ac.ui.cs.repository.UserRepository;
import id.ac.ui.cs.service.UserService;
import id.ac.ui.cs.service.UserServiceImpl;
import id.ac.ui.cs.model.UserRepository;

@DataJpaTest
public class UserTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks // auto inject userRepository
    private UserServiceImpl userService;

    @Test
    public void testCreateUser() {
        // Arrange
        User mockUser = new User();
        mockUser.setFirstName("Vax");
        mockUser.setLastName("Merstappen");
        mockUser.setEmail("vm33@example.com");
        mockUser.setUsername("vm33");
        mockUser.setPassword("12345678");

        // Password encoding
        when(passwordEncoder.encode(mockUser.getPassword())).thenReturn("12345678");

        when(userRepository.save(any(User.class))).thenReturn(mockUser);

        User createdUser = userService.create(mockUser.getFirstName(),
                mockUser.getLastName(),
                mockUser.getEmail(),
                mockUser.getUsername(),
                mockUser.getPassword());

        // Assert
        assertEquals(mockUser.getUsername(), createdUser.getUsername());
        assertEquals("12345678", createdUser.getPassword());
    }
}