package dev.vianneynara.portoapi.controller;

import dev.vianneynara.portoapi.exceptions.ResourceNotFoundException;
import dev.vianneynara.portoapi.model.Project;
import dev.vianneynara.portoapi.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

	private final ProjectService projectService;

	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}

	@PostMapping
	public ResponseEntity<Project> createProject(@RequestBody Project project) {
		Project saved = projectService.createProject(project);
		return ResponseEntity.ok(saved);
	}

	@GetMapping("{id}")
	public ResponseEntity<Project> retrieveProject(@PathVariable Long id) {
		Project project = projectService.retrieveProject(id);
		return project != null
			? ResponseEntity.ok(project)
			: ResponseEntity.notFound().build();
	}

	@GetMapping
	public ResponseEntity<Collection<Project>> retrieveProjects() {
		Collection<Project> projects = projectService.retrieveProjects();
		return ResponseEntity.ok(projects);
	}

	@PutMapping("{id}")
	public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
		if (project == null) {
			return ResponseEntity.badRequest().build();
		}

		try {
			Project existingProject = projectService.retrieveProject(id);
			if (existingProject == null) return ResponseEntity.notFound().build();

			projectService.updateProject(id, project);
			Project updatedProject = projectService.retrieveProject(id);

			return ResponseEntity.ok(updatedProject);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
		try {
			Project existingProject = projectService.retrieveProject(id);
			if (existingProject == null) return ResponseEntity.notFound().build();

			projectService.deleteProject(id);

			return ResponseEntity.ok().build();
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
