package cn.maoookai.ems.controller.user;

import cn.maoookai.ems.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user", name = "用户")
public class ProfileController {

    @RequestMapping(value = "/profile",name = "个人资料")
    public ModelAndView profile(ModelAndView modelAndView, HttpSession session){
        return modelAndView;
    }

}
