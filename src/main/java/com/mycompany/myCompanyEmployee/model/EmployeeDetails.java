package com.mycompany.myCompanyEmployee.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="myemployee_19Feb2024")
public class EmployeeDetails {
	
	
	//Fields(All fields are mandatory):
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_Id")
    private long employeeId;
	
	//FirstName
	@Column(name="firstName", nullable = false)
	 private String firstName;

	//LastName
	@Column(name="lastName", nullable = false)
	 private String lastName;	
	
	//DOJ
	@Column(name = "doj", nullable = false)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime doj;	
	
	//Email
	@Column(name="e_mail", nullable = false)
	 private String email;	

	//PhoneNumber  //(May have multiple phone numbers)
	@Column(name="phone_Number", nullable = false)
	 private List<String> phoneNumbers;
	// private long	phoneNumber; 

	//Salary(per month)
	@Column(name="salary", nullable = false)
	 private double salary;
	
	@Column(name="yearlySalary", nullable = true)
	private double yearlySalary;
	
	@Column(name="taxAmount", nullable = true)
    private double taxAmount;
	
	@Column(name="cessAmount", nullable = true)
    private double cessAmount;
	 
	 
	public EmployeeDetails() {
		super();
	}

	public EmployeeDetails(long employeeId, String firstName, String lastName, LocalDateTime doj, String email,
			List<String> phoneNumbers, double salary, double yearlySalary, double taxAmount, double cessAmount) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doj = doj;
		this.email = email;
		this.phoneNumbers = phoneNumbers;
		this.salary = salary;
		this.yearlySalary = yearlySalary;
		this.taxAmount = taxAmount;
		this.cessAmount = cessAmount;
	}

	//Generate Getter and Setter methods
	
	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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

	public LocalDateTime getDoj() {
		return doj;
	}

	public void setDoj(LocalDateTime doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getCessAmount() {
		return cessAmount;
	}

	public void setCessAmount(double cessAmount) {
		this.cessAmount = cessAmount;
	}

	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ","
				+ " firstName=" + firstName + ", "
				+ "lastName=" + lastName
				+ ", doj=" + doj + ", "
				+ "email=" + email + ", "
				+ "phoneNumbers=" + phoneNumbers + ", "
				+ "salary=" + salary
				+ ", yearlySalary=" + yearlySalary + ", "
				+ "taxAmount=" + taxAmount + ", "
				+ "cessAmount=" + cessAmount + "]";
	}

	
	


}
