package com.learn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.learn.entity.Movie;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	@Test
	public void movieGetByIdTest() throws Exception{
		assertThat(this.testRestTemplate.getForObject("http://localhost:"+this.port+"/M001", Movie.class).getMovieCollection())
		.isEqualTo(10000);
		
	}
	

}
