package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ShoeController {

	
	@Autowired
	ShoeDAO dao;
	
//	private final String Folder_Path="D:\\Sporty_Shoes\\";
//	
//	@RequestMapping("/Insert")
//	public ModelAndView Insert(HttpServletRequest request,HttpServletResponse response,@RequestParam("sname") String sname,
//			@RequestParam("scost") float scost,@RequestParam("file") MultipartFile file) {
//		
//		ModelAndView mv= new ModelAndView();
//		ShoePojo s=new ShoePojo();
//		
//		s.setSname(sname);
//		s.setScost(scost);
//		String FileInfo=Folder_Path+file.getOriginalFilename();
//		s.setFile(FileInfo);
//		
//		ShoePojo shoe=dao.Insert(s);
//		
//		if(shoe!=null) {
//			mv.setViewName("Done.jsp");
//		}
//		else {
//			mv.setViewName("NotDone.jsp");
//		}
//		return mv;
//		
//	}
	
	@PostMapping("/Upload")
	public ResponseEntity<?> uploadImage(@RequestParam("sname")String sname,@RequestParam("sbrand")String sbrand,
			@RequestParam("scost")float scost,@RequestParam("file") MultipartFile file) throws IOException{
		String response=dao.uploadImage(sname, sbrand, scost, file);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@DeleteMapping("/Deletebyid/{id}")
	public String deleteById(@PathVariable("id") int id) {
		dao.deleteById(id);
		return "Deleted the id value of "+id;
	}
	
	@PutMapping("/Update")
	public ShoePojo updateByName(@RequestBody ShoePojo s) {
		return dao.updateByName(s);
	}
	
	@RequestMapping("/DisplayAll")
	public ModelAndView Display(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		List<ShoePojo> list=dao.getall();
		mv.setViewName("Display.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/getalladmin")
	public ModelAndView getalladmin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv= new ModelAndView();
		List<ShoePojo> u2=dao.getall();
		mv.setViewName("AdminProduct.jsp");
		mv.addObject("u2", u2);
		return mv;
	}
	
	
}
