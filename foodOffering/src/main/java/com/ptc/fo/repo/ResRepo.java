package com.ptc.fo.repo;

import org.springframework.data.repository.CrudRepository;

import com.ptc.fo.model.Restaurant;

public interface ResRepo extends CrudRepository <Restaurant,Long>{
	

}
