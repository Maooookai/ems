package cn.maoookai.ems.service;

import cn.maoookai.ems.entity.Price;

public interface PriceService {

    Price currentPrice(boolean type);

    String electType(boolean type);

    String currentDay(Long id, boolean type);
}
