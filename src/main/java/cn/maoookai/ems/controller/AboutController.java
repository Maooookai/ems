package cn.maoookai.ems.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AboutController {

    @GetMapping("about")
    public ModelAndView about(ModelAndView modelAndView) {
        modelAndView.setViewName("about");
        return modelAndView;
    }

}
