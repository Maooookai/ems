package cn.maoookai.ems.controller;

import cn.maoookai.ems.service.BoardService;
import cn.maoookai.ems.service.LoginService;
import cn.maoookai.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    BoardService boardService;

    @Autowired
    public IndexController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.addObject("board", boardService.latestBoard());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index2(ModelAndView modelAndView){
        modelAndView.addObject("board", boardService.latestBoard());
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
