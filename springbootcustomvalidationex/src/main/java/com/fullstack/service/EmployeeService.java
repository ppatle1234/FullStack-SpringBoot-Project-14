package com.fullstack.service;

import com.fullstack.entity.Employee;
import com.fullstack.exception.RecordNotFoundException;
import com.fullstack.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(long empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(long empId, Employee employee) {

        Employee employee1 = findById(empId).orElseThrow(()-> new RecordNotFoundException("Employee #ID Does Not Exist"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpPassword(employee.getEmpPassword());

        return employeeRepository.save(employee1);
    }

    @Override
    public void deleteById(long empId) {
         employeeRepository.deleteById(empId);
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
