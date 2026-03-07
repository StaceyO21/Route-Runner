package org.launchcode.route_runner.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.hibernate.mapping.Map;
import org.launchcode.route_runner.models.User;
import org.launchcode.route_runner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

@PostMapping("/login")
public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData, HttpServletRequest request) {
    String email = loginData.get("email");
    String password = loginData.get("password");

    try {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        HttpSession session = request.getSession(true);
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        return ResponseEntity.ok(Map.of(
                "message", "Login successful",
                "userId", user.getId()
        ));
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }
}

@PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        request.getSession().invalidate();
        SecurityContextHolder.clearContext();
        return ResponseEntity.ok("Logged out successfully");
}

}
