package com.offcn.controller;

import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService  userService;
    //获取全部用户信息
    @GetMapping("/")
    public String findAll(Model model){
        List<User> all = userService.findAll();
          model.addAttribute("page",all);
          return "user/list";
    }
    //用户点击add按钮，跳转到新增用户页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/useradd";
    }
    //保存新增用户数据
    @PostMapping("/add")
    public String save(User user){
        userService.add(user);
        //添加之后进行重定向,获取所有列表
        return "redirect:/";
    }
    //跳转到编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model,@PathVariable("id") Long id){
        User one = userService.findOne(id);
           model.addAttribute("user",one);
        return "user/useredit";
    }

    //保存修改用户数据
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user.getId(),user);//进行修改数据
        return "redirect:/";
    }

    @PutMapping("/put/update/{id}")
    public String update(@PathVariable("id") Long id,User user){
        userService.update(id,user);//进行修改数据
        return "redirect:/";
    }
    //删除用户数据
    @DeleteMapping("/del/delete/{id}")
    public String deleteByDel(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }
    //删除用户数据
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }

    }
