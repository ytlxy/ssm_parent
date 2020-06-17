package com.cn.controller;

import com.cn.domain.UserInfo;
import com.cn.service.IUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Transactional
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "5")Integer pageSize) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<UserInfo> li=userService.findAll(page,pageSize);
        PageInfo pageInfo=new PageInfo(li);
        mv.addObject("Userinfo",pageInfo);
        mv.setViewName("users-list");
        return mv;
    }
}
