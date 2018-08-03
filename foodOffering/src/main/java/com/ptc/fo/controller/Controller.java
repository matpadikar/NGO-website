package com.ptc.fo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptc.fo.bean.User;
import com.ptc.fo.model.Restaurant;
import com.ptc.fo.repo.ResRepo;

@org.springframework.stereotype.Controller
@RequestMapping("/foodOffering")
public class Controller {

	@Autowired
	ResRepo resRepo;

	@ResponseBody
	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAll(@RequestBody User model) {
		Restaurant res = new Restaurant();
		res.setName(model.getName());
		res.setOwner(model.getOwner());
		res.setEmail(model.getEmail());
		res.setAddress(model.getAddress());
		res.setMob(model.getMob());
		resRepo.save(res);
		return ResponseEntity.ok("success");
	}

}
