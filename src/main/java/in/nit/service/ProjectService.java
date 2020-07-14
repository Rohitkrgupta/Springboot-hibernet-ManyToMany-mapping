package in.nit.service;

import java.util.List;

import in.nit.model.Project;

public interface ProjectService {
	
	 public  String  saveProject(Project p);
	 public  List<Project> findAllProjects();
	 public  Project findOneProject(Long id);
	 public  void deleteProject(Long id);
	 public  void updateProject(Project e);
	 public  boolean isProjectExist(Long id);

}
