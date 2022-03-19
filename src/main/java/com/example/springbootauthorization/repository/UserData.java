package com.example.springbootauthorization.repository;

import com.example.springbootauthorization.enums.Authorities;
import lombok.Data;

import java.util.List;

/**
 * Encapsulates user attributes
 */
@Data
public class UserData {
    private String password;
    private List<Authorities> authorities;

    public UserData(String password, List<Authorities> authorities) {
        this.password = password;
        this.authorities = authorities;
    }
}
