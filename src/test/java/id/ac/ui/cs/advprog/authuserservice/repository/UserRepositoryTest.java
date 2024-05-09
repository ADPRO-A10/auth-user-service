package id.ac.ui.cs.advprog.authuserservice.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import id.ac.ui.cs.advprog.authuserservice.model.UserEntity;

public class UserRepositoryTest {

    @InjectMocks
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void testCreateUser() {
        UserEntity user = new UserEntity.Builder()
                .setActive(true)
                .setBalance(100)
                .setBio("Test Bio")
                .setCreatedAt(LocalDate.now())
                .setEmail("test@gmail.com")
                .setFirstName("Test")
                .setLastName("User")
                .setPassword(passwordEncoder.encode("password"))
                .setProfilePhoto("photo.jpg")
                .setRole("USER")
                .setUserId(1L)
                .setUsername("testuser")
                .build();

        UserEntity createdUser = userRepository.createUser(user);
        assertEquals(user, createdUser);
    }

    @Test
    public void testFindAllUser() {
        Iterator<UserEntity> users = userRepository.findAllUser();
        assertNotNull(users);
    }

    @Test
    public void testFindByUsername() {
        UserEntity user = userRepository.findByUsername("cl16");
        assertNotNull(user);
        assertEquals("cl16", user.getUsername());
    }

    @Test
    public void testUpdate() {
        UserEntity updatedUser = new UserEntity.Builder()
                .setActive(true)
                .setBalance(200)
                .setBio("Updated Bio")
                .setCreatedAt(LocalDate.now())
                .setEmail("updated@gmail.com")
                .setFirstName("Updated")
                .setLastName("User")
                .setPassword(passwordEncoder.encode("updatedpassword"))
                .setProfilePhoto("updatedphoto.jpg")
                .setRole("USER")
                .setUserId(1L)
                .setUsername("updateduser")
                .build();

        UserEntity user = userRepository.update("cl16", updatedUser);
        assertNotNull(user);
        assertEquals(updatedUser, user);
    }
}