package mywebfinal.demo.mapper;

import mywebfinal.demo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{

    List<User> listUser();

    void addUser(User user);

    User checkUser(User user);

}