package com.talksane.chat.TalkSane.controller;

import com.talksane.chat.TalkSane.models.LoginRequest;
import com.talksane.chat.TalkSane.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private JWTUtility jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to TalkSane !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody LoginRequest loginRequests) throws Exception {
        System.out.println(loginRequests.toString());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequests.getUsername(), loginRequests.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(loginRequests.getUsername());
    }
}
