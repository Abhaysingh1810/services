package com.example.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/one")
public class Example1 {

	@RequestMapping("/g")
	public static String getOne(){
		System.out.println("from one");


		return "one";
	}
	
	
}
