package com.mycompany.springwebapp.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Ch04Form3 {
	private String mid;
	private String mpassword;
	private String memail;
	private String mtel;
}
