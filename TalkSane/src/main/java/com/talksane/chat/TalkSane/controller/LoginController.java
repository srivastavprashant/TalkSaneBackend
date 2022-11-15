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

import java.util.HashMap;
import java.util.Map;

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
    public String generateToken(@RequestBody LoginRequest loginRequest) throws Exception {
        System.out.println(loginRequest.toString());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(loginRequest.getUsername());
    }

    @PostMapping("/check")
    public Map<Object,Object> check(@RequestBody String s) throws Exception{
        org.json.JSONObject jObject=new org.json.JSONObject("{\n" +
                "    \"check\":12345689,\n" +
                "    \"check1\":\"no cfheck\"\n" +
                "}");
        org.json.JSONObject obj=new org.json.JSONObject(s);
        System.out.println("check started");
//        System.out.println(obj.get("check"));
        try{
            System.out.println(obj.get("check"));

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        Map<Object, Object> map=new HashMap<>();
        for(String s1: jObject.keySet()){
            map.put(s1,jObject.get(s1));
        }
        return map;
    }

}
//statusCode, message ,exceptionOccured, exceptionMessage, object(JSON obj, json array)
