package com.fullstack.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    @Size(min = 2, message = "Employee Name should be at least 2 characters")
    private String empName;

    @NotBlank(message = "Employee Address should not be null or Empty")
    private String empAddress;

    private double empSalary;

    @Range(min = 1000000000, max = 9999999999L, message = "Contact Number must be 10 digit")
    private long empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date empDOB;

    @Email(message = "Email Id Must be Valid")
    private String empEmailId;

    @Size(min = 4, message = "Password should be atleast 4 characters")
    private String empPassword;
}
