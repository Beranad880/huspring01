package com.example.humbleshowcase;

import com.example.humbleshowcase.models.Client;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureTestWebSecurity;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.humbleshowcase.controllers.ClientController;
import com.example.humbleshowcase.services.ClientService;

@WebMvcTest(ClientController.class)
@AutoConfigureTestWebSecurity
public class ValidationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    public void testClientValidation_EmptyName() throws Exception {
        Client client = new Client();
        client.setName(""); // Prázdné jméno
        client.setEmail("test@example.com");
        client.setPhone("123456789");
        client.setPersonalNumber("123456/7890");
        client.setAddress("Test adresa 123");

        mockMvc.perform(post("/api/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(client)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Validační chyby"))
                .andExpect(jsonPath("$.errors.name").exists());
    }

    @Test
    @WithMockUser
    public void testClientValidation_InvalidEmail() throws Exception {
        Client client = new Client();
        client.setName("Jan Novák");
        client.setEmail("invalid-email"); // Neplatný email
        client.setPhone("123456789");
        client.setPersonalNumber("123456/7890");
        client.setAddress("Test adresa 123");

        mockMvc.perform(post("/api/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(client)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Validační chyby"))
                .andExpect(jsonPath("$.errors.email").exists());
    }

    @Test
    @WithMockUser
    public void testClientValidation_InvalidPersonalNumber() throws Exception {
        Client client = new Client();
        client.setName("Jan Novák");
        client.setEmail("jan@example.com");
        client.setPhone("123456789");
        client.setPersonalNumber("123456789"); // Neplatný formát rodného čísla
        client.setAddress("Test adresa 123");

        mockMvc.perform(post("/api/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(client)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Validační chyby"))
                .andExpect(jsonPath("$.errors.personalNumber").exists());
    }
}
