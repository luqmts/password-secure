package com.luq.secure_password.mapper;

import com.luq.secure_password.dto.PasswordDTO;
import com.luq.secure_password.domain.Password;
import org.springframework.stereotype.Component;

@Component
public class PasswordMapper {
    public Password toEntity(PasswordDTO passwordDTO){
        return new Password(passwordDTO.password());
    }

    public PasswordDTO toDTO(Password password){
        return new PasswordDTO(password.getPassword());
    }
}
