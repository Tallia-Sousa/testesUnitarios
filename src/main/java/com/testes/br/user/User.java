package com.testes.br.user;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

import java.util.Objects;

@Getter
public class User {
    private String username;
   private  String senha;
   private int contador;


    public User(String username, String senha, int contador) {
        this.username = username;
        this.senha = senha;
        this.contador = contador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", senha='" + senha + '\'' +
                ", contador=" + contador +
                '}';
    }
}