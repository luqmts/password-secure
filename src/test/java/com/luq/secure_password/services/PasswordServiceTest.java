package com.luq.secure_password.services;

import com.luq.secure_password.domain.Password;
import com.luq.secure_password.dto.PasswordDTO;
import com.luq.secure_password.exceptions.AggregationException;
import com.luq.secure_password.mapper.PasswordMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PasswordServiceTest {
    @Mock
    PasswordMapper passwordMapper;
    @InjectMocks
    PasswordService passwordService;

    @Test
    @DisplayName("Validate if a strong password is being returned dto and does not throw any exception")
    public void testValidateStrongPassword(){
        PasswordDTO passwordDTO = new PasswordDTO("$tr0ng-P4ssw0rd");
        Password password = new Password("$tr0ng-P4ssw0rd");
        when(passwordMapper.toEntity(passwordDTO)).thenReturn(password);

        PasswordDTO result = passwordService.validatePassword(passwordDTO);
        assertEquals(passwordDTO, result);
        assertDoesNotThrow(() -> passwordService.validatePassword(passwordDTO));

    }

    @Test
    @DisplayName("Weak password must throw a Aggregation Exception containing all errors that occurred")
    public void testValidateWeakPassword(){
        PasswordDTO passwordDTO = new PasswordDTO("imweak");
        Password password = new Password("imweak");
        when(passwordMapper.toEntity(passwordDTO)).thenReturn(password);

        assertThrows(AggregationException.class, () -> passwordService.validatePassword(passwordDTO));
    }
}
