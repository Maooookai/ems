package cn.maoookai.ems.controller.admin;

import cn.maoookai.ems.service.PriceService;
import cn.maoookai.ems.to.PriceEditVO;
import cn.maoookai.ems.to.PriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class PriceManageController {

    PriceService priceService;

    @Autowired
    public PriceManageController(PriceService priceService) {
        this.priceService = priceService;
    }

    @RequestMapping(value = "admin/price", method = RequestMethod.GET)
    public ModelAndView price(ModelAndView modelAndView, HttpSession session) {
        PriceVO vo = new PriceVO();
        session.removeAttribute("currentPrice");
        vo.setCivil(priceService.currentPrice(false).getPrice());
        vo.setCommercial(priceService.currentPrice(true).getPrice());
        session.setAttribute("currentPrice", vo);
        modelAndView.setViewName("admin/price");
        return modelAndView;
    }

    @RequestMapping(value = "admin/price", method = RequestMethod.POST)
    public ModelAndView price(ModelAndView modelAndView, PriceEditVO vo) {
        priceService.editPrice(vo);
        modelAndView.setViewName("admin/price");
        return modelAndView;
    }
}
