package com.acong.controller;

import com.acong.entity.UserAdmin;
import com.acong.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

@RequestMapping("/UserAdmin")
@Controller
public class UserAdminController {
    @Autowired
    UserAdminService userAdminService;
    @Autowired
    UserAdmin userAdmin;

    @ResponseBody
    @RequestMapping("/queryAll")
    public List<UserAdmin> queryAll(){
        List<UserAdmin> lists = userAdminService.queryall();
        return lists;
    }

    @ResponseBody
    @RequestMapping("/findUserAdminById")
    public UserAdmin findUserAdminById(@RequestParam int user_id){
        UserAdmin userAdmin = userAdminService.findUserAdminById(user_id);
        return userAdmin;
    }

    @ResponseBody
    @RequestMapping("/updateUserAdmin")
    public String updateUserAdmin(){

        userAdmin.setUser_name("zhyn");
        userAdmin.setUser_id(1);
        userAdmin.setUser_password("85885849");
        int result = userAdminService.updateUserAdmin(userAdmin);
        if(result != 0 ){
            return "updata success";
        }else
            return "updata fail";
    }

    @ResponseBody
    @RequestMapping("insertUserAdmin")
    public String insertUserAdmin(){
        userAdmin.setUser_name("zhyn");
        userAdmin.setUser_password("85885849");
        int result = userAdminService.insertUserAdmin(userAdmin);
        if(result != 0 ){
            return "insert success";
        }else
            return "insert fail";
    }

    @ResponseBody
    @RequestMapping("/deleteById")
    public String deleteById(int user_id){
        int result = userAdminService.deleteById(user_id);
        if(result != 0 ){
            return "delete success";
        }else
            return "delete fail";
    }

    @ResponseBody
    @RequestMapping("/findUserAdminByName")
    public List<UserAdmin> findUserAdminByName(String user_name){
        List<UserAdmin> lists = userAdminService.findUserAdminByName(user_name);
        return lists;
    }
}
