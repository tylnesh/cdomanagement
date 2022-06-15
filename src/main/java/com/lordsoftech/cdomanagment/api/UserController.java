package com.lordsoftech.cdomanagment.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lordsoftech.cdomanagment.model.User;
import com.lordsoftech.cdomanagment.repository.UserRepository;

@RestController
@RequestMapping("/api/v1/dealer")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository repo;

    @GetMapping
    public List<User> getAll() {

    }

}
