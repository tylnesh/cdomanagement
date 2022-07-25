package com.lordsoftech.cdomanagment.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lordsoftech.cdomanagment.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authManager;
    //private static SecretKey key;


    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authManager = authenticationManager;
        setFilterProcessesUrl("/login");
        //key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User creds = new ObjectMapper().readValue(request.getInputStream(), User.class);
            return authManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(), creds.getPassword(), new ArrayList<>()));
        } catch (IOException ex) {
            throw new RuntimeException("Could not read request: " + ex);
        }
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) {
        String token = Jwts.builder()
                .setSubject(((User) authentication.getPrincipal()).getEmail())
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                //.signWith(getPublicKey())
                .signWith(SignatureAlgorithm.HS512, "SecretKeyToGenJWTs".getBytes())
                .compact();
        response.addHeader("Authorization","Bearer " + token);
    }

//    public static SecretKey getPublicKey() {
//        return key;
//    }
//
//    public void generatePublicKey() {
//        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//    }
}
