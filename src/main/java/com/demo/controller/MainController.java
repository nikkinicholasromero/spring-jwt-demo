package com.demo.controller;

import com.demo.JwtService;
import com.demo.model.AuthenticationRequest;
import com.demo.model.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class MainController {
    @Value("${jwt.token.expire}")
    private long tokenExpiration;

    @Autowired
    private JwtService jwtService;

    @GetMapping
    public String main() {
        return "Hello, World";
    }

    // TODO : Move logic in AuthenticationService
    // TODO : Authenticate user against DB
    // TODO : Provide JWT details
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        if ("admin".equals(request.getUsername()) || "pass123".equals(request.getPassword())) {
            String token = jwtService.createJWT("", "", "", tokenExpiration);
            AuthenticationResponse response = new AuthenticationResponse(token, tokenExpiration);
            return ResponseEntity.ok().body(response);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
