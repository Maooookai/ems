package cn.maoookai.ems.service.impl;

import cn.maoookai.ems.entity.History;
import cn.maoookai.ems.repository.CurrentUsageRepository;
import cn.maoookai.ems.repository.HistoryUsageRepository;
import cn.maoookai.ems.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UsageServiceImpl implements UsageService {

    CurrentUsageRepository currentUsageRepository;
    HistoryUsageRepository historyUsageRepository;

    @Autowired
    public UsageServiceImpl(CurrentUsageRepository currentUsageRepository, HistoryUsageRepository historyUsageRepository) {
        this.currentUsageRepository = currentUsageRepository;
        this.historyUsageRepository = historyUsageRepository;
    }

    @Override
    public String currentUsage(Long id) {
        if (currentUsageRepository.findByUserId(id).isPresent())
            return currentUsageRepository.findByUserId(id).get().getUsed();
        else return "0";
    }

    @Override
    public String currentMonthUsage(Long id) {
        Date date = new Date();
        DecimalFormat format = new DecimalFormat("#.00");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        double used = 0.0 + Double.parseDouble(currentUsage(id));
        List<History> currentMonth = historyUsageRepository.findAllByUserIdAndTimeContains(id, formatter.format(date));
        if (currentMonth.isEmpty())
            return "0";
        else {
            for (History history : currentMonth
            )
                used = used + Double.parseDouble(history.getUsed());
        }
        return format.format(used);
    }

    @Override
    public String whichMonthUsage(Long id, String month) {
        double used = 0.0;
        List<History> histories = historyUsageRepository.findAllByUserIdAndTimeContains(id, month);
        for (History history : histories) {
            used = used + Double.parseDouble(history.getUsed());
        }
        return "您" + month + "的用电量为" + used + "千瓦时";
    }
}
