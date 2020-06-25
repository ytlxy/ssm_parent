package com.cn.controller;

import com.cn.domain.Permission;
import com.cn.domain.Role;
import com.cn.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Transactional
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
@RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Role> role=iRoleService.findAll();
        mv.addObject("roleList",role);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        iRoleService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findUserByIdAllPermission.do")
    public ModelAndView findUserByIdAllPermission(@RequestParam(name = "id",required = true)Integer roleId)throws Exception{
    ModelAndView mv=new ModelAndView();
    Role role=iRoleService.findById(roleId);
    List<Permission> permissions=iRoleService.findPermission(roleId);
    mv.addObject("role",role);
    mv.addObject("permissionsList",permissions);
    mv.setViewName("role-permissions-add");
    return mv;
    }
    @RequestMapping("/addPermissionsToRole.do")
    public String addPermissionsToRole(@RequestParam(name = "roleId",required = true)Long roleId,@RequestParam(name = "ids",required = true) Long ... permId) throws Exception {
        iRoleService.addPermissionToRole(roleId,permId);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Role role=iRoleService.findById2(id);
        mv.addObject("roles",role);
        mv.setViewName("role-show");
        return mv;
    }
@RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam(name = "id",required = true)Integer id) throws Exception {
        ModelAndView mv=new ModelAndView();
        iRoleService.deleteRoleById(id);
        return "redirect:findAll.do";
    }
}
