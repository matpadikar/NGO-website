package com.ptc.postgressPost.repo;

import com.ptc.postgressPost.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

}
