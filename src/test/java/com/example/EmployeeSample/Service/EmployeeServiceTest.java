package com.example.EmployeeSample.Service;

import com.example.EmployeeSample.Model.EmployeeModel;
import com.example.EmployeeSample.Repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testAddDetails() {
        EmployeeModel employeeModel = new EmployeeModel();
        String expectedResult = "Details created";
        when(employeeRepo.save(employeeModel)).thenReturn(employeeModel);
        String result = employeeService.addDetails(employeeModel);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testUpdateById() {
        int id = 123;
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setEmployeeId(id);
        Optional<EmployeeModel> optionalEmployeeModel = Optional.of(employeeModel);
        when(employeeRepo.findById(id)).thenReturn(optionalEmployeeModel);
        String expectedResult = "Details Updated";
        String result = employeeService.updateById(id, employeeModel);
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetAll() {
        List<EmployeeModel> employees = new ArrayList<>();
        when(employeeRepo.findAll()).thenReturn(employees);
        List<EmployeeModel> result = employeeService.getAll();
        assertEquals(employees, result);
    }

    @Test
    public void testGetById() {
        int id = 123;
        EmployeeModel employeeModel = new EmployeeModel();
        Optional<EmployeeModel> optionalEmployeeModel = Optional.of(employeeModel);
        when(employeeRepo.findById(id)).thenReturn(optionalEmployeeModel);
        Optional<EmployeeModel> result = employeeService.getById(id);
        assertEquals(optionalEmployeeModel, result);
    }

    @Test
    public void testDeleteDetails() {
        int id = 123;
        String expectedResult = "Details Deleted";
        employeeService.deleteDetails(id);
        verify(employeeRepo, times(1)).deleteById(id);
    }

}
