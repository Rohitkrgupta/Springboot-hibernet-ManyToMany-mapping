package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nit.model.Employee;
import in.nit.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping("/create")
	public String saveEmployee(@RequestBody Employee employee)
	{
		 return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/details/{id}")
	
	public Employee getOneEmployee(@PathVariable("id") Long id) {
	
		
	   return  employeeService.findOneEmployee(id);
	}
	
	@GetMapping("/all")
	public List<Employee> getAllEmployee()
	{
		return employeeService.findAllEmployees();
	}

	
	@PutMapping("/update")
	public ResponseEntity<String> updatEmployee(@RequestBody Employee employee) {
		ResponseEntity<String> resp=null;
		long id = employee.getEmpId();
		
		if(employeeService.isEmployeeExist(id))
		{
			employeeService.updateEmployee(employee);
			resp = new ResponseEntity<String>("Employee Updated!", HttpStatus.OK);
		}
		else {
			resp = new ResponseEntity<String>("Student Not exist:"+id, HttpStatus.BAD_REQUEST);
		}
	     
	     return resp;
	    
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
		
		ResponseEntity<String> resp=null;
		
		if(employeeService.isEmployeeExist(id))
		{
			employeeService.deleteEmployee(id);
			resp = new ResponseEntity<String>("Employee deleted",HttpStatus.OK);
		}
		else {
			
			resp=new ResponseEntity<String>("Employee Not exist",HttpStatus.BAD_REQUEST);
		}
			
		return resp;
	 }
}
