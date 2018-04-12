package com.nav.add.controllertest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class ControllerTest {

	
	@RequestMapping(value = "/health", method = RequestMethod.GET)
	public ResponseEntity<String> getHealth(){
	
		return new ResponseEntity<String>("All ok", HttpStatus.OK);
		
	}
}
