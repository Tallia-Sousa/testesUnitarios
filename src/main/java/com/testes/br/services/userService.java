package com.testes.br.services;

import com.testes.br.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService {
//simulaçao

    List<User> listUsers = new ArrayList<>();


    public List<User> createUser(User user) {
        if (listUsers.contains(user)) {
            throw new RuntimeException("Usuario ja existe");
        }
        listUsers.add(user);
        return listUsers;

    }

    public List<User> removeUser(String Username) {

        User userVar = null;
        for (User user : listUsers) {
            if (user.getUsername().equals(Username)) {
                userVar = user;
                break;
            }
        }

        if (userVar != null) {
            listUsers.remove(userVar);
            return listUsers;
        }

        throw new RuntimeException("Usuario invalido");

        }
}