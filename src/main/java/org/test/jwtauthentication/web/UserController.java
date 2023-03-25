package org.test.jwtauthentication.web;

import org.springframework.web.bind.annotation.*;
import org.test.jwtauthentication.entities.Role;
import org.test.jwtauthentication.entities.User;
import org.test.jwtauthentication.models.RoleUser;
import org.test.jwtauthentication.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> displayUsers() {
        return userService.listUsers();
    }
    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("roles")
    public Role saveUser(@RequestBody Role role) {
        return userService.addRole(role);
    }

    @PostMapping("addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUser roleUser) {
        userService.addRoleToUser(roleUser.getUsername(), roleUser.getRoleName());
    }
}
