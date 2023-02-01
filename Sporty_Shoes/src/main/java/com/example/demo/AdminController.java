package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AdminController {
	
	@Autowired
	AdminDAO dao1;
	@Autowired
	ShoeDAO dao;
	
	@ResponseBody
	@RequestMapping("/AdminRegister")
	public ModelAndView Registerpage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		AdminPojo admin=new AdminPojo();
		admin.setUser(user);
		admin.setPassword(password);
		AdminPojo u=dao1.InsertAdmin(admin);
		if(u!=null) {
			mv.setViewName("AdminLogin.jsp");
		}
		else {
			mv.setViewName("Fail.jsp");
		}
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping("/loginadmin")
	public ModelAndView LoginPage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		String user=request.getParameter("user");
		String password=request.getParameter("password");
		AdminPojo u1=dao1.findByUserPassword(user, password);
		
		if(u1!=null) {
			mv.setViewName("Admin.jsp");
		}
		else {
			mv.setViewName("Fail.jsp");
		}
	return mv;
	}
	

}
