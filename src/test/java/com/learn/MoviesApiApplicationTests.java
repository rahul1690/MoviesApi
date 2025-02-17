package com.learn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.learn.controller.MovieController;

/**
 * @SpringBootTest annotation tells Spring boot
 * for a main configuration class(Runnable class) with @SpringBootApplication
 * and that to start Spring Application context
 */
@SpringBootTest
class MoviesApiApplicationTests {

	@Autowired
	MovieController movieController;
	
	//simple sanity check to check if the application context can start
	@Test
	void contextLoads() {
	}
	
	//simple sanity check test if the context is creating controller
	@Test
	void controllerLoads() throws Exception{
		assertThat(movieController).isNotNull();
//		assertThat(movieController).isNull();
	}

}
