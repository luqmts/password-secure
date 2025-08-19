package com.luq.secure_password.services;

import com.luq.secure_password.dto.PasswordDTO;
import com.luq.secure_password.domain.Password;
import com.luq.secure_password.exceptions.*;
import com.luq.secure_password.mapper.PasswordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PasswordService {
    @Autowired
    PasswordMapper passwordMapper;

    public PasswordDTO validatePassword(PasswordDTO passwordDTO){
        Password password = passwordMapper.toObject(passwordDTO);
        ArrayList<RuntimeException> exceptions = new ArrayList<>();

        try { password.validate_minimal_length(); }
        catch(MinimalLengthException e) { exceptions.add(e); }

        try { password.validate_minimal_upper_case(); }
        catch(MinimalUpperCaseException e) { exceptions.add(e); }

        try { password.validate_minimal_lower_case(); }
        catch(MinimalLowerCaseException e) { exceptions.add(e); }

        try { password.validate_minimal_digits(); }
        catch(MinimalDigitsException e) { exceptions.add(e); }

        try { password.validate_minimal_special_chars(); }
        catch(MinimalSpecialCharactersException e) { exceptions.add(e); }

        if (!exceptions.isEmpty()) throw new AggregationException(exceptions);

        return passwordDTO;
    }
}
