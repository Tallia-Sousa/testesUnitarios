package com.testes.br.services;

import com.testes.br.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        User userVar = buscarUserr(Username);
        if (userVar != null) {
            listUsers.remove(userVar);
            return listUsers;
        }

        throw new RuntimeException("Usuario invalido");

    }





    public User buscarUserr(String username) {

        Optional<User> userN = listUsers.stream().filter(user ->
                user.getUsername().equals(username))
                .findAny();

        return userN.orElse(null);

    }

    public List<User> ordenarLista(List<User > list){

         list.sort(Comparator.comparingInt(User::getContador));
         return list;
    }
    }