package org.sansovo.demo.springmvc.chapter13.service;

import org.sansovo.demo.springmvc.chapter13.domain.Employee;

public interface EmployeeService {
    Employee getHighestPaidEmployee(int employeeCategory);
}
