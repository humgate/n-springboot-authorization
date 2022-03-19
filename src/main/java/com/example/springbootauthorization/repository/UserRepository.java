package com.example.springbootauthorization.repository;

import com.example.springbootauthorization.enums.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    //User database
    private final Map<String, UserData> users = new HashMap<>();
    {
        users.put("Vasya", new UserData("123",
                        new ArrayList<>(Arrays.asList(Authorities.READ,Authorities.WRITE))));
        users.put("Masha", new UserData("234",
                new ArrayList<>(Arrays.asList(Authorities.READ,Authorities.WRITE,Authorities.DELETE))));
        users.put("Grisha", new UserData("567",
                new ArrayList<>()));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user)) { //user exists
            if (users.get(user).getPassword().equals(password)) { //password correct
                return users.get(user).getAuthorities();
            } else { //password incorrect
                return new ArrayList<>();
            }
        } else { //user does not exist
            return null;
        }
    }
}
