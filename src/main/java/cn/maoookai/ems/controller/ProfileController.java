package cn.maoookai.ems.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProfileController {

    @RequestMapping(value = "user/profile", name = "个人资料")
    public ModelAndView profileUser(ModelAndView modelAndView) {
        modelAndView.setViewName("user/profile");
        return modelAndView;
    }

    @RequestMapping(value = "admin/profile", name = "个人资料")
    public ModelAndView profileAdmin(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/profile");
        return modelAndView;
    }

}
