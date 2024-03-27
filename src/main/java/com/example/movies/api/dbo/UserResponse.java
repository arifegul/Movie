package com.example.movies.api.dbo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String Id;
    private String userName;
    private String password;
    private String email;
    private Boolean status;
    private List<RoleResponse> roles;
}
