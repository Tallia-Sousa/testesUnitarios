package com.testes.br;

import com.testes.br.services.userService;
import com.testes.br.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(classes = TestesApplication.class)
public class userServiceTests {


    private userService userService = new userService() ;

    //Cenários de testes

//AAA
    //1 -A arange
    @Test
    public void createUserSucess(){

        //1-A organiza os dados
        User user = new User("tallia", "123", 1);

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
        User user = new User("tallia", "123", 2);
        userService.createUser(user);
        User user3 = new User("tallia", "123",2);

        Exception exception = assertThrows(Exception.class, () -> userService.createUser(user3));
        assertEquals("Usuario ja existe", exception.getMessage());

    }

    @Test
    public void removeUsersSucess(){
        User user = new User("tallia", "123", 1);
        userService.createUser(user);

        List<User> userResult = userService.removeUser(user.getUsername());
        assertEquals(0, userResult.size());
    }



    @Test
    public void removeUsersFailed(){

        User user = new User("tallia", "123",3);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            userService.removeUser(user.getUsername());
            
        });
    }


    @Test
    public void buscarUsuarioPorUsernameSucess(){

            User user = new User("tallia", "123",4);
            userService.createUser(user);

            var buscarUser = userService.buscarUserr(user.getUsername());

            assertEquals(user.getUsername(),buscarUser.getUsername() );
        }

    @Test
    public void buscarUsuarioPorUsernameFailed(){

        User user = new User("tallia", "123",5);
          User userNull =  userService.buscarUserr(user.getUsername());

        assertEquals(userNull, null);

    }


@Test
    public void ordenaUsersPorNum(){
    User user1 = new User("tallia01", "123",3);
    User user2 = new User("tallia02", "123",9);
    User user3 = new User("tallia03", "123",1);
    List<User> listusers = new ArrayList<>();
    listusers.add(user1);
    listusers.add(user2);
    listusers.add(user3);
    List<User> result = userService.ordenarLista(listusers);
    assertEquals(user3,result.get(0));

    assertEquals(user2,result.get(2));

    assertEquals(user1,result.get(1));

}

}
