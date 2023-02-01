package com.example.demo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ShoeDAO {

	@Autowired
	ShoeRepo repo;
	
	private final String Folder_Path="D:\\Sporty_Shoes\\";
	
//	public ShoePojo Insert(ShoePojo s) {
//		return repo.save(s);
//	}
	
    public String uploadImage(String sname,String sbrand,float scost,MultipartFile file) throws IOException {
		
		ShoePojo s=new ShoePojo();
		String fileinfo=Folder_Path+file.getOriginalFilename();
		s.setSname(sname);
		s.setSbrand(sbrand);
		s.setScost(scost);;
		s.setFile(fileinfo);
		ShoePojo res=repo.save(s);
		file.transferTo(new File(fileinfo));
		if(res!=null) {
			return "FilePath Uploaded successfully in DB "+file.getOriginalFilename();
		}
		return null;
	}
	
   public void deleteById(int id) {
		repo.deleteById(id);
			
   }
		
   public ShoePojo updateByName(ShoePojo s) {
	    ShoePojo ss=repo.findById(s.getSno()).orElse(null);
		ss.setSname(s.getSname());
		ss.setSbrand(s.getSbrand());
		ss.setScost(s.getScost());
		return repo.save(ss);
   }
   
   public List<ShoePojo> getall(){
		return repo.findAll();
	}
}
