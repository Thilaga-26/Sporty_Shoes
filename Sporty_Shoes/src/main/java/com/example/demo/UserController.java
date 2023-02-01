package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@Autowired
	UserDAO dao1;
	@Autowired
	ShoeDAO dao;
	
	@ResponseBody
	@RequestMapping("/LoginRegister")
	public ModelAndView Registerpage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserPojo user=new UserPojo();
		user.setUsername(username);
		user.setPassword(password);
		UserPojo u=dao1.Insert(user);
		if(u!=null) {
			mv.setViewName("SuccessRegister.jsp");
		}
		else {
			mv.setViewName("Fail.jsp");
		}
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/login")
	public ModelAndView LoginPage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserPojo u1=dao1.findByUserPassword(username, password);
		List<ShoePojo> list=dao.getall();
		if(u1!=null) {
			
			mv.setViewName("UserDisplay.jsp");
			mv.addObject("u1", u1);
			mv.addObject("list", list);
		}
		else {
			mv.setViewName("Fail.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/ViewUser")
	public ModelAndView ViewUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		List<UserPojo> u2=dao1.getalluser();
		mv.setViewName("DisplayUser.jsp");
		mv.addObject("u2", u2);
		return mv;
	}
}
