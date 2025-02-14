package com.flightbookin.service;

import com.flightbookin.model.User;
import com.flightbookin.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final Set<String> loggedInUsers = ConcurrentHashMap.newKeySet();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public String registerUser(String username, String password){
        if(userRepository.findByUsername(username).isPresent()){
            return "Username already exists";
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userRepository.save(newUser);
        return "User registered successfully";
    }

    public String loginUser(String username, String password){
        Optional<User> userN = userRepository.findByUsername(username);
        Optional<User> userP = userRepository.findByPassword(password);
        if (userN.isPresent() && userP.isPresent()){
            loggedInUsers.add(username);
            return "Login Successful; Welcome, " + username;
        }
        return "Error! No such user";
    }

    public String logoutUser(String username){
        if (loggedInUsers.contains(username)){
            loggedInUsers.remove(username);
            return "Logout Successful. Goodbye, " + username;
        }
        return "User is not logged in";
    }

    public boolean isUserLoggedIn(String username){
        return loggedInUsers.contains(username);
    }
}
