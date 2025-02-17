package com.learn.entity;

public class Movie {

	private String id;
	private String movieName;
	private int movieCollection;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String id, String movieName, int movieCollection) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.movieCollection = movieCollection;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieCollection() {
		return movieCollection;
	}

	public void setMovieCollection(int movieCollection) {
		this.movieCollection = movieCollection;
	}
	

	
	
	
}
