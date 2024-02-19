package com.mycompany.myCompanyEmployee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.myCompanyEmployee.model.EmployeeDetails;

@Repository
public interface MyEmployeeRepository extends JpaRepository<EmployeeDetails, Long>{

}

