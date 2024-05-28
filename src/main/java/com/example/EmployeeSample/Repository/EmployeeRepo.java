package com.example.EmployeeSample.Repository;


import com.example.EmployeeSample.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<EmployeeModel, Integer> {

}
