package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.Board;
import cn.maoookai.ems.repository.BoardRepository;
import cn.maoookai.ems.service.BoardService;
import cn.maoookai.ems.to.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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

    @Override
    public Page<Board> boards(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("updateTime").descending());
        return boardRepository.findAllByDeletedFalse(pageable);
    }

    @Override
    public Board getBoard(Long id) {
        if (boardRepository.findById(id).isPresent())
            return boardRepository.findById(id).get();
        else {
            Board board = new Board();
            board.setContent("请求的内容不存在");
            return board;
        }
    }

    @Override
    public void edit(Long id, String content) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Board board = boardRepository.getOne(id);
        board.setContent(content);
        board.setUpdateTime(simpleDateFormat.format(new Date()));
        boardRepository.save(board);
    }

    @Override
    public void add(Long id, String content) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Board board = new Board();
        board.setContent(content);
        board.setUserId(id);
        board.setUpdateTime(simpleDateFormat.format(new Date()));
        boardRepository.save(board);
    }

    @Override
    public void delete(Long id) {
        Board board = boardRepository.getOne(id);
        board.setDeleted(true);
        boardRepository.save(board);
    }

}
