package com.nav.add.addServer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nav.add.exception.ValidationException;

@RestController
@RequestMapping(value="/helth")
public class HealthController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	ResponseEntity<String> getHello() throws ValidationException {
		return new ResponseEntity<>("hello from server",HttpStatus.OK);
	}
}
