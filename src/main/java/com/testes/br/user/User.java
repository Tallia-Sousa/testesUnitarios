package com.testes.br.user;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

@Getter
public class User {
    String username;
    String senha;

    public User(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }
}