package mywebfinal.demo.service.impl;

import com.google.gson.Gson;
import mywebfinal.demo.domain.User;
import mywebfinal.demo.mapper.UserMapper;
import mywebfinal.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableTransactionManagement
@Transactional(rollbackFor = Exception.class)
@MapperScan(basePackages = "mywebfinal.demo", annotationClass = Repository.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser() {

        return userMapper.listUser();
    }

    @Override
    public void addUser(String userInfo) {
        User user = parseToUser(userInfo);
        userMapper.addUser(user);
    }

    @Override
    public User checkUser(String userInfo) {
        User user = parseToUser(userInfo);
        return userMapper.checkUser(user);
    }

    private User parseToUser(String userInfo){
        Gson gson = new Gson();
        Map userInfoM = new HashMap<String,String>();
        userInfoM = gson.fromJson(userInfo, (Type) userInfoM.getClass());
        if(userInfoM.containsKey("uname") && userInfoM.containsKey("psw")){
            User user = new User();
            user.setId(Double.valueOf((Double) userInfoM.get("id")).intValue()); //double to int
            //user.setId(Integer.parseInt(userInfoM.get("id").toString())); //String to int
            user.setUname((String) userInfoM.get("uname"));
            user.setPsw((String) userInfoM.get("psw"));
            return user;
        }else{
            return null;
        }
    }
}
