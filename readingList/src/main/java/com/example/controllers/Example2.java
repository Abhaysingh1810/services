package com.example.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/two")
public class Example2 {

	@RequestMapping("/g")
	public static String getTwo(){
		System.out.println("from two");
		return "one";
	}
}
