package cn.maoookai.ems.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user", name = "用户")
public class ProfileController {

    public ModelAndView profile(ModelAndView modelAndView, HttpSession httpSession){
        return modelAndView;
    }

}
