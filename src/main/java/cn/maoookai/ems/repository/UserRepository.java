package cn.maoookai.ems.repository;

import cn.maoookai.ems.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @NotNull List<User> findAll();

    Optional<User> findById(Long id);
}
