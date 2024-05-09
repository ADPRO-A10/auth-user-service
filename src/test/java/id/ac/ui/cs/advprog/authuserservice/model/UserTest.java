package id.ac.ui.cs.advprog.authuserservice.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserTest {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testCreateUser() {
        UserEntity user = new UserEntity.Builder()
                    .setActive(true)
                    .setBalance(1000)
                    .setBio("Lorem Ipsum")
                    .setCreatedAt(LocalDate.of(2024, 3, 1))
                    .setEmail("mymail@gmail.com")
                    .setFirstName("Max")
                    .setLastName("Verstappen")
                    .setPassword("password")
                    .setProfilePhoto("photo.jpg")
                    .setRole("USER")
                    .setUserId(1L)
                    .setUsername("mv1")
                    .build();

        assertEquals(true, user.isActive());
        assertEquals(1000, user.getBalance());
        assertEquals("Lorem Ipsum", user.getBio());
        assertEquals(LocalDate.of(2024, 3, 1), user.getCreatedAt());
        assertEquals("mymail@gmail.com", user.getEmail());
        assertEquals("Max", user.getFirstName());
        assertEquals("Verstappen", user.getLastName());
        assertEquals("password", user.getPassword());
        assertEquals("photo.jpg", user.getProfilePhoto());
        assertEquals("USER", user.getRole());
        assertEquals(1L, user.getUserId());
        assertEquals("mv1", user.getUsername());
    }
}