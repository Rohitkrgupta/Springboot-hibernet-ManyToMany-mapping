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

import in.nit.model.Project;
import in.nit.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectRestController {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/create")
	public String saveProject(@RequestBody Project project)
	{
		return projectService.saveProject(project);
	}
	
	@GetMapping("/all")
	public List<Project> getAllProject()
	{
		return projectService.findAllProjects();
	}
	
	@GetMapping("/details/{id}")
	public Project getOneProject(@PathVariable("id") long id)
	{
		return projectService.findOneProject(id);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updatProject(@RequestBody Project project) {
		ResponseEntity<String> resp=null;
		long id = project.getProjectId();
		
		if(projectService.isProjectExist(id))
		{
			projectService.updateProject(project);
			resp = new ResponseEntity<String>("Employee Updated!", HttpStatus.OK);
		}
		else {
			resp = new ResponseEntity<String>("Student Not exist:"+id, HttpStatus.BAD_REQUEST);
		}
	     
	     return resp;
	    
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable("id") Long id) {
		
		ResponseEntity<String> resp=null;
		
		if(projectService.isProjectExist(id))
		{
			projectService.deleteProject(id);
			resp = new ResponseEntity<String>("Project deleted",HttpStatus.OK);
		}
		else {
			
			resp=new ResponseEntity<String>("Project Not exist",HttpStatus.BAD_REQUEST);
		}
			
		return resp;
	 }

}
