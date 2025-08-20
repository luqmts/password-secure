package com.luq.secure_password.controllers;

import com.luq.secure_password.dto.PasswordDTO;
import com.luq.secure_password.services.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate-password")
public class PasswordController {
    @Autowired
    PasswordService passwordService;

    @PostMapping
    public ResponseEntity validatePassword(@RequestBody PasswordDTO passwordDTO){
        return new ResponseEntity(passwordService.validatePassword(passwordDTO), HttpStatus.OK);
    }
}
