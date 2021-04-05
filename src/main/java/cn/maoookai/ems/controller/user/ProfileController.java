package cn.maoookai.ems.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/user", name = "用户")
public class ProfileController {

    @RequestMapping(value = "/profile", name = "个人资料")
    public ModelAndView profile(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/profile");
        return modelAndView;
    }

}
