package com.luq.secure_password.entity;

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

    public boolean has_minimal_length(){
        return password.length() >= MINIMAL_LENGTH;
    }

    public boolean has_minimal_upper_case(){
        return to_char_stream()
            .filter(Character::isUpperCase)
            .count() >= MINIMAL_UPPERCASE;
    }

    public boolean has_minimal_lower_case(){
        return to_char_stream()
            .filter(Character::isLowerCase)
            .count() >= MINIMAL_UPPERCASE;
    }

    public boolean has_minimal_digits(){
        return to_char_stream()
            .filter(Character::isDigit)
            .count() >= MINIMAL_DIGITS;
    }

    public boolean has_minimal_special_chars(){
        return to_char_stream()
            .filter(c -> !Character.isLetterOrDigit(c))
            .count() >= MINIMAL_DIGITS;
    }
}
