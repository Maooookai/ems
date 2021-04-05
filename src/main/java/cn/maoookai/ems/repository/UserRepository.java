package cn.maoookai.ems.repository;

import cn.maoookai.ems.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @NotNull List<User> findAll();

    @NotNull Optional<User> findById(@NotNull Long id);
}
