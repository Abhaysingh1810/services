package com.nav.add.Old.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/old")
public class OldController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> getHealth(){
	
		return new ResponseEntity<String>("All ok", HttpStatus.OK);
		
	}

}
