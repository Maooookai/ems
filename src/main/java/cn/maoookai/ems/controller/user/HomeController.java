package cn.maoookai.ems.controller.user;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user", name = "用户")
public class HomeController {

    UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/home", name = "用户主页")
    public ModelAndView userHome(ModelAndView modelAndView, HttpSession session) {
        User user = (User) session.getAttribute("userinfo");
        if (user.getId() == null)
            modelAndView.setViewName("/login");
        else
            modelAndView.setViewName("/user/home");
        return modelAndView;
    }

    @RequestMapping(value = "/exit")
    public ModelAndView exit(ModelAndView modelAndView, HttpSession session) {
        modelAndView.clear();
        session.removeAttribute("userinfo");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/error")
    public ModelAndView error(ModelAndView modelAndView) {
        modelAndView.setViewName("/login");
        return modelAndView;
    }

}
