package com.codewitheta.employees.service;

import java.util.List;
import com.codewitheta.employees.payloads.EmployeeDto;


public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId);
	void deleteEmployee(Integer employeeId);
	EmployeeDto getEmployee(Integer employeeId);
	List<EmployeeDto>getAllEmployees();
}
