package com.ptc.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptc.test.model.TestModel;
import com.ptc.test.repo.TestModelRepository;

@org.springframework.stereotype.Controller
@RequestMapping("/test")
public class Controller {
	
@Autowired
TestModelRepository repo;
	
@ResponseBody
@GetMapping(path="/all")
public ResponseEntity getAll(){
	// This returns a JSON or XML with the users
	return ResponseEntity.ok(repo.findAll());
}

 @PostMapping(path="/add", consumes=MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity getAll(@RequestBody TestModel model) {
	System.out.println("Got here at least "); 
	repo.save(model);
	return ResponseEntity.ok("success");
 }
}
