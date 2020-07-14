package in.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nit.model.Project;

public interface ProjectRepository extends JpaRepository<Project,Long>{

}
