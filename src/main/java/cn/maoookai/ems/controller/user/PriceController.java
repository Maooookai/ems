package cn.maoookai.ems.controller.user;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.PriceService;
import cn.maoookai.ems.to.DateVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "user", name = "电费查询")
public class PriceController {

    PriceService priceService;

    public PriceController(PriceService service) {
        this.priceService = service;
    }

    @GetMapping(value = "/price")
    public ModelAndView bill(ModelAndView modelAndView, HttpSession session) {
        modelAndView.setViewName("user/price");
        User user = (User) session.getAttribute("userinfo");
        session.setAttribute("currentPrice", priceService.currentPrice(user.isElectType()));
        session.setAttribute("currentType", priceService.electType(user.isElectType()));
        session.setAttribute("currentDay", priceService.currentDay(user.getId(), user.isElectType()));
        session.setAttribute("currentMonth", priceService.currentMonth(user.getId(), user.isElectType()));
        return modelAndView;
    }

    @PostMapping(value = "/price")
    public ModelAndView history(ModelAndView modelAndView, DateVO vo, HttpSession session) {
        User user = (User) session.getAttribute("userinfo");
        session.removeAttribute("historyBill");
        session.setAttribute("historyBill", priceService.whichMonth(user.getId(), user.isElectType(), vo.getMonth()));
        modelAndView.setViewName("user/price");
        return modelAndView;
    }

}
