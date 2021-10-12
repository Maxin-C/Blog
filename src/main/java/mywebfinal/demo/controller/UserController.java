package mywebfinal.demo.controller;


import mywebfinal.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/user
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public Object listUser(){return userService.listUser();}

    @RequestMapping("add")
    public void addUser(@RequestBody String userInfo){ userService.addUser(userInfo); }

    @RequestMapping("check")
    public Object checkUser(@RequestBody String userInfo){return userService.checkUser(userInfo);}

}
