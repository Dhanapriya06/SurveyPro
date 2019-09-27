package com.makeathon.surveypro.controller;

import com.makeathon.surveypro.exception.RoleNotFoundException;
import com.makeathon.surveypro.exception.UserAlreadyExistException;
import com.makeathon.surveypro.model.request.LoginRequest;
import com.makeathon.surveypro.model.request.SignUpRequest;
import com.makeathon.surveypro.model.response.APIResponse;
import com.makeathon.surveypro.model.response.JwtAuthenticationResponse;
import com.makeathon.surveypro.security.JwtTokenUtil;
import com.makeathon.surveypro.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;


    @PostMapping(value = "/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest)
            throws UserAlreadyExistException, RoleNotFoundException {
        //TODO Add Encrypyion Decryption of User Password
        userDetailsService.saveUser(signUpRequest);
        return ResponseEntity.ok(new APIResponse(false, "User registered successfully"));
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<JwtAuthenticationResponse> createAuthenticationToken(@Valid @RequestBody LoginRequest loginRequest)
            throws Exception {

        authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }


    private void authenticate(String username, String PIN) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, PIN));
    }
}

