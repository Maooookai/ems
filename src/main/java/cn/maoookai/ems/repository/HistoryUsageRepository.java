package cn.maoookai.ems.repository;

import cn.maoookai.ems.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryUsageRepository extends JpaRepository<History, Long> {

    List<History> findAllByUserIdAndTimeContains(Long userId, String date);

}
