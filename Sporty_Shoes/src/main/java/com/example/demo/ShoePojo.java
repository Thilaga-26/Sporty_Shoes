package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ShoePojo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sno;
	private String sname;
	private String sbrand;
	private float scost;
	private String file;
}
