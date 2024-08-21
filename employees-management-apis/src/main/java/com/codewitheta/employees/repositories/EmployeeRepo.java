package com.codewitheta.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewitheta.employees.empolyee.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
}
