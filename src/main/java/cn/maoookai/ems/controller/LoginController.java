package cn.maoookai.ems.controller;

import cn.maoookai.ems.service.LoginService;
import cn.maoookai.ems.to.LoginDTO;
import cn.maoookai.ems.to.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@Validated
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid LoginDTO loginDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("error", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            modelAndView.setViewName("index");
            return modelAndView;
        }

        LoginVO loginVO = loginService.login(loginDTO);

        if (!loginVO.isSuccess()) {
            modelAndView.addObject("error", loginVO.getMessage());
            modelAndView.setViewName("index");
            return modelAndView;
        }

        if (loginVO.isAdmin())
            modelAndView.setViewName("/admin/home");
        else
            modelAndView.setViewName("/user/home");
        return modelAndView;
    }

}
