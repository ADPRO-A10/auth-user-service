package id.ac.ui.cs.advprog.authuserservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import id.ac.ui.cs.advprog.authuserservice.model.UserEntity;
import id.ac.ui.cs.advprog.authuserservice.repository.UserRepository;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser() {
        UserEntity user = mock(UserEntity.class);
        when(userRepository.createUser(user)).thenReturn(user);
        UserEntity createdUser = userService.createUser(user);
        assertEquals(user, createdUser);
    }

    @Test
    public void testFindAllUser() {
        List<UserEntity> users = new ArrayList<>();
        when(userRepository.findAllUser()).thenReturn(users.iterator());
        List<UserEntity> allUser = userService.findAllUser();
        assertEquals(users, allUser);
    }

    @Test
    public void testFindByUsername() {
        UserEntity user = mock(UserEntity.class);
        when(user.getUsername()).thenReturn("testuser");
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        UserEntity foundUser = userService.findByUsername("testuser");
        assertEquals(user, foundUser);
    }

    @Test
    public void testUpdateUser() {
        UserEntity user = mock(UserEntity.class);
        doNothing().when(userRepository).update("1", user);
        userService.updateUser("1", user);
        verify(userRepository, times(1)).update("1", user);
    }

    @Test
    public void testLoadUserByUsername() {
        UserEntity user = mock(UserEntity.class);
        when(user.getUsername()).thenReturn("testuser");
        when(user.getPassword()).thenReturn("password");
        when(user.getRole()).thenReturn("USER");
        when(userRepository.findByUsername("testuser")).thenReturn(user);
        UserDetails userDetails = userService.loadUserByUsername("testuser");
        assertEquals(user.getUsername(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
    }

    @Test
    public void testLoadUserByUsernameNotFound() {
        when(userRepository.findByUsername("testuser")).thenReturn(null);
        assertThrows(UsernameNotFoundException.class, () -> {
            userService.loadUserByUsername("testuser");
        });
    }
}