package com.lordsoftech.cdomanagment.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lordsoftech.cdomanagment.model.User;
import com.lordsoftech.cdomanagment.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repo;
    private BCryptPasswordEncoder bcrypter;

    @PostMapping
    public void signUp(@RequestBody User user) {
        user.setPassword(bcrypter.encode(user.getPassword()));
        repo.save(user);

    }

    // @GetMapping("")
    // public List<User> getAll() {

    // }

}
