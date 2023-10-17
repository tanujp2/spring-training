package live.tanujdevops.rest.controller;

import jakarta.annotation.PostConstruct;
import live.tanujdevops.rest.entity.Employee;
import live.tanujdevops.rest.exception.EmployeeNotFoundException;
import live.tanujdevops.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Object getEmployee(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0); // it will force the employee to be added, instead of update
        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        employeeService.deleteById(id);
        return "Deleted employee, id = " + id;
    }
}
