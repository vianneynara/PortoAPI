package dev.vianneynara.portoapi.controller;

import dev.vianneynara.portoapi.exceptions.ResourceNotFoundException;
import dev.vianneynara.portoapi.model.Project;
import dev.vianneynara.portoapi.response.ApiResponse;
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
	public ResponseEntity<ApiResponse<Project>> createProject(@RequestBody Project project) {
		if (project == null) {
			return ResponseEntity.badRequest().build();
		}

		Project createdProject = projectService.createProject(project);
		return ResponseEntity.ok(new ApiResponse<>(createdProject));
	}

	@GetMapping("{id}")
	public ResponseEntity<ApiResponse<Project>> retrieveProject(@PathVariable Long id) {
		try {
			Project project = projectService.retrieveProject(id);
			return ResponseEntity.ok(new ApiResponse<>(project));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public ResponseEntity<ApiResponse<Collection<Project>>> retrieveProjects() {
		Collection<Project> projects = projectService.retrieveProjects();
		return ResponseEntity.ok(new ApiResponse<>(projects));
	}

	@PutMapping("{id}")
	public ResponseEntity<ApiResponse<Project>> updateProject(@PathVariable Long id, @RequestBody Project project) {
		if (projectService.retrieveProject(id) == null || project == null) {
			return ResponseEntity.badRequest().build();
		}

		try {
			Project p = projectService.updateProject(id, project);
			return ResponseEntity.ok(new ApiResponse<>(p));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("{id}")
	public ResponseEntity<ApiResponse<Project>> deleteProject(@PathVariable Long id) {
		try {
			Project project = projectService.retrieveProject(id);
			projectService.deleteProject(id);
			return ResponseEntity.ok(new ApiResponse<>(project));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
