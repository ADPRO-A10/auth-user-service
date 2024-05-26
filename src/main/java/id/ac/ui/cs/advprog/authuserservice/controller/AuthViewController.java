package id.ac.ui.cs.advprog.authuserservice.controller;

import id.ac.ui.cs.advprog.authuserservice.dto.AuthenticationRequest;
import id.ac.ui.cs.advprog.authuserservice.dto.RegisterRequest;
import id.ac.ui.cs.advprog.authuserservice.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthViewController {

    private final AuthenticationService authenticationService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequest request, Model model) {
        authenticationService.register(request);
        model.addAttribute("message", "Registration successful. Please login.");
        return "login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("authenticationRequest", new AuthenticationRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AuthenticationRequest request, Model model) {
        authenticationService.authenticate(request);
        model.addAttribute("message", "Login successful.");
        return "welcome";
    }
}
