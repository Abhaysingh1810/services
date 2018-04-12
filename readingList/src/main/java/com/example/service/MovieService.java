package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Movie;

@Service
public class MovieService {
	
	
	RestTemplate restTemplate= new RestTemplate();
	
	public List<Movie> getMovies() {
		return this.restTemplate
		.getForObject("http://localhost:9080/movies/",List.class);
		}
	

}
