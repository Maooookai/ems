package cn.maoookai.ems.service;

public interface UsageService {

    String currentUsage(Long id);

    String currentMonthUsage(Long id);

    String whichMonthUsage(Long id, String month);

}
