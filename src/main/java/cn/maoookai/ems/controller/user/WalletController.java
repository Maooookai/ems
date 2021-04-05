package cn.maoookai.ems.controller.user;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.WalletService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/user", name = "用户钱包")
public class WalletController {

    WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @RequestMapping(value = "/wallet")
    public ModelAndView wallet(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/wallet");
        return modelAndView;
    }

    @RequestMapping(value = "/wallet/balance")
    public ModelAndView balance(ModelAndView modelAndView, HttpSession session) {
        User user = (User) session.getAttribute("userinfo");
        session.setAttribute("balance", walletService.currentBalance(user.getId()));
        return modelAndView;
    }

    @RequestMapping(value = "/wallet/payment")
    public ModelAndView payment(ModelAndView modelAndView, @RequestParam(defaultValue = "0") int pageNum, HttpSession session) {
        User user = (User) session.getAttribute("userinfo");
        session.setAttribute("wallets", walletService.paymentInfo(pageNum, user.getId()));
        modelAndView.setViewName("/user/wallet/payment");
        return modelAndView;
    }

    @RequestMapping(value = "/wallet/charge")
    public ModelAndView charge(ModelAndView modelAndView) {
        modelAndView.setViewName("/user/wallet/charge");
        return modelAndView;
    }

}
