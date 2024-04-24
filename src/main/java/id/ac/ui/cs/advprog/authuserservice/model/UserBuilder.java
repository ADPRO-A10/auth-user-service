package id.ac.ui.cs.advprog.authuserservice.model;

import java.time.LocalDate;

public abstract class UserBuilder <T extends UserBuilder<T>> {
    Long userId;
    String firstName;
    String lastName;
    String username;
    String password;
    String email;
    String role;
    LocalDate createdAt;
    boolean active;
    String bio;
    String profilePhoto;

    public T userId(Long userId) {
        this.userId = userId;
        return self();
    }

    public T firstName(String firstName) {
        this.firstName = firstName;
        return self();
    }

    public T lastName(String lastName) {
        this.firstName = firstName;
        return self();
    }

    public T username(String username) {
        this.username = username;
        return self();
    }

    public T password(String password) {
        this.password = password;
        return self();
    }

    public T email(String email) {
        this.email = email;
        return self();
    }

    public T role(String role) {
        this.role = role;
        return self();
    }

    public T createdAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return self();
    }

    public T active(boolean active) {
        this.active = active;
        return self();
    }

    public T bio(String bio) {
        this.bio = bio;
        return self();
    }

    public T profilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
        return self();
    }

    protected abstract T self();

    public abstract User build();
}
