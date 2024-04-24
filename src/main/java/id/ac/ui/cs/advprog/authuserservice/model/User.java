package id.ac.ui.cs.advprog.authuserservice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class User {
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

    protected User(UserBuilder<?> builder) {
        this.userId = builder.userId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.role = builder.role;
        this.createdAt = builder.createdAt;
        this.active = builder.active;
        this.bio = builder.bio;
        this.profilePhoto = builder.profilePhoto;
    }
}
