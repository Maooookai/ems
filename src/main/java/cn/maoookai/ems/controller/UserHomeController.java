package cn.maoookai.ems.controller;

import cn.maoookai.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/user", name = "用户")
public class UserHomeController {

    UserService userService;

    @Autowired
    public UserHomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/home", name = "用户主页")
    public ModelAndView userHome(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/home");
        return modelAndView;
    }

    @RequestMapping(value = "/exit")
    public ModelAndView exit(ModelAndView modelAndView){
        modelAndView.clear();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/error")
    public ModelAndView error(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
