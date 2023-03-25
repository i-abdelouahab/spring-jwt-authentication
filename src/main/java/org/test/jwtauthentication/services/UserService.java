package org.test.jwtauthentication.services;

import org.test.jwtauthentication.entities.Role;
import org.test.jwtauthentication.entities.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
    Role addRole(Role role);
    void addRoleToUser(String username, String roleName);
    User loadUserByUsername(String username);
    List<User> listUsers();
}




