package ch.gdevxy.shadowrun.character.internal;

import ch.gdevxy.shadowrun.character.CharacterType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("character")
@Data
@NoArgsConstructor
@AllArgsConstructor
class CharacterEntity {

	@Id
	private Long id;

	@Column("title")
	private String title;

	@Column("race")
	private String race;

	@Column("name")
	private String name;

	@Column("type")
	private CharacterType type;

	@Column("archetype")
	private String archetype;

	@Column("status")
	private String status;

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
