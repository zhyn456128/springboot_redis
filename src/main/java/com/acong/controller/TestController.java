package com.acong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acong.entity.User;
import com.acong.service.UserService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/testController")
	public String testController(){
		
		return "success";
	}
	
	@ResponseBody
	@RequestMapping("/queryAll")
	public List<User> queryAll(){
		List<User> lists = userService.queryAll();
		return lists;
	}
	
	@ResponseBody
	@RequestMapping("/findUserById")
	public Map<String, Object> findUserById(@RequestParam int id){
		User user = userService.findUserById(id);
		Map<String, Object> result = new HashMap<>();
		result.put("uid", user.getUid());
		result.put("uname", user.getUserName());
		result.put("pass", user.getPassWord());
		result.put("salary", user.getSalary());
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/updateUser")
	public String updateUser(){
		User user = new User();
		user.setUid(1);
		user.setUserName("cat");
		user.setPassWord("miaomiao");
		user.setSalary(4000);
		
		int result = userService.updateUser(user);
		
		if(result != 0){
			return "update user success";
		}
		
		return "fail";
	}
	
	@ResponseBody
	@RequestMapping("/deleteUserById")
	public String deleteUserById(@RequestParam int id){
		int result = userService.deleteUserById(id);
		if(result != 0){
			return "delete success";
		}
		return "delete fail";
	}
}
