package id.ac.ui.cs.advprog.authuserservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;

import id.ac.ui.cs.advprog.authuserservice.model.UserEntity;
import id.ac.ui.cs.advprog.authuserservice.repository.UserRepository;

public class UserServiceImpl implements UserService, UserDetailsService{
    
@Autowired
    private UserRepository userRepository;

    @Override
    public UserEntity createUser(UserEntity user) {
        userRepository.createUser(user);
        return user;
    }

    @Override
    public List<UserEntity> findAllUser() {
        Iterator<UserEntity> userIterator = userRepository.findAllUser();
        List<UserEntity> allUser = new ArrayList<>();
        userIterator.forEachRemaining(allUser::add);
        return allUser;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void updateUser(String userId, UserEntity user) {
        userRepository.update(userId, user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername called");
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        System.out.println("User found");
        return new User(user.getUsername(), user.getPassword(), mapToAuth(user.getRole()));
    }

    private Collection<GrantedAuthority> mapToAuth(String type) {
        ArrayList<String> roles = new ArrayList<>();
        roles.add(type);
        return roles.stream().map(role -> new SimpleGrantedAuthority(type)).collect(Collectors.toList());
    }

    public void setUserRepository(UserRepository userRepository2) {
        this.userRepository = userRepository2;
    }
}
