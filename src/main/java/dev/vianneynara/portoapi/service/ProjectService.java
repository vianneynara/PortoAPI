package dev.vianneynara.portoapi.service;

import dev.vianneynara.portoapi.model.Project;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface ProjectService {
	Project createProject(Project project);
	Project retrieveProject(Long id);
	Project updateProject(Long id, Project project);
	void deleteProject(Long id);
	Collection<Project> retrieveProjects();
}
