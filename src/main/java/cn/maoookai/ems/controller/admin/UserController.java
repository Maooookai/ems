package cn.maoookai.ems.controller.admin;

import cn.maoookai.ems.service.UserService;
import cn.maoookai.ems.to.UserAddVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/admin")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user")
    public ModelAndView user(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/user");
        return modelAndView;
    }

    @RequestMapping(value = "/user/add",method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView){
        modelAndView.setViewName("/admin/user/add");
        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView modelAndView, HttpSession session, UserAddVO vo) {
        userService.add(vo);
        session.setAttribute("addResult", "添加用户成功！");
        return modelAndView;
    }

}
