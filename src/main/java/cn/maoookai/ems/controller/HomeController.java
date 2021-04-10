package cn.maoookai.ems.controller;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class HomeController {

    UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "user/home", name = "用户主页")
    public ModelAndView userHome(ModelAndView modelAndView, HttpSession session) {
        User user = (User) session.getAttribute("userinfo");
        if (user.getId() == null)
            modelAndView.setViewName("login");
        else
            modelAndView.setViewName("user/home");
        return modelAndView;
    }

    @RequestMapping(value = "user/exit")
    public ModelAndView exitUser(ModelAndView modelAndView, HttpSession session) {
        modelAndView.clear();
        session.removeAttribute("userinfo");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "admin/home", name = "用户主页")
    public ModelAndView adminHome(ModelAndView modelAndView, HttpSession session) {
        User user = (User) session.getAttribute("adminInfo");
        if (user.getId() == null)
            modelAndView.setViewName("login");
        else
            modelAndView.setViewName("admin/home");
        return modelAndView;
    }

    @RequestMapping(value = "admin/exit")
    public ModelAndView adminExit(ModelAndView modelAndView, HttpSession session) {
        modelAndView.clear();
        session.removeAttribute("admininfo");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "user/error")
    public ModelAndView error(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
