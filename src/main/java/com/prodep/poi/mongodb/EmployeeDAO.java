package com.prodep.poi.mongodb;

import java.util.List;

public interface EmployeeDAO {

	// this is for creating employee
	 public void create(Employee employee);

	 public void update(Employee employee);

	 public int deleteById(int id);

	 public Employee findById(int id);

	 public List<Employee> findAll();

	}
