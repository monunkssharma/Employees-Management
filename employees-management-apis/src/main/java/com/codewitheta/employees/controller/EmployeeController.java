package com.codewitheta.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewitheta.employees.payloads.ApiResponse;
import com.codewitheta.employees.payloads.EmployeeDto;
import com.codewitheta.employees.service.EmployeeService;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
    private EmployeeService employeeService;
	
	@PostMapping("/")
	public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto createEmployee=this.employeeService.createEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(createEmployee,HttpStatus.CREATED);
	}

	@PutMapping("/{empId}")
	public ResponseEntity<EmployeeDto>updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Integer empId){
		EmployeeDto updateEmployee=this.employeeService.updateEmployee(employeeDto, empId);
		return new ResponseEntity<EmployeeDto>(updateEmployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/{empId}")
	public ResponseEntity<ApiResponse>deleteEmployee(@PathVariable Integer empId){
		this.employeeService.deleteEmployee(empId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("employee is deleted successfully!!", true),HttpStatus.OK);
	}
	
	@GetMapping("/{empId}")
	public ResponseEntity<EmployeeDto>getEmployee(@PathVariable Integer empId){
		EmployeeDto employeeDto=this.employeeService.getEmployee(empId);
		return new ResponseEntity<EmployeeDto>(employeeDto,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeDto>>getEmployee(){
		List<EmployeeDto> employees=this.employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
}
