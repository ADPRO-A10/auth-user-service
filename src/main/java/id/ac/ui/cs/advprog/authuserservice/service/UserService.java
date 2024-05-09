package id.ac.ui.cs.advprog.authuserservice.service;

import java.util.List;

import id.ac.ui.cs.advprog.authuserservice.model.UserEntity;

public interface UserService {
    public UserEntity createUser(UserEntity user);
    public List<UserEntity> findAllUser();
    UserEntity findByUsername(String username);
    public void updateUser(String userId, UserEntity user);
}
