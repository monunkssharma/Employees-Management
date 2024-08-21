package com.codewitheta.employees.empolyee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="employees")
@Getter
@Setter
@NoArgsConstructor


public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Integer id;
	
	@Column(name="Employees_Name", nullable=false)
	private String name;
	
	@Column(name="Employees_sal",nullable=false)
	private Double salary;
	
	@Column(name="ETAWork_Loction", nullable=false)
	private String location;
	private String grade;
	
	private String Designation;
	
	@Column(name="ETA_EmailId", nullable=false)
	private String email;
	
	private String password;
	
	private String about;
	
}
