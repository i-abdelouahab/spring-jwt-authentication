package org.test.jwtauthentication.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RoleUser {
    private String username;
    private String roleName;
}
