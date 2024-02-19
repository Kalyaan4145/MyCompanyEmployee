package com.mycompany.myCompanyEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.mycompany.myCompanyEmployee.model.EmployeeDetails;

@SpringBootApplication
@EntityScan(basePackageClasses = { EmployeeDetails.class, Jsr310JpaConverters.class })
public class MyCompanyEmployeesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyCompanyEmployeesApplication.class, args);
		
		System.out.println("--------------My Company Employees..!");
	}

}
