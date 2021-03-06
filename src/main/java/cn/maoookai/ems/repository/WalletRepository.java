package cn.maoookai.ems.repository;

import cn.maoookai.ems.entity.Wallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    Optional<Wallet> findFirstByUserIdOrderByOperateTimeDesc(Long id);

    Page<Wallet> findAllByUserId(Long id, Pageable pageable);

}
