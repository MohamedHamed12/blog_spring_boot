package com.example.blog.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest {

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testRegister() {
        // Prepare a RegisterRequest
        RegisterRequest request = new RegisterRequest("John", "Doe", "test@example.com", "password");

        // Mock the service response
        AuthenticationResponse mockResponse = new AuthenticationResponse("token");
        when(authenticationService.register(any(RegisterRequest.class))).thenReturn(mockResponse);

        // Call the register endpoint
        ResponseEntity<AuthenticationResponse> responseEntity = authenticationController.register(request);

        // Verify the response
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(mockResponse);
    }

    @Test
    public void testAuthenticate() {
        // Prepare an AuthenticationRequest
        AuthenticationRequest request = new AuthenticationRequest("test@example.com", "password");

        // Mock the service response
        AuthenticationResponse mockResponse = new AuthenticationResponse("token");
        when(authenticationService.authenticate(any(AuthenticationRequest.class))).thenReturn(mockResponse);

        // Call the authenticate endpoint
        ResponseEntity<AuthenticationResponse> responseEntity = authenticationController.authenticate(request);

        // Verify the response
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(mockResponse);
    }
}
