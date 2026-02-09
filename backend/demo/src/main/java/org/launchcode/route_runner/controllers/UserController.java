package org.launchcode.route_runner.controllers;

import org.hibernate.mapping.Map;
import org.launchcode.route_runner.models.User;
import org.launchcode.route_runner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

@PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody Map<String, String> userData){
    try {
        String email = userData.get("email");
        String username = userData.get("username");
        String password = userData.get("password");
        String verify = userData.get("verify");

        if(!password.equals(verify)) {
            return ResponseEntity.badRequest().body(Map.of("error", "Passwords do not match"));
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUsername(username);

        userService.save(newUser);
    }
}




}
