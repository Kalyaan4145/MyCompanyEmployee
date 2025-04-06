package com.mycompany.myCompanyEmployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myCompanyEmployee.model.EmployeeDetails;
import com.mycompany.myCompanyEmployee.repository.MyEmployeeRepository;
import com.mycompany.myCompanyEmployee.service.TaxCalculationService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeDetailsController {

	@Autowired
	private MyEmployeeRepository myEmployeeRepository;


	@Autowired
	private TaxCalculationService taxCalculationService;

	@GetMapping("/test")
	public String testData() {
		return "EmployeeDetailsController........!";
	}

	@GetMapping("/salary/tax-deduction")
	public List<EmployeeDetails> getEmployeeSalaryById() {
		List<EmployeeDetails> employeeDetailsForSalary = myEmployeeRepository.findAll();

		employeeDetailsForSalary.forEach(employee -> {
			// Displaying each employee's details
			taxCalculationService.calculateTax(employee.getSalary());
		});

		return employeeDetailsForSalary ;
	}


	@PostMapping("/addEmployee")
	public EmployeeDetails createEmployeesList(@RequestBody EmployeeDetails employee) {

		employee.setYearlySalary((employee.getSalary()*12));

		employee.setTaxAmount(taxCalculationService.calculateTax(employee.getSalary()));

		employee.setCessAmount(taxCalculationService.calculateCessValueOnly(employee.getTaxAmount()));

		EmployeeDetails createEmployee = myEmployeeRepository.save(employee);

		return createEmployee;
	}


	@RequestMapping(method = RequestMethod.POST, value="/addEmployee1", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDetails>
	createEvent(@RequestBody EmployeeDetails event) {

		return new
				ResponseEntity<>(myEmployeeRepository.save(event), HttpStatus.CREATED); }

}
