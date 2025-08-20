package com.luq.secure_password.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luq.secure_password.dto.PasswordDTO;
import com.luq.secure_password.exceptions.AggregationException;
import com.luq.secure_password.services.PasswordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(PasswordController.class)
public class PasswordControllerTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    PasswordService passwordService;

    @Test
    public void StrongPasswordReturnCorrectlyTest() throws Exception{
        PasswordDTO passwordDTO = new PasswordDTO("Str0ng-P4$$w0rd");
        when(passwordService.validatePassword(passwordDTO)).thenReturn(passwordDTO);
        String customerJson = objectMapper.writeValueAsString(passwordDTO);

        mockMvc.perform(
            post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson)
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

    }

    @Test
    public void WeakPasswordReturnErrorTest() throws Exception{
        PasswordDTO passwordDTO = new PasswordDTO("imweak");
        when(passwordService.validatePassword(passwordDTO)).thenThrow(AggregationException.class);
        String customerJson = objectMapper.writeValueAsString(passwordDTO);

        mockMvc.perform(
            post("/validate-password")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson)
        ).andExpect(status().isBadRequest());
    }
}
