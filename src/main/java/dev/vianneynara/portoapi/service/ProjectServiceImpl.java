package dev.vianneynara.portoapi.service;

import dev.vianneynara.portoapi.exceptions.ResourceNotFoundException;
import dev.vianneynara.portoapi.model.Project;
import dev.vianneynara.portoapi.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;

	@Autowired
	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public Project createProject(Project project) {
		System.out.println("ProjectServiceImpl.createProject: " + project);
		return projectRepository.save(project);
	}

	@Override
	public Project retrieveProject(Long id) {
		return projectRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Project with id '" + id + "' could not be found!"));
	}

	@Override
	public void updateProject(Long id, Project project) {
		Project p = projectRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Project with id '" + id + "' could not be found!"));
		p.setName(project.getName());
		p.setDescription(project.getDescription());
		p.setImageUrl(project.getImageUrl());
		p.setTags(project.getTags());
		p.setProjectUrl(project.getProjectUrl());
		projectRepository.save(p);
	}

	@Override
	public void deleteProject(Long id) {
		projectRepository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Project with id '" + id + "' could not be found!"));
		projectRepository.deleteById(id);
	}

	@Override
	public Collection<Project> retrieveProjects() {
		return projectRepository.findAll();
	}
}
