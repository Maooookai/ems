package cn.maoookai.ems.controller.admin;

import cn.maoookai.ems.entity.User;
import cn.maoookai.ems.service.UserService;
import cn.maoookai.ems.to.UserAddVO;
import cn.maoookai.ems.to.UserEditVO;
import cn.maoookai.ems.to.UserSearchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "admin")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user")
    public ModelAndView user(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/user");
        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/user/add");
        return modelAndView;
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ModelAndView add(ModelAndView modelAndView, HttpSession session, UserAddVO vo) {
        userService.add(vo);
        session.removeAttribute("addResult");
        session.setAttribute("addResult", "添加用户成功！");
        return modelAndView;
    }

    @RequestMapping(value = "/user/list")
    public ModelAndView all(ModelAndView modelAndView, @RequestParam(defaultValue = "0") int pageNum, HttpSession session) {
        session.removeAttribute("users");
        session.setAttribute("users", userService.list(pageNum));
        return modelAndView;
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public ModelAndView search(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/user/search");
        return modelAndView;
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.POST)
    public ModelAndView search(ModelAndView modelAndView, HttpSession session, UserSearchVO userSearchVO) {
        session.removeAttribute("search");
        session.setAttribute("search", userService.search(userSearchVO));
        modelAndView.setViewName("admin/user/searchResult");
        return modelAndView;
    }

    @RequestMapping(value = "/user/edit",method = RequestMethod.GET)
    public ModelAndView edit(ModelAndView modelAndView, HttpSession session, String editId) {
        modelAndView.setViewName("admin/user/edit");
        session.setAttribute("editInfo", userService.getUserById(Long.parseLong(editId)));
        return modelAndView;
    }

    @RequestMapping(value = "/user/edit",method = RequestMethod.POST)
    public ModelAndView edit(ModelAndView modelAndView,HttpSession session, UserEditVO vo){
        User user = (User) session.getAttribute("editInfo");
        userService.edit(vo, user.getId());
        modelAndView.setViewName("admin/user/list");
        return modelAndView;
    }

}
