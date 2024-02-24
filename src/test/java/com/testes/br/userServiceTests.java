package com.testes.br;

import com.testes.br.services.userService;
import com.testes.br.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes = TestesApplication.class)
public class userServiceTests {


    private userService userService = new userService() ;

//AAA
    //1 -A arange
    @Test
    public void createUserSucess(){

        //1-A organiza os dados
        User user = new User("tallia", "123");
        //2-A = agir
        List<User> result = userService.createUser(user);
      // 3-A onde usa o assertion e faz as verificaçoes
        //checagem
        //o assertion verificamos valores, se sao iguais

        assertEquals(1, result.size());
        assertEquals(user, result.get(0));

    }


    @Test
    public void createUserFailed(){
        User user = new User("tallia", "123");
        userService.createUser(user);
        assertThrows(Exception.class, () -> userService.createUser(user));

    }

    @Test
    public void removeUsersSucess(){
        User user = new User("tallia", "123");
        userService.createUser(user);

        List<User> userResult = userService.removeUser(user.getUsername());
        assertEquals(0, userResult.size());
    }



    @Test
    public void removeUsersFailed(){

        User user = new User("tallia", "123");

        assertThrows(RuntimeException.class, () -> {
            userService.removeUser(user.getUsername());
        });
    }
}
