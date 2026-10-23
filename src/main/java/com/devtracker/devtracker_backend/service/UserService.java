package com.devtracker.devtracker_backend.service;

import com.devtracker.devtracker_backend.exception.EmailAlreadyExistException;
import com.devtracker.devtracker_backend.exception.UserNotFoundException;
import com.devtracker.devtracker_backend.dto.UserRequest;
import com.devtracker.devtracker_backend.entity.User;
import com.devtracker.devtracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));
    }

    public User createUser(UserRequest request) {
         if (userRepository.findByEmail(request.getEmail()).isPresent()){
             throw new EmailAlreadyExistException("Email is already registered");
         }
        User user = new User();

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRol(request.getRol());

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserRequest request) {

        User user = getUserById(id);

        user.setName(request.getName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRol(request.getRol());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {

        User user = getUserById(id);

        userRepository.delete(user);
    }
}