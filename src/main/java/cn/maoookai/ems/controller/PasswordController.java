package cn.maoookai.ems.controller;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.PasswordService;
import cn.maoookai.ems.to.PasswordDTO;
import cn.maoookai.ems.to.PasswordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class PasswordController {

    PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @RequestMapping(value = "user/password", method = RequestMethod.GET)
    public ModelAndView passwordUser(ModelAndView modelAndView) {
        modelAndView.setViewName("user/password");
        return modelAndView;
    }

    @RequestMapping(value = "user/password", method = RequestMethod.POST)
    public ModelAndView modifyPasswordUser(ModelAndView modelAndView, HttpSession session, PasswordVO vo) {
        PasswordDTO dto = new PasswordDTO();
        dto.setVo(vo);
        dto.setUser((User) session.getAttribute("userinfo"));
        modelAndView.addObject("result", passwordService.modifyPassword(dto));
        modelAndView.setViewName("user/password");
        return modelAndView;
    }

    @RequestMapping(value = "admin/password", method = RequestMethod.GET)
    public ModelAndView passwordAdmin(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/password");
        return modelAndView;
    }

    @RequestMapping(value = "admin/password", method = RequestMethod.POST)
    public ModelAndView modifyPasswordAdmin(ModelAndView modelAndView, HttpSession session, PasswordVO vo) {
        PasswordDTO dto = new PasswordDTO();
        dto.setVo(vo);
        dto.setUser((User) session.getAttribute("admininfo"));
        modelAndView.addObject("result", passwordService.modifyPassword(dto));
        modelAndView.setViewName("admin/password");
        return modelAndView;
    }

}
