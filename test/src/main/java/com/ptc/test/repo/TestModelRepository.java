package com.ptc.test.repo;

import org.springframework.data.repository.CrudRepository;

import com.ptc.test.model.TestModel;

public interface TestModelRepository extends CrudRepository<TestModel, Long>  {

}
