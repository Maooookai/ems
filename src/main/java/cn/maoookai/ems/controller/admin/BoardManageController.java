package cn.maoookai.ems.controller.admin;

import cn.maoookai.ems.service.BoardService;
import cn.maoookai.ems.to.BoardEditVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class BoardManageController {

    BoardService boardService;

    @Autowired
    public BoardManageController(BoardService boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "admin/board")
    public ModelAndView boards(ModelAndView modelAndView, HttpSession session, @RequestParam(defaultValue = "0") int pageNum) {
        session.setAttribute("boards", boardService.boards(pageNum));
        modelAndView.setViewName("admin/board");
        return modelAndView;
    }

    @RequestMapping(value = "admin/boardInfo")
    public ModelAndView boardInfo(ModelAndView modelAndView, HttpSession session, String boardId) {
        modelAndView.setViewName("admin/boardInfo");
        session.setAttribute("board", boardService.getBoard(Long.valueOf(boardId)));
        return modelAndView;
    }

    @RequestMapping(value = "admin/boardEdit", method = RequestMethod.GET)
    public ModelAndView boardEdit(ModelAndView modelAndView, HttpSession session, Long boardId) {
        modelAndView.setViewName("admin/boardEdit");
        session.setAttribute("boardEdit", boardService.getBoard(boardId));
        return modelAndView;
    }

    @RequestMapping(value = "admin/boardEdit", method = RequestMethod.POST)
    public ModelAndView boardEdit(ModelAndView modelAndView, HttpSession session, BoardEditVO vo) {
        modelAndView.setViewName("admin/boardInfo");
        boardService.edit(vo.getBoardId(), vo.getContent());
        session.setAttribute("board", boardService.getBoard(vo.getBoardId()));
        return modelAndView;
    }

}
