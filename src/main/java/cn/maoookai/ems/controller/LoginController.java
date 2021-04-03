package cn.maoookai.ems.controller;

import cn.maoookai.ems.service.BoardService;
import cn.maoookai.ems.service.LoginService;
import cn.maoookai.ems.service.UserService;
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
    UserService userService;
    BoardService boardService;

    @Autowired
    public LoginController(LoginService loginService, UserService userService, BoardService boardService) {
        this.loginService = loginService;
        this.userService = userService;
        this.boardService = boardService;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, @Valid LoginDTO loginDTO) {

        modelAndView.addObject("board", boardService.latestBoard());
        LoginVO loginVO = loginService.login(loginDTO);

        if (!loginVO.isSuccess()) {
            modelAndView.addObject("error", loginVO.getMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if (loginVO.isAdmin())
            modelAndView.setViewName("/admin/home");
        else {
            modelAndView.setViewName("/user/home");
            modelAndView.getModel().put("user", userService.info(Long.parseLong(loginDTO.getId())));
        }
        return modelAndView;
    }

}
