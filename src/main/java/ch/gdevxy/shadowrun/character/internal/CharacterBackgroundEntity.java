package ch.gdevxy.shadowrun.character.internal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("character_background")
@Data
@NoArgsConstructor
@AllArgsConstructor
class CharacterBackgroundEntity {

	@Id
	private Long id;

	@Column("character_id")
	private Long characterId;

	@Column("background")
	private String background;

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
