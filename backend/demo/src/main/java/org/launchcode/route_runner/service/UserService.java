package org.launchcode.route_runner.service;

import org.launchcode.route_runner.data.UserRepository;
import org.launchcode.route_runner.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }


    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public boolean existsById(Long id) {
        return false;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long userId) {
        return null;
    }
}
