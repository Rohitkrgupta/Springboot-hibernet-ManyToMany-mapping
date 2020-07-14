package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
