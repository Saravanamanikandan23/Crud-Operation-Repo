package com.example.EmployeeSample.Service;

import com.example.EmployeeSample.Model.EmployeeModel;
import com.example.EmployeeSample.Repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public String addDetails(EmployeeModel employeeModel) {
        employeeRepo.save(employeeModel);
        return "Details created";
    }

    public String updateById(Integer id, EmployeeModel employeeModel) {
        EmployeeModel employeeModel1 = employeeRepo.findById(id).get();
        employeeModel1.setEmployeeId(employeeModel.getEmployeeId());
        employeeModel1.setEmployeeFirstName(employeeModel.getEmployeeFirstName());
        employeeModel1.setEmployeeLastName(employeeModel.getEmployeeLastName());
        employeeModel1.setEmployeeEmail(employeeModel.getEmployeeEmail());
        employeeModel1.setEmployeeContact(employeeModel.getEmployeeContact());
        employeeRepo.save(employeeModel1);
        return "Details Updated";
    }

    public List<EmployeeModel> getAll() {
        return employeeRepo.findAll();
    }

    public Optional<EmployeeModel> getById(Integer id) {
        Optional<EmployeeModel> eCommerceModel = employeeRepo.findById(id);
        return employeeRepo.findById(id);
    }

    public String deleteDetails(Integer id) {
        employeeRepo.deleteById(id);
        return "Details Deleted";
    }

}
