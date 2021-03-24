package cn.maoookai.ems.controller;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user", name = "用户")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/list", name = "查询所有用户")
    public List<User> list() {
        return userService.list();
    }

}
