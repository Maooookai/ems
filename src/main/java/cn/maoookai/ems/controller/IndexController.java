package cn.maoookai.ems.controller;

import cn.maoookai.ems.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    BoardService boardService;

    @Autowired
    public IndexController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView, HttpSession session) {
        session.setAttribute("board", boardService.latestBoard());
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index2(ModelAndView modelAndView, HttpSession session) {
        session.setAttribute("board", boardService.latestBoard());
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
