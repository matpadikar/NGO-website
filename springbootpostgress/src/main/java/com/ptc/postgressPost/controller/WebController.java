package com.ptc.postgressPost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptc.postgressPost.model.User;
import com.ptc.postgressPost.repo.UserRepository;

@Controller
public class WebController {

	@Autowired
	UserRepository userRepo;

	
	@ResponseBody
	@RequestMapping(value="/register", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> registerUser(@RequestBody User user) {
    	String info = String.format("User Submission:"+ user);
        System.out.println("Info "+ info);
        User result = userRepo.save(user);               
        ResponseEntity<Object> response = new ResponseEntity<Object>(result, HttpStatus.OK);
		return response;   
	}
	
	@GetMapping("/")
    public String index() {
        return "register";
    }
	
	@ResponseBody
	@RequestMapping(value="/getRegistered", method=RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
    	//String info = String.format("User Submission:"+ user);
        //System.out.println("Info "+ info);
        Iterable<User> result = userRepo.findAll();             
        ResponseEntity<Object> response = new ResponseEntity<Object>(result, HttpStatus.OK);
		return response;   
	}
    
 
}
