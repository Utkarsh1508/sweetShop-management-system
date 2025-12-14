package com.sweetshop.backend.service;

import com.sweetshop.backend.entity.Role;
import com.sweetshop.backend.entity.User;
import com.sweetshop.backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthService authService;

    @Test
    void shouldLoginWithValidCredentials() {
        User user = new User();
        user.setUsername("utkarsh");
        user.setPassword("password");
        user.setRole(Role.USER);

        when(userRepository.findByUsername("utkarsh"))
                .thenReturn(Optional.of(user));

        User loggedInUser = authService.login("utkarsh", "password");

        assertThat(loggedInUser).isNotNull();
        assertThat(loggedInUser.getUsername()).isEqualTo("utkarsh");
    }
}

