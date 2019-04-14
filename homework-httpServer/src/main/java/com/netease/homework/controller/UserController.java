package com.netease.homework.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netease.homework.commons.HResult;
import com.netease.homework.pojo.User;
import com.netease.homework.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login")
	public String loginPage(HttpServletRequest request,Model model) {
		if(request.getParameter("redirectURL")!=null){
			model.addAttribute("redirectURL", request.getParameter("redirectURL"));
		}else {
			model.addAttribute("redirectURL", "/");
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.setAttribute("user", null);
		return "redirect:/login";
	}

	@RequestMapping("/api/login")
	@ResponseBody
	public HResult onLogin(String userName, String password,
			HttpSession session) {
		List<User> users = userService.validate(userName, password);
		if (users.size() == 1) {
			session.setAttribute("user", users.get(0));
			session.setMaxInactiveInterval(60 * 60 * 24);
			return HResult.ok();
		}
		return HResult.build(500, "用户或密码错误");
	}
}
