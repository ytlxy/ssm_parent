package com.cn.controller;

import com.cn.domain.Role;
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
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "pageSize", required = true, defaultValue = "5") Integer pageSize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> li = userService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(li);
        mv.addObject("Userinfo", pageInfo);
        mv.setViewName("users-list");
        return mv;
    }

    @RequestMapping("/edit.do")
    public ModelAndView edit(String username) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findByUserId(username);
        mv.addObject("user", user);
        mv.setViewName("users-add");
        return mv;
    }

    @RequestMapping("/delete.do")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:findAll.do";
    }

    @RequestMapping("/update.do")
    public String update(UserInfo userInfo) {
        userService.update(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user_show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) Integer id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        List<Role> otherRoles = userService.findOtherRoles(id);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoelToUser.do")
    public String addRoelToUser(@RequestParam(name = "id") Long userId,@RequestParam(name = "ids",required = true)Long... roleIds) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }
}
