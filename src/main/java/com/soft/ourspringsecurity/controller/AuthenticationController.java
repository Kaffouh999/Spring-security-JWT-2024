package com.soft.ourspringsecurity.controller;


import com.soft.ourspringsecurity.config.AuthenticationService;
import com.soft.ourspringsecurity.dto.JwtAuthenticationResponse;
import com.soft.ourspringsecurity.dto.SignUpRequest;
import com.soft.ourspringsecurity.dto.SigninRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {


        JwtAuthenticationResponse response = authenticationService.signin(request);

       /* ResponseCookie cookie = ResponseCookie.from("access_token", response.getToken()) // key & value
                .httpOnly(true)
                .secure(false)
                .maxAge(Duration.ofHours(1))
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, cookie.toString())*/;

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

