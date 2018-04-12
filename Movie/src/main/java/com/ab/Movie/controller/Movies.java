package com.ab.Movie.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ab.Movie.domain.Movie;

@RestController
@RequestMapping(value="/movies")
public class Movies {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<String> getHealth(){
	
		return new ResponseEntity<String>("All ok", HttpStatus.OK);
		
	}
	
    @RequestMapping(method=RequestMethod.GET)
    public List<Movie> getMovies() throws InterruptedException{
		
    	Thread.sleep(new Random().nextInt(1000));
   	return Arrays.asList(new Movie("Red Cliff")
				,new Movie("Lord of the Rings"));
    	
    }


}
