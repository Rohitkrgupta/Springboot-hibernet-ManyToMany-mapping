package in.nit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;


import in.nit.model.Employee;
import in.nit.model.Project;
import in.nit.repository.EmployeeRepository;


public class ManyToManyMappingRunner implements CommandLineRunner {

	

    @Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		//create project object
		Project project = new Project();
		project.setTitle("Employee Management System");
		
		// create project  object-1
		Project project1  = new Project();
		project1.setTitle("Employee Data Management");
		
		
		//Create employee object 
		Employee employee = new Employee();
		employee.setEmpName("ROHIT");
		employee.setEmpEmail("guptarohit5744@gmail.com");
		
		
		//Employee can work on two project, adding reference of project in employee
		employee.getProjects().add(project);
		employee.getProjects().add(project1);
		
		employeeRepository.save(employee);
		
	}

}
