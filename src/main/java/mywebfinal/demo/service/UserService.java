package mywebfinal.demo.service;

import mywebfinal.demo.domain.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    void addUser(String userInfo);

    User checkUser(String userInfo);
}
