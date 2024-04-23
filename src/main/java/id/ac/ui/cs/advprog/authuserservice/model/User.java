package id.ac.ui.cs.advprog.authuserservice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String role;
    private LocalDate createdAt;
    private boolean active;
    private String bio;
    private String profilePhoto;

}
