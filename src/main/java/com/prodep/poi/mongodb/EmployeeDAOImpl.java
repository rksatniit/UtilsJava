package com.prodep.poi.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.WriteResult;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String COLLECTION = "Employee";

	 @Autowired
	 MongoTemplate mongoTemplate;

	 public void create(Employee employee) {
	  if (employee != null) {
	   this.mongoTemplate.insert(employee, COLLECTION);
	  }
	 }

	 public Employee findById(int id) {
	  Query query = new Query(Criteria.where("_id").is(id));
	  return this.mongoTemplate.findOne(query, Employee.class, COLLECTION);
	 }

	 public int deleteById(int id) {

	  Query query = new Query(Criteria.where("_id").is(id));
	  WriteResult result = this.mongoTemplate.remove(query, Employee.class,
	    COLLECTION);
	  return result.getN();
	 }

	 public void update(Employee employee) {
	  if (employee != null) {
	   this.mongoTemplate.save(employee, COLLECTION);
	  }
	 }

	 public List findAll() {
	  return (List) mongoTemplate.findAll(Employee.class,
	    COLLECTION);
	 }

	
}
