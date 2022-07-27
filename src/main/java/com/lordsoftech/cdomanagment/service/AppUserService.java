package com.lordsoftech.cdomanagment.service;

import com.lordsoftech.cdomanagment.model.AppUser;
import com.lordsoftech.cdomanagment.model.Role;
import com.lordsoftech.cdomanagment.model.RoleName;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String usernameOrEmail, String roleName);
    AppUser getAppUser(String username);
    List<AppUser> getAppUsers();
}
