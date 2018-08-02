package com.RESngos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.RESngos.model.Restaurant;
import com.RESngos.service.RestaurantService;
//import com.RESngos.service.imp1.RestaurantServiceImp1;

@SpringBootApplication
public class SpringBootJdbcApplication {
	
	
	@Autowired
	RestaurantService restaurantService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);

	}
}
