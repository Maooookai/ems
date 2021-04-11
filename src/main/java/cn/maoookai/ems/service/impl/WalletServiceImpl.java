package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.Wallet;
import cn.maoookai.ems.repository.WalletRepository;
import cn.maoookai.ems.service.WalletService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public Page<Wallet> paymentInfo(int page, Long id) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("operateTime").descending());
        return walletRepository.findAllByUserId(id, pageable);
    }

    @Override
    public void charge(Long id, String bill) {
        Wallet wallet = new Wallet();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        DecimalFormat format = new DecimalFormat("#.00");
        wallet.setUserId(id);
        wallet.setOldBalance(currentBalance(id));
        wallet.setOperate("充值");
        wallet.setNewBalance(format.format(Double.parseDouble(wallet.getOldBalance()) + Double.parseDouble(bill)));
        wallet.setOperateTime(simpleDateFormat.format(new Date()));
        walletRepository.save(wallet);
    }
}
