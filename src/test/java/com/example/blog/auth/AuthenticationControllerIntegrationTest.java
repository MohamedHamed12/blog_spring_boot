package com.example.blog.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegister() throws Exception {
        String requestJson = "{ \"firstname\":\"John\",\"lastname\":\"Doe\",\"email\":\"test@example.com\",\"password\":\"password\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    // @Test
    // public void testAuthenticate() throws Exception {
    //     String requestJson = "{\"email\":\"test@example.com\",\"password\":\"password\"}";

    //     mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/auth/authenticate")
    //             .contentType(MediaType.APPLICATION_JSON)
    //             .content(requestJson))
    //             .andExpect(MockMvcResultMatchers.status().isOk());
    // }
}
