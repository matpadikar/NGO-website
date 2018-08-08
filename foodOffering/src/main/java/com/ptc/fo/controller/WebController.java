package com.ptc.fo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

//import com.ptc.fo.bean.User;
import com.ptc.fo.model.Restaurant;
import com.ptc.fo.repo.ResRepo;

@Controller
public class WebController {
	
	@Autowired
	ResRepo resRepo;
	
	@ResponseBody
	@RequestMapping(value="/res_register", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> registerRes(@RequestBody Restaurant res)
	{
		String info =String.format("User Submission:" + res);
		System.out.println("info"+info);
		Restaurant result = resRepo.save(res);
		ResponseEntity<Object> response = new ResponseEntity<Object>(result, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/")
	public String index() {
		return "res_register";
	}
	
	@ResponseBody
	@RequestMapping(value="/get_registered", method=RequestMethod.GET)
	public ResponseEntity<?> getRestaurants()
	{
		Iterable<Restaurant> result = resRepo.findAll();
		ResponseEntity<Object> response = new ResponseEntity<Object>(result, HttpStatus.OK);
		return response;
	}
	

}
