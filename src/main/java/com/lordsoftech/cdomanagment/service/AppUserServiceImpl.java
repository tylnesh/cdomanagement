package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.AppUser;
import com.lordsoftech.cdomanagment.model.Role;
import com.lordsoftech.cdomanagment.model.RoleName;
import com.lordsoftech.cdomanagment.repository.AppUserRepository;
import com.lordsoftech.cdomanagment.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImpl  implements AppUserService {
    private final AppUserRepository userRepo;
    private final RoleRepository roleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to the db", user.getUsername());
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the db", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String usernameOrEmail, String roleName) {
        log.info("Adding role {} to user {}", usernameOrEmail, roleName);
        AppUser user = userRepo.findByUsername(usernameOrEmail);
        if (user == null) userRepo.findByEmail(usernameOrEmail);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public AppUser getAppUser(String usernameOrEmail) {
        log.info("Retrieving user {}", usernameOrEmail);
        AppUser user = userRepo.findByUsername(usernameOrEmail);
        if (user == null) userRepo.findByEmail(usernameOrEmail);
        return user;
    }

    @Override
    public List<AppUser> getAppUsers() {
        log.info("Retrieving all users");
        return userRepo.findAll();
    }
}
