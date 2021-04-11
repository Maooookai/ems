package cn.maoookai.ems.service;

import cn.maoookai.ems.entity.Wallet;
import org.springframework.data.domain.Page;

public interface WalletService {

    String currentBalance(Long id);

    Page<Wallet> paymentInfo(int page, Long id);

    void charge(Long id,String bill);

}
