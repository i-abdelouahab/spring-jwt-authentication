package org.test.jwtauthentication.services.impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.test.jwtauthentication.entities.Role;
import org.test.jwtauthentication.entities.User;
import org.test.jwtauthentication.repositories.RoleRepository;
import org.test.jwtauthentication.repositories.UserRepository;
import org.test.jwtauthentication.services.UserService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User addUser(User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }
}
