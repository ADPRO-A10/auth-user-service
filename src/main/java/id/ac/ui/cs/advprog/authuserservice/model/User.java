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
    private double balance;

    private User(Builder builder) {
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
        this.balance = builder.balance;
    }

    public static class Builder {
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
        private double balance;

        public Builder setUserId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setRole(String role) {
            this.role = role;
            return this;
        }

        public Builder setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setActive(boolean active) {
            this.active = active;
            return this;
        }

        public Builder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public Builder setProfilePhoto(String profilePhoto) {
            this.profilePhoto = profilePhoto;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}