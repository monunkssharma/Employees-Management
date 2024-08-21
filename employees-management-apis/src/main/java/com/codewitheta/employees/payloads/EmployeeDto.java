package com.codewitheta.employees.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class EmployeeDto {
	
	private Integer id;
	private String name;
	private Double salary;
	private String location;
	private String grade;
	private String designation;
	private String email;
	private String password;
	private String about;
}
