package com.soft.ourspringsecurity.config;

import com.soft.ourspringsecurity.dto.JwtAuthenticationResponse;
import com.soft.ourspringsecurity.dto.SignUpRequest;
import com.soft.ourspringsecurity.dto.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
