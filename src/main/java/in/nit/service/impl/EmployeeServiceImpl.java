package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Employee;
import in.nit.repository.EmployeeRepository;
import in.nit.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements  EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public String saveEmployee(Employee e) {
		long id = employeeRepository.save(e).getEmpId();
		return "Employee Data is saved with :"+ id;
	}

	@Override
	public List<Employee> findAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findOneEmployee(Long  id) {
		Employee e=null;
		Optional<Employee> opt=employeeRepository.findById(id);
		if(opt.isPresent()) {
			e=opt.get();
		}
		return e;
		
	}

	@Override
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee e) {
		employeeRepository.save(e);
		
	}

	@Override
	public boolean isEmployeeExist(Long id) {
		
		return employeeRepository.existsById(id);
	}

}
