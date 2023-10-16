package live.tanujdevops.rest.dao;

import live.tanujdevops.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
