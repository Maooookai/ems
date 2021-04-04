package cn.maoookai.ems.controller;

import cn.maoookai.ems.service.BoardService;
import cn.maoookai.ems.service.LoginService;
import cn.maoookai.ems.service.UserService;
import cn.maoookai.ems.to.LoginDTO;
import cn.maoookai.ems.to.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    public ModelAndView login(ModelAndView modelAndView, @Valid LoginDTO loginDTO, HttpSession session) {

        LoginVO loginVO = loginService.login(loginDTO);
        session.setAttribute("board", boardService.latestBoard());
        session.setAttribute("user", loginVO);

        if (!loginVO.isSuccess()) {
            modelAndView.addObject("error", loginVO.getMessage());
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if (loginVO.isAdmin())
            modelAndView.setViewName("/admin/home");
        else {
            session.setAttribute("userinfo", userService.getUserById(Long.parseLong(loginDTO.getId())));
            modelAndView.setViewName("/user/home");
        }
        return modelAndView;
    }

}
