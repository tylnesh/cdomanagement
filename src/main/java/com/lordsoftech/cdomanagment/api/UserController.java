package com.lordsoftech.cdomanagment.api;

import com.lordsoftech.cdomanagment.model.AppUser;
import com.lordsoftech.cdomanagment.model.Role;
import com.lordsoftech.cdomanagment.model.RoleName;
import com.lordsoftech.cdomanagment.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.lordsoftech.cdomanagment.repository.AppUserRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final AppUserService userService;


    private BCryptPasswordEncoder bcrypter;

    @GetMapping("/user/all")
    public ResponseEntity<List<AppUser>> getUsers() {
        return ResponseEntity.ok().body(userService.getAppUsers());
    }


    @PostMapping("/user/save")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) {
        bcrypter = new BCryptPasswordEncoder();
        appUser.setPassword(bcrypter.encode(appUser.getPassword()));
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(appUser));
    }
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/role/save").toUriString());

        return ResponseEntity.created(null).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsernameOrEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @Data
    class RoleToUserForm {
        private String usernameOrEmail;
        private String roleName;
    }



}
