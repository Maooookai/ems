package cn.maoookai.ems.service;

import cn.maoookai.ems.entity.Price;

public interface PriceService {

    Price currentPrice(boolean type);

    String electType(boolean type);

    String currentDay(Long id, boolean type);

    String currentMonth(Long id, boolean type);

    String whichPrice(String date, boolean type);

    String whichMonth(Long id, boolean type, String month);
}
