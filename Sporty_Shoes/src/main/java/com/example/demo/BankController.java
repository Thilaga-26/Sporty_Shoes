package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class BankController {

	@Autowired
	BankDAO dao;
	
	@PostMapping("/InsertAmount")
	public BankPojo Insertamnt(@RequestBody BankPojo b) {
		return dao.InsertAmount(b);
	}
	
	@RequestMapping("/bankamount")
	public ModelAndView procced(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		
		List<BankPojo> bb=dao.getAmnt();
		if(bb!=null) {	
			mv.setViewName("Paymentsuccess.jsp");
		}
		else {
			mv.setViewName("NotDone.jsp");
		}
		return mv;
		
		
	}	
}
