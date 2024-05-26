//package id.ac.ui.cs.advprog.authuserservice.controller;
//
//import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationRequest;
//import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationResponse;
//import id.ac.ui.cs.advprog.authuserservice.service.AuthenticationService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@WebMvcTest(AuthenticationController.class)
//public class AuthenticationControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AuthenticationService authenticationService;
//
//    @Test
//    public void testAuthenticate() throws Exception {
//        AuthenticationRequest request = new AuthenticationRequest();
//        request.setEmail("user@example.com");
//        request.setPassword("password");
//
//        AuthenticationResponse response = new AuthenticationResponse("fake-jwt-token");
//
//        when(authenticationService.authenticate(any(AuthenticationRequest.class))).thenReturn(response);
//
//        mockMvc.perform(post("/api/v1/auth/authenticate")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"email\":\"user@example.com\", \"password\":\"password\"}"))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{\"token\":\"fake-jwt-token\"}"))
//                .andDo(print());
//    }
//}