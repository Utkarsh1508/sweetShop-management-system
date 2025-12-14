package com.sweetshop.backend.service;

import com.sweetshop.backend.entity.Role;
import com.sweetshop.backend.entity.User;
import com.sweetshop.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user) {
        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }
        return userRepository.save(user);
    }
}
