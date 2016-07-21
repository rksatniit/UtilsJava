package com.prodep.poi.mongodb;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class EmployeeDataBroker {

	
	public List<Employee> findAllEmployees() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-beans.xml");
		EmployeeDAO employeeDao = (EmployeeDAO) context.getBean("employeeDao");
		return employeeDao.findAll(); // to get all employees
	}
}
