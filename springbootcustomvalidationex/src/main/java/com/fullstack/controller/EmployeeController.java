package com.fullstack.controller;

import com.fullstack.entity.Employee;
import com.fullstack.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {

    private final IEmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> saveData(@Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/findbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable long empId){
        return new ResponseEntity<>(employeeService.findById(empId), HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable long empId, @Valid @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.update(empId, employee), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid")
    public ResponseEntity<String> deleteById(@PathVariable long empId){
        employeeService.deleteById(empId);
        return new ResponseEntity<>("Data Deleted Successfully.", HttpStatus.OK);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        employeeService.deleteAll();
        return new ResponseEntity<>("All Data Deleted Successfully", HttpStatus.OK);
    }
}
