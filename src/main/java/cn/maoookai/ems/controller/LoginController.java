package cn.maoookai.ems.controller;

import cn.maoookai.ems.service.LoginService;
import cn.maoookai.ems.to.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService=loginService;
    }

    @RequestMapping(value = "/", name = "登录")
    public String login(LoginDTO dto){
        return loginService.login(dto);
    }

}
