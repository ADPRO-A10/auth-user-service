package id.ac.ui.cs.advprog.authuserservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.ui.cs.advprog.authuserservice.model.UserEntity;
import id.ac.ui.cs.advprog.authuserservice.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.hasSize;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    private MockMvc mockMvc;
    private UserEntity user1;
    private UserEntity user2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user1 = new UserEntity.Builder()
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

        user2 = new UserEntity.Builder()
                .setActive(true)
                .setBalance(55)
                .setBio("Lorem Ipsum55")
                .setCreatedAt(LocalDate.of(2024, 3, 1))
                .setEmail("mymail55@gmail.com")
                .setFirstName("Carlos")
                .setLastName("Sainz")
                .setPassword("password55")
                .setProfilePhoto("photo55.jpg")
                .setRole("USER")
                .setUserId(16L)
                .setUsername("cs55")
                .build();
    }

    @Test
    public void testCreateUser() throws Exception {
        when(userService.createUser(any(UserEntity.class))).thenReturn(user1);

        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testFindAllUsers() throws Exception {
        List<UserEntity> users = Arrays.asList(user1, user2);
        when(userService.findAllUser()).thenReturn(users);

        mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void testFindUserByUsername() throws Exception {
        when(userService.findByUsername(anyString())).thenReturn(user1);

        mockMvc.perform(get("/users/testuser")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateUser() throws Exception {
        doNothing().when(userService).updateUser(anyString(), any(UserEntity.class));

        mockMvc.perform(put("/users/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user1)))
                .andExpect(status().isOk());
    }
}