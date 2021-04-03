package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.repository.BoardRepository;
import cn.maoookai.ems.service.BoardService;
import cn.maoookai.ems.to.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

    BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public BoardVO latestBoard() {
        BoardVO boardVO = new BoardVO();
        if (boardRepository.findFirstByContentIsNotNullOrderByUpdateTimeDesc().isPresent()) {
            boardVO.setContent(boardRepository.findFirstByContentIsNotNullOrderByUpdateTimeDesc().get().getContent());
            boardVO.setTime(boardRepository.findFirstByContentIsNotNullOrderByUpdateTimeDesc().get().getUpdateTime());
        } else {
            boardVO.setContent("暂无公告");
            boardVO.setTime("");
        }
        return boardVO;
    }

}
