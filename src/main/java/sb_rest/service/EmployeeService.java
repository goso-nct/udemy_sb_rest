package sb_rest.service;

import sb_rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    void saveEmployee(Employee emp);
    Employee getEmployee(int id);
    void deleteEmployee(int id);
}
