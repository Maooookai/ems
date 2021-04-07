package cn.maoookai.ems.controller.user;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.UsageService;
import cn.maoookai.ems.to.DateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
public class UsageController {

    UsageService usageService;

    @Autowired
    public UsageController(UsageService usageService) {
        this.usageService = usageService;
    }

    @GetMapping(value = "/usage")
    public ModelAndView usage(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("/user/usage");
        User user = (User) session.getAttribute("userinfo");
        session.setAttribute("currentUsage", usageService.currentUsage(user.getId()));
        session.setAttribute("currentMonthUsage", usageService.currentMonthUsage(user.getId()));
        return modelAndView;
    }

    @PostMapping(value = "/usage")
    public ModelAndView whichMonth(ModelAndView modelAndView, DateVO vo, HttpSession session) {
        modelAndView.setViewName("/user/usage");
        User user = (User) session.getAttribute("userinfo");
        session.setAttribute("whichMonth", usageService.whichMonthUsage(user.getId(), vo.getMonth()));
        return modelAndView;
    }

}
