package cn.maoookai.ems.controller.user;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.PriceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user", name = "电费查询")
public class PriceController {

    PriceService priceService;

    public PriceController(PriceService service) {
        this.priceService = service;
    }

    @RequestMapping(value = "/bill")
    public ModelAndView bill(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("/user/price");
        User user = (User) session.getAttribute("userinfo");
        session.setAttribute("currentPrice", priceService.currentPrice(user.isElectType()));
        session.setAttribute("currentType", priceService.electType(user.isElectType()));
        session.setAttribute("currentDay", priceService.currentDay(user.getId(),user.isElectType()));
        return modelAndView;
    }

}
