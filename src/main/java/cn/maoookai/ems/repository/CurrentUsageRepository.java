package cn.maoookai.ems.repository;

import cn.maoookai.ems.entity.Current;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrentUsageRepository extends JpaRepository<Current, Long> {

    @NotNull
    Optional<Current> findByUserId(@NotNull Long id);

}
