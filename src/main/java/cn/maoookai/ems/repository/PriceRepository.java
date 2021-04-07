package cn.maoookai.ems.repository;

import cn.maoookai.ems.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    Optional<Price> findFirstByElectTypeOrderByDateDesc(boolean type);

    Optional<Price> findFirstByDateBeforeAndElectTypeOrderByDateDesc(String date, boolean type);

}
