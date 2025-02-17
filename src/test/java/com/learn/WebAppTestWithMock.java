package com.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.entity.Movie;

@SpringBootTest
@AutoConfigureMockMvc
public class WebAppTestWithMock {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void moviePost() throws Exception {
		mockMvc.perform(
				MockMvcRequestBuilders.post("/")
				.content(asJsonString(new Movie("M004","Cast Away",90000)))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				
				.andExpect(MockMvcResultMatchers.status().isCreated()); //201

	}
	
	public static String asJsonString(Movie movie) throws Exception {
		try {
			return new ObjectMapper().writeValueAsString(movie);
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	public void movieDelete() throws Exception{
		mockMvc.perform(
				MockMvcRequestBuilders.delete("/M001"))
		.andExpect(MockMvcResultMatchers.status().isNoContent()); //204
		
	}
}
