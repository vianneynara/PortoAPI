package dev.vianneynara.portoapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String description;
	private String imageUrl;
	@ElementCollection
	private List<String> tags;
	private String projectUrl;

	private Long ownerId;

	@Override
	public String toString() {
		return "Project{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", tags=" + tags +
				", projectUrl='" + projectUrl + '\'' +
				", ownerId=" + ownerId +
				'}';
	}
}
