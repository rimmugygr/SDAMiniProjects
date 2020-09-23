package com.project.employeesservice.servives;

import com.project.dto.PageableResponse;
import com.project.employeesservice.exeptions.InvalidData;
import com.project.employeesservice.exeptions.ResourcesNotFoundException;
import com.project.employeesservice.repository.EmployeeRepository;
import com.project.model.Address;
import com.project.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public PageableResponse<Employee> getAllEmployee(Pageable pageable) {
        Page<Employee> all = employeeRepository.findAll(pageable);
        return PageableResponse.<Employee>builder()
                .pageNumber(all.getNumber())
                .content(all.getContent())
                .size(all.getSize())
                .totalPages(all.getTotalPages())
                .build();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException(String.format("Employee on id %s not found", id)));
    }


    public Employee addEmployee(Employee employee) {
        if(employee.getId() != null && employeeRepository.existsById(employee.getId())) {
            throw new InvalidData("Employee id is not valid");
        }
        if(employee.getAddress() == null) {
            employee.setAddress(new Address());
        }
        employee.setModifiedDate(LocalDateTime.now());
        return employeeRepository.save(employee);
    }

    public Employee putEmployee(String id, Employee employee) {
        if(!id.equals(employee.getId())) {
            throw new InvalidData("Employee id not match");
        }
        if(employeeRepository.existsById(id)) {
            employee.setModifiedDate(LocalDateTime.now());
            return employeeRepository.save(employee);
        } else throw new ResourcesNotFoundException(String.format("Employee on id %s not found", id));
    }

    public Employee deleteEmployee(String id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.deleteById(id);
        employee.setModifiedDate(LocalDateTime.now());
        return employee;
    }
}
