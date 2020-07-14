package in.nit.service;

import java.util.List;

import in.nit.model.Employee;

public interface EmployeeService {

    public String  saveEmployee(Employee e);
    List<Employee> findAllEmployees();
    Employee findOneEmployee(Long id);
    void deleteEmployee(Long id);
    void updateEmployee(Employee e);
    boolean isEmployeeExist(Long id);

}
