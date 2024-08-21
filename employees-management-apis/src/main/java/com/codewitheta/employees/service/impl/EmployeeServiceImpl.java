package com.codewitheta.employees.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewitheta.employees.empolyee.Employee;
import com.codewitheta.employees.exception.ResourceNotFoundException;
import com.codewitheta.employees.payloads.EmployeeDto;
import com.codewitheta.employees.repositories.EmployeeRepo;
import com.codewitheta.employees.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee emp=this.modelMapper.map(employeeDto, Employee.class);
		Employee addedEmp=this.employeeRepo.save(emp);
		return this.modelMapper.map(addedEmp, EmployeeDto.class);
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, Integer employeeId) {
		Employee emp=this.employeeRepo.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		emp.setName(employeeDto.getName());
		emp.setEmail(employeeDto.getEmail());
		emp.setPassword(employeeDto.getPassword());
		emp.setSalary(employeeDto.getSalary());
		emp.setLocation(employeeDto.getLocation());
		emp.setGrade(employeeDto.getGrade());
		emp.setDesignation(employeeDto.getDesignation());
		emp.setAbout(employeeDto.getAbout());
		Employee updateemp=this.employeeRepo.save(emp);
		return this.modelMapper.map(updateemp, EmployeeDto.class);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee emp=this.employeeRepo.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		this.employeeRepo.delete(emp);

	}

	@Override
	public EmployeeDto getEmployee(Integer employeeId) {
		Employee emp=this.employeeRepo.findById(employeeId)
				.orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", employeeId));
		return this.modelMapper.map(emp, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees=this.employeeRepo.findAll();
		List<EmployeeDto> empDtos=employees.stream().map((emp)-> this.modelMapper.map(emp, EmployeeDto.class)).collect(Collectors.toList());
		return empDtos;
	}

}
