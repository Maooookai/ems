package cn.maoookai.ems.repository;

import cn.maoookai.ems.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    Optional<Board> findFirstByDeletedFalseAndContentIsNotNullOrderByUpdateTimeDesc();

    Page<Board> findAllByDeletedFalse(Pageable pageable);

}
