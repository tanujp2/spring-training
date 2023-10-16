package live.tanujdevops.rest.service;

import live.tanujdevops.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
