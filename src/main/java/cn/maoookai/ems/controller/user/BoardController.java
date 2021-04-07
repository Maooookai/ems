package cn.maoookai.ems.controller.user;

import cn.maoookai.ems.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RequestMapping(value = "/user")
@RestController
public class BoardController {

    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/board")
    public ModelAndView boards(ModelAndView modelAndView, HttpSession session, @RequestParam(defaultValue = "0") int pageNum) {
        session.setAttribute("boards", boardService.boards(pageNum));
        modelAndView.setViewName("/user/board");
        return modelAndView;
    }

    @RequestMapping(value = "/boardInfo")
    public ModelAndView boardInfo(ModelAndView modelAndView, HttpSession session, String boardId) {
        modelAndView.setViewName("/user/boardInfo");
        session.setAttribute("board", boardService.getBoard(Long.valueOf(boardId)));
        return modelAndView;
    }

}
