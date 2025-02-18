package com.learn.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Movie;
import com.learn.exceptions.NotFoundException;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	
	Map<String, Movie> movies = new ConcurrentHashMap<String, Movie>();
	
	public MovieController() {
		movies.put("M001", new Movie("M001","Avengers:Inifinity War",10000));
		movies.put("M002", new Movie("M002", "Civil War", 20000));
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Movie>> getMovies(){
		return new ResponseEntity<>(movies, HttpStatus.OK);
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<?> getMovie(@PathVariable("movieId") String movieId){
		if(movies.containsKey(movieId)) return new ResponseEntity<>(movies.get(movieId), HttpStatus.OK);
		else return new ResponseEntity<>(new NotFoundException("Moview with given ID not found").getMessage(),HttpStatus.NOT_FOUND); // 404
	}
	
	@PostMapping(path = "/",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addMovie(@RequestBody Movie movie){
		movies.put(movie.getId(), movie);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{movieId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateMovie(@PathVariable String movieId,@RequestBody Movie movie){
		if(movies.containsKey(movieId))
		{
			movies.put(movieId, movie);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
		}
		else 
		{
			return new ResponseEntity<Object> (new NotFoundException("Update Movie Failed - Movie with the given id not found").getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{movieId}")
	public ResponseEntity<?> deleteMovie(@PathVariable String movieId){
		if(movies.containsKey(movieId))
		{
			movies.remove(movieId);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else
		{
			return new ResponseEntity<Object> (new NotFoundException("Delete Movie Failed - Movie with the given id not found").getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
