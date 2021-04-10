package cn.maoookai.ems.service;

import cn.maoookai.ems.entity.Board;
import cn.maoookai.ems.to.BoardVO;
import org.springframework.data.domain.Page;

public interface BoardService {

    BoardVO latestBoard();

    Page<Board> boards(int page);

    Board getBoard(Long id);

    void edit(Long id,String content);

}
