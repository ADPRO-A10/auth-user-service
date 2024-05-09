package id.ac.ui.cs.advprog.authuserservice.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.authuserservice.model.UserEntity;

@Component
@Repository
public class UserRepository {
    private final List<UserEntity> userList = new ArrayList<>();
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserRepository() {
        UserEntity user1 = new UserEntity.Builder()
                    .setActive(true)
                    .setBalance(16)
                    .setBio("Lorem Ipsum16")
                    .setCreatedAt(LocalDate.of(2024, 3, 1))
                    .setEmail("mymail16@gmail.com")
                    .setFirstName("Charles")
                    .setLastName("Leclerc")
                    .setPassword(passwordEncoder.encode("password16"))
                    .setProfilePhoto("photo16.jpg")
                    .setRole("USER")
                    .setUserId(16L)
                    .setUsername("cl16")
                    .build();

        UserEntity user2 = new UserEntity.Builder()
                    .setActive(true)
                    .setBalance(55)
                    .setBio("Lorem Ipsum55")
                    .setCreatedAt(LocalDate.of(2024, 3, 1))
                    .setEmail("mymail55@gmail.com")
                    .setFirstName("Carlos")
                    .setLastName("Sainz")
                    .setPassword(passwordEncoder.encode("password55"))
                    .setProfilePhoto("photo55.jpg")
                    .setRole("USER")
                    .setUserId(16L)
                    .setUsername("cs55")
                    .build();

        userList.add(user1);
        userList.add(user2);
    }

    public UserEntity createUser(UserEntity newUser) {
        userList.add(newUser);
        return newUser;
    }

    public Iterator<UserEntity> findAllUser() {
        return userList.iterator();
    }

    public UserEntity findByUsername(String username) {
        for (UserEntity User : userList) {
            if (User.getUsername().equals(username)) {
                return User;
            }
        }
        return null;
    }

    public UserEntity update(String username, UserEntity updatedUser) {
        for (UserEntity User : userList) {
            if (User.getUsername().equals(username)) {
                User.setActive(true);
                User.setBalance(updatedUser.getBalance());
                User.setBio(updatedUser.getBio());
                User.setCreatedAt(updatedUser.getCreatedAt());
                User.setEmail(updatedUser.getEmail());
                User.setFirstName(updatedUser.getFirstName());
                User.setLastName(updatedUser.getLastName());
                User.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
                User.setProfilePhoto(updatedUser.getProfilePhoto());
                User.setRole(updatedUser.getRole());
                User.setUserId(updatedUser.getUserId());
                User.setUsername(updatedUser.getUsername());
                return User;
            }
        }
        return null;
    }
    
}
