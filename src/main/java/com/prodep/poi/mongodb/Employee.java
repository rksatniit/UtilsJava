package com.prodep.poi.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*
* Employee POJO class
*/

@Document
public class Employee {
	@Id
	private int id;

	private String firstName;

	private String lastName;

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		StringBuilder employee = new StringBuilder();
		employee.append("Employee Id:-").append(this.getId()).append("\n");
		employee.append("First Name:-").append(this.getFirstName())
		.append("\n");
		employee.append("Last Name:-").append(this.getLastName());
		employee.append("\n");
		return employee.toString();
	}

}
