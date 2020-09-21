package com.project.employeesservice.controller;


import com.project.dto.PageableResponse;
import com.project.model.Employee;
import com.project.employeesservice.servives.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeesController {
    private final EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse<Employee> getAllEmployees(Pageable pageable) {
        return employeeService.getAllEmployee(pageable);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getAllEmployees(@PathVariable String id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@RequestBody Employee employee) {
        System.out.println(employee.toString());
        Employee employee1 = employeeService.addEmployee(employee);
        System.out.println(employee1);
        return employee1;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee patchEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.putEmployee(id, employee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee deleteEmployee(@PathVariable String id) {
        return employeeService.deleteEmployee(id);
    }
}
