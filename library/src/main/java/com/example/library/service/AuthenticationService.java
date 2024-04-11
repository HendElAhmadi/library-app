package com.example.library.service;

import com.example.library.web.request.LoginRequest;
import com.example.library.web.response.LoginResponse;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface AuthenticationService {

    LoginResponse login(LoginRequest loginRequest) throws NoSuchAlgorithmException, InvalidKeyException;
    Boolean logout();
}
