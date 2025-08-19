package com.luq.secure_password.domain;

import com.luq.secure_password.exceptions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PasswordTest {
    @Test
    @DisplayName("Test if a password with more than expected length is not getting exception thrown")
    public void testValidateMinimalLengthOk() {
        Password pass = new Password("strong_password");
        assertDoesNotThrow(pass::validate_minimal_length);
    }

    @Test
    @DisplayName("Test if a password with less than expected length is getting exception thrown")
    public void testValidateMinimalLengthException(){
        Password pass = new Password("weakpas");
        assertThrows(MinimalLengthException.class, pass::validate_minimal_length);
    }

    @Test
    @DisplayName("Test if a password with a upper case is not getting exception thrown")
    public void testValidateUpperCaseOk() {
        Password pass = new Password("STRONGPASSWORD");
        assertDoesNotThrow(pass::validate_minimal_upper_case);
    }

    @Test
    @DisplayName("Test if a password without a upper case is getting exception thrown")
    public void testValidateUpperCaseException(){
        Password pass = new Password("weakpassword");
        assertThrows(MinimalUpperCaseException.class, pass::validate_minimal_upper_case);
    }

    @Test
    @DisplayName("Test if a password with a upper case is not getting exception thrown")
    public void testValidateLowerCaseOk() {
        Password pass = new Password("strongpassword");
        assertDoesNotThrow(pass::validate_minimal_lower_case);
    }

    @Test
    @DisplayName("Test if a password without a upper case is getting exception thrown")
    public void testValidateLowerCaseException(){
        Password pass = new Password("WEAKPASSWORD");
        assertThrows(MinimalLowerCaseException.class, pass::validate_minimal_lower_case);
    }

    @Test
    @DisplayName("Test if a password with digits is not getting exception thrown")
    public void testValidateMinimalDigitsOk() {
        Password pass = new Password("str0ngp4ssw0rd");
        assertDoesNotThrow(pass::validate_minimal_digits);
    }

    @Test
    @DisplayName("Test if a password without any digit is getting exception thrown")
    public void testValidateMinimalDigitsException(){
        Password pass = new Password("weakpassword");
        assertThrows(MinimalDigitsException.class, pass::validate_minimal_digits);
    }

    @Test
    @DisplayName("Test if a password with special characters is not getting exception thrown")
    public void testValidateMinimalSpecialCharactersOk() {
        Password pass = new Password("$trongpa$$word");
        assertDoesNotThrow(pass::validate_minimal_special_chars);
    }

    @Test
    @DisplayName("Test if a password without any digit is getting exception thrown")
    public void testValidateMinimalSpecialCharactersException(){
        Password pass = new Password("weakpassword");
        assertThrows(MinimalSpecialCharactersException.class, pass::validate_minimal_special_chars);
    }
}
