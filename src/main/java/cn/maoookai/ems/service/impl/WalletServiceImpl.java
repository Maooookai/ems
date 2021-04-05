package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.Wallet;
import cn.maoookai.ems.repository.WalletRepository;
import cn.maoookai.ems.service.WalletService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public String currentBalance(Long id) {
        if (walletRepository.findFirstByUserIdOrderByOperateTimeDesc(id).isPresent())
            return walletRepository.findFirstByUserIdOrderByOperateTimeDesc(id).get().getNewBalance();
        else return "0";
    }

    @Override
    public Page<Wallet> paymentInfo(int page) {
        return null;
    }
}
