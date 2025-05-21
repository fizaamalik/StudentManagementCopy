package com.api.auth;

import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {
    @Mock private UserRepository repository;
    @Mock private JwtService jwtService;
    @InjectMocks private AuthenticationService underTest;
@Test
    void register_happy_path() {
// Arrange;
        RegisterRequest request = new RegisterRequest("user@example.com", "password123");
        User user = new User("user@example.com", "password123");
        AuthenticationResponse expectedResponse = new AuthenticationResponse("Success", user);

        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

// Act;
        AuthenticationResponse actualResponse = authenticationService.register(request);

// Assert;
        assertThat(actualResponse).isNotNull();
        assertThat(actualResponse.getMessage()).isEqualTo(expectedResponse.getMessage());
        assertThat(actualResponse.getUser()).isEqualTo(expectedResponse.getUser());
    }
@Test
    void authenticate_happy_path() {
// Arrange;
        AuthenticationService authenticationService = Mockito.mock(AuthenticationService.class);
        AuthenticationRequest request = new AuthenticationRequest("username", "password");
        AuthenticationResponse expectedResponse = new AuthenticationResponse(true);

        Mockito.when(authenticationService.authenticate(request)).thenReturn(expectedResponse);

// Act;
        AuthenticationResponse actualResponse = authenticationService.authenticate(request);

// Assert;
        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}