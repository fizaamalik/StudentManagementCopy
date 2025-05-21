package com.api.auth;

import org.junit.jupiter.api.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {
    @Mock private AuthenticationService service;
    @InjectMocks private AuthenticationController underTest;
@Test
    public void register_happy_path() {
// Arrange;
        MockitoAnnotations.openMocks(this);
        RegisterRequest request = new RegisterRequest();
        AuthenticationResponse expectedResponse = new AuthenticationResponse();
        ResponseEntity<AuthenticationResponse> expectedEntity = new ResponseEntity<>(expectedResponse, HttpStatus.OK);

        when(authenticationService.register(request)).thenReturn(expectedResponse);

// Act;
        ResponseEntity<AuthenticationResponse> responseEntity = authenticationController.register(request);

// Assert;
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(expectedResponse);
    }
}