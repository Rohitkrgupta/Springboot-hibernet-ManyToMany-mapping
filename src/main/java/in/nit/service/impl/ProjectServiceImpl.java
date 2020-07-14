package in.nit.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.model.Project;
import in.nit.repository.ProjectRepository;
import in.nit.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@Override
	public String saveProject(Project p) {
		
         long id = projectRepository.save(p).getProjectId();
		return "Project Data saved with id:"+id;
	}

	@Override
	public List<Project> findAllProjects() {
		
		return projectRepository.findAll();
	}

	@Override
	public Project findOneProject(Long id) {
		Project p = null;
	    Optional<Project> opt = projectRepository.findById(id);
	    if(opt.isPresent())
	    {
	    	p = opt.get();
	    }
		return p;
	}

	@Override
	public void deleteProject(Long id) {
		
		projectRepository.deleteById(id);
		
	}

	@Override
	public void updateProject(Project p) {
		
		projectRepository.save(p);
		
	}

	@Override
	public boolean isProjectExist(Long id) {
		
		return projectRepository.existsById(id);
	}

	
}
