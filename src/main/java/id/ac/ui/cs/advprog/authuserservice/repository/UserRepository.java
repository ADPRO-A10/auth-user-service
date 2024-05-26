package id.ac.ui.cs.advprog.authuserservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import id.ac.ui.cs.advprog.authuserservice.model.auth.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}

