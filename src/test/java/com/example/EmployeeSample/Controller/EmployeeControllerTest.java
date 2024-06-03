package com.example.EmployeeSample.Controller;

import com.example.EmployeeSample.Model.EmployeeModel;
import com.example.EmployeeSample.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateDetails() {
        EmployeeModel employeeModel = new EmployeeModel();
        when(employeeService.addDetails(employeeModel)).thenReturn("Details added successfully");
        String result = employeeController.createDetails(employeeModel);
        assertEquals("Details added successfully", result);
    }

    @Test
    public void testUpdateDetails() {
        EmployeeModel employeeModel = new EmployeeModel();
        int id = 123;
        when(employeeService.updateById(id, employeeModel)).thenReturn("Details updated successfully");
        String result = employeeController.updateDetails(id, employeeModel);
        assertEquals("Details updated successfully", result);
    }

    @Test
    public void testGetAll() {
        List<EmployeeModel> employees = new ArrayList<>();
        when(employeeService.getAll()).thenReturn(employees);
        List<EmployeeModel> result = employeeController.getAll();
        assertEquals(employees, result);
    }

    @Test
    public void testGetById() {
        int id = 123;
        Optional<EmployeeModel> employeeModel = Optional.of(new EmployeeModel());
        when(employeeService.getById(id)).thenReturn(employeeModel);
        Optional<EmployeeModel> result = employeeController.getById(id);
        assertEquals(employeeModel, result);
    }

    @Test
    public void testDeleteDetails() {
        int id = 123;
        when(employeeService.deleteDetails(id)).thenReturn("Details deleted successfully");
        String result = employeeController.deleteDetails(id);
        assertEquals("Details deleted successfully", result);
    }

}
