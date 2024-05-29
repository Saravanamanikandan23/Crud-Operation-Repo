package com.example.EmployeeSample.Controller;

import com.example.EmployeeSample.Model.EmployeeModel;
import com.example.EmployeeSample.Service.EmployeeService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@OpenAPIDefinition(info = @Info(title = "Curd Operation Repo " , version = "1.0.0"))
@RestController
@RequestMapping("api/ProductDetails")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiResponse(responseCode = "200",description = "Details Created")
    @ApiResponse(responseCode = "400",description = "Client Error")
    @ApiResponse(responseCode = "500",description = "Internal Server Error")
    @Operation(summary = "This Operation Used to Add New User")
    @PostMapping(value = "/Created")
    @ResponseStatus(HttpStatus.CREATED)
    public String createDetails(@RequestBody EmployeeModel employeeModel) {
        return employeeService.addDetails(employeeModel);
    }

    @Operation(summary = "This Operation Used to Update/Edit User")
    @PutMapping(value = "/update/{id}")
    public String updateDetails(@PathVariable Integer id, @RequestBody EmployeeModel employeeModel) {
        return employeeService.updateById(id, employeeModel);
    }

    @Operation(summary = "This Operation Used to Get All Users")
    @GetMapping(value = "/getAll")
    public List<EmployeeModel> getAll() {
        return employeeService.getAll();
    }

    @Operation(summary = "This Operation Used to Get Individual User By Using Id ")
    @GetMapping(value = "/getById/{id}")
    public Optional<EmployeeModel> getById(@PathVariable Integer id) {
        return employeeService.getById(id);
    }

    @Operation(summary = "This Operation Used to Delete Individual User By Using Id")
    @DeleteMapping(value = "/Delete/{id}")
    public String deleteDetails(@PathVariable Integer id) {
        return employeeService.deleteDetails(id);
    }

}
