package com.flightbookin.controller;

import com.flightbookin.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public Map<String, String> registerUser(@RequestBody Map<String, String> request){
        String username = request.get("username");
        String password = request.get("password");
        String message = userService.registerUser(username, password);
        return Map.of("message", message);
    }

    @PostMapping("/login")
    public Map<String, String> loginUser(@RequestBody Map<String, String> request){
        String username = request.get("username");
        String password = request.get("password");
        String message = userService.loginUser(username, password);
        return Map.of("message", message);
    }

    @PostMapping("/logout")
    public Map<String, String> logoutUser(@RequestBody Map<String, String> request){
        String username = request.get("username");
        String message = userService.logoutUser(username);
        return Map.of("message", message);
    }

}
