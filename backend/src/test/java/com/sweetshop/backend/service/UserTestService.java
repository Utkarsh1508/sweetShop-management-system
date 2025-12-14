package com.sweetshop.backend.service;

import com.sweetshop.backend.entity.User;
import com.sweetshop.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void shouldRegisterNewUser() {
        User user = new User();
        user.setUsername("utkarsh");
        user.setEmail("utkarsh@test.com");
        user.setPassword("password");

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.register(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getUsername()).isEqualTo("utkarsh");
    }
}
