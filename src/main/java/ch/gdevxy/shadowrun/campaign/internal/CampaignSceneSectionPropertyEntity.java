package ch.gdevxy.shadowrun.campaign.internal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("campaign_scene_section_property")
@Data
@NoArgsConstructor
@AllArgsConstructor
class CampaignSceneSectionPropertyEntity {

	@Id
	private Long id;

	@Column("scene_id")
	private Long sceneId;

	@Column("sequence")
	private Integer sequence;

	@Column("key")
	private String key;

	@Column("type")
	private String type;

	@Column("value")
	private String value; // JSONB stored as String

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
