package com.luq.secure_password.domain;

import com.luq.secure_password.exceptions.MinimalLengthException;
import com.luq.secure_password.exceptions.MinimalUpperCaseException;
import com.luq.secure_password.exceptions.MinimalLowerCaseException;
import com.luq.secure_password.exceptions.MinimalDigitsException;
import com.luq.secure_password.exceptions.MinimalSpecialCharactersException;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public class Password{
    private final Integer MINIMAL_LENGTH = 8;
    private final Integer MINIMAL_UPPERCASE = 1;
    private final Integer MINIMAL_LOWERCASE = 1;
    private final Integer MINIMAL_DIGITS = 1;
    private final Integer MINIMAL_SPECIAL_CHARS = 1;

    private String password;

    private Stream<Character> to_char_stream(){
        return this.password.chars().mapToObj(c -> (char) c);
    }

    public void validate_minimal_length(){
        if (password.length() < MINIMAL_LENGTH)
            throw new MinimalLengthException("Password have not enough length expected ("+ MINIMAL_LENGTH +" expected)");
    }

    public void validate_minimal_upper_case(){
        long qttUpperCase = to_char_stream()
            .filter(Character::isUpperCase)
            .count();

        if(qttUpperCase < MINIMAL_UPPERCASE)
            throw new MinimalUpperCaseException("Password expect at least "+ MINIMAL_UPPERCASE +" upper case character(s)");

    }

    public void validate_minimal_lower_case(){
        long qttLowerCase = to_char_stream()
            .filter(Character::isLowerCase)
            .count();

        if(qttLowerCase < MINIMAL_UPPERCASE)
            throw new MinimalLowerCaseException("Password expect at least "+ MINIMAL_LOWERCASE +" lower case character(s)");
    }

    public void validate_minimal_digits(){
        long qttDigits =  to_char_stream()
            .filter(Character::isDigit)
            .count();

        if (qttDigits < MINIMAL_DIGITS)
            throw new MinimalDigitsException("Password expect at least "+ MINIMAL_DIGITS +" digit(s)");
    }

    public void validate_minimal_special_chars(){
        long qttSpecialChar = to_char_stream()
            .filter(c -> !Character.isLetterOrDigit(c))
            .count();

        if (qttSpecialChar < MINIMAL_SPECIAL_CHARS)
            throw new MinimalSpecialCharactersException("Password expect at least "+ MINIMAL_SPECIAL_CHARS +" special character(s)");
    }
}
