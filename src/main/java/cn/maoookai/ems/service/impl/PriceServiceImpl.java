package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.Price;
import cn.maoookai.ems.repository.CurrentUsageRepository;
import cn.maoookai.ems.repository.PriceRepository;
import cn.maoookai.ems.service.PriceService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class PriceServiceImpl implements PriceService {

    PriceRepository repository;
    CurrentUsageRepository currentUsageRepository;

    public PriceServiceImpl(PriceRepository repository, CurrentUsageRepository currentUsageRepository) {
        this.repository = repository;
        this.currentUsageRepository = currentUsageRepository;
    }

    @Override
    public Price currentPrice(boolean type) {
        if (repository.findFirstByElectTypeOrderByDateDesc(type).isPresent())
            return repository.findFirstByElectTypeOrderByDateDesc(type).get();
        else return new Price();
    }

    @Override
    public String electType(boolean type) {
        return type ? "商用" : "民用";
    }

    @Override
    public String currentDay(Long id, boolean type) {
        DecimalFormat format = new DecimalFormat("#.00");
        if (currentUsageRepository.findByUserId(id).isPresent())
            return format.format(Double.parseDouble(currentUsageRepository.findByUserId(id).get().getUsed()) * Double.parseDouble(currentPrice(type).getPrice()));
        else return "未发现用电数据";
    }
}
