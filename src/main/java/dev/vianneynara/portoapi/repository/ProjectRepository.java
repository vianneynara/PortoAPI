package dev.vianneynara.portoapi.repository;

import dev.vianneynara.portoapi.model.Project;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	/**
	 * Queries a project by its exact name.
	 *
	 * @return Optional {@link Project} with the given name.
	 * */
	Optional<Project> findByName(@NotBlank String name);

	/**
	 * Queries projects that contains the given name.
	 *
	 * @return Optional {@link Project} that contains the given name.
	 * */
	Optional<Project> findByNameContaining(@NotBlank String name);

	/**
	 * Queries projects that contains the given tag.
	 *
	 * @return {@link Collection} of {@link Project} that contains the given tag.
	 * */
	Collection<Project> findByTagsContainsIgnoreCase(@NotBlank String tag);

	/**
	 * Queries projects that matches the passed id (owner id).
	 *
	 * @return {@link Collection} of {@link Project} that contains the given owner id.
	 * */
	Collection<Project> getProjectsByOwnerId(Long id);
}
