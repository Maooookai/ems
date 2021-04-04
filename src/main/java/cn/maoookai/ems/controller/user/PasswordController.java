package cn.maoookai.ems.controller.user;

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
@RequestMapping(value = "/user")
public class PasswordController {

    PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @RequestMapping(value = "/password", method = RequestMethod.GET)
    public ModelAndView password(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/password");
        return modelAndView;
    }

    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public ModelAndView modifyPassword(ModelAndView modelAndView, HttpSession session, PasswordVO vo) {
        PasswordDTO dto = new PasswordDTO();
        dto.setVo(vo);
        dto.setUser((User) session.getAttribute("userinfo"));
        modelAndView.addObject("result", passwordService.modifyPassword(dto));
        modelAndView.setViewName("/user/password");
        return modelAndView;
    }

}
