package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.History;
import cn.maoookai.ems.entity.Price;
import cn.maoookai.ems.repository.CurrentUsageRepository;
import cn.maoookai.ems.repository.HistoryUsageRepository;
import cn.maoookai.ems.repository.PriceRepository;
import cn.maoookai.ems.service.PriceService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    PriceRepository priceRepository;
    CurrentUsageRepository currentUsageRepository;
    HistoryUsageRepository historyUsageRepository;

    public PriceServiceImpl(PriceRepository priceRepository, CurrentUsageRepository currentUsageRepository, HistoryUsageRepository historyUsageRepository) {
        this.priceRepository = priceRepository;
        this.currentUsageRepository = currentUsageRepository;
        this.historyUsageRepository = historyUsageRepository;
    }

    @Override
    public Price currentPrice(boolean type) {
        if (priceRepository.findFirstByElectTypeOrderByDateDesc(type).isPresent())
            return priceRepository.findFirstByElectTypeOrderByDateDesc(type).get();
        else return new Price();
    }

    @Override
    public String electType(boolean type) {
        return type ? "商用" : "民用";
    }

    @Override
    public String currentDay(Long id, boolean type) {
        DecimalFormat format = new DecimalFormat("#.00");
        if (currentUsageRepository.findByUserId(id).isPresent()) {
            if (Double.parseDouble(currentUsageRepository.findByUserId(id).get().getUsed()) * Double.parseDouble(currentPrice(type).getPrice()) < 1)
                return "0" + format.format(Double.parseDouble(currentUsageRepository.findByUserId(id).get().getUsed()) * Double.parseDouble(currentPrice(type).getPrice()));
            else
                return format.format(Double.parseDouble(currentUsageRepository.findByUserId(id).get().getUsed()) * Double.parseDouble(currentPrice(type).getPrice()));
        } else return "0.0";
    }

    @Override
    public String currentMonth(Long id, boolean type) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        double used = 0.0 + Double.parseDouble(currentDay(id, type));
        List<History> currentMonth = historyUsageRepository.findAllByUserIdAndTimeContains(id, formatter.format(date));
        double price = 0;
        if (currentMonth.isEmpty())
            return "0";
        else {
            for (History history : currentMonth
            ) {
                used = used + Double.parseDouble(history.getUsed());
            }
        }

        if (priceRepository.findFirstByElectTypeOrderByDateDesc(type).isPresent())
            price = Double.parseDouble(priceRepository.findFirstByElectTypeOrderByDateDesc(type).get().getPrice());
        DecimalFormat format = new DecimalFormat("#.00");
        return format.format(price * used);
    }

    @Override
    public String whichPrice(String date, boolean type) {
        date = date + "-01 00:00:00";
        if (priceRepository.findFirstByDateBeforeAndElectTypeOrderByDateDesc(date, type).isPresent())
            return priceRepository.findFirstByDateBeforeAndElectTypeOrderByDateDesc(date, type).get().getPrice();
        else return "0.0";
    }

    @Override
    public String whichMonth(Long id, boolean type, String month) {
        double used = 0.0;
        DecimalFormat format = new DecimalFormat("#.00");
        List<History> histories = historyUsageRepository.findAllByUserIdAndTimeContains(id, month);
        for (History history : histories) {
            used = used + Double.parseDouble(history.getUsed());
        }
        if (used * Double.parseDouble(whichPrice(month, type)) < 1)
            used = Double.parseDouble(format.format(Double.parseDouble("0" + used * Double.parseDouble(whichPrice(month, type)))));
        else
            used = Double.parseDouble(format.format(used * Double.parseDouble(whichPrice(month, type))));
        return "您" + month + "的账单为" + used + "元";

    }

}
