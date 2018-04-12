package com.example.controllers;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Movie;
import com.example.domain.User;
import com.example.domain.UsersMap;
import com.example.exception.ValidationException;
import com.example.service.MovieService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/users")
public class Users {
	
	
	Logger logger = LoggerFactory.getLogger(Users.class);
	

	@Autowired
	MovieService movieService;
	
	
	@HystrixCommand(fallbackMethod = "getDefaultMovies",
			commandKey = "movieCommand")
	@RequestMapping(value="/my-movies")
	public List<?> getMovies() {
	return movieService.getMovies();
	}
	
	@RequestMapping(value="/my-movies-nobreak")
	public List<?> getMoviesNoBreak() {
	return movieService.getMovies();
	}
	
	public List<?> getDefaultMovies(){
		return Arrays.asList(new Movie("Star wars1"));
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	Collection<User> getAll() {
         
		return UsersMap.getUsersMap().values();
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	ResponseEntity<User> getByName(@PathVariable String name) throws ValidationException {

		logger.info("parma name is %s ", name);

		 UsersMap.getUsersMap().values().forEach(val->logger.info("value is %s",val));

		ResponseEntity<User> entity = null;

		for (User user : UsersMap.getUsersMap().values()) {
			logger.debug("user name is %s",user.getName());

			if (name.equalsIgnoreCase(user.getName())){
				entity= new ResponseEntity<>(user, HttpStatus.OK);
				break;
			}

		}

		if (entity == null)
			throw new ValidationException("Name not found "+name);
		else
		return entity;

	}

	@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
	ResponseEntity<User> getById(@PathVariable int id) throws ValidationException {
		if (UsersMap.getUsersMap().containsKey(id))
			return new ResponseEntity<>(UsersMap.getUsersMap().get(id), HttpStatus.OK);
		else
			throw new ValidationException("id not found "+id);
	}
	
	@RequestMapping(value="/id/{id}",method=RequestMethod.DELETE)
	ResponseEntity<?> deleteById(@PathVariable int id) throws ValidationException {
		if (UsersMap.getUsersMap().containsKey(id)){
			User user=UsersMap.getUsersMap().remove(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
		else
			throw new ValidationException("id not found "+id);
	}
	
	
	@RequestMapping(value="/id/{id}/{name}",method=RequestMethod.PUT)
	ResponseEntity<User> addById(@PathVariable int id,@PathVariable String name) {
		if (UsersMap.getUsersMap().containsKey(id)){
			return new ResponseEntity("Error", HttpStatus.NOT_FOUND);
		}
		else{
			System.out.println("in else");
			UsersMap.getUsersMap().put(id, new User(Long.valueOf(id), name));
			return new ResponseEntity<>(UsersMap.getUsersMap().get(id), HttpStatus.OK);
		}
	}

}
