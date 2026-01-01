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

@Table("campaign_scene_section_dialog")
@Data
@NoArgsConstructor
@AllArgsConstructor
class CampaignSceneSectionDialogEntity {

	@Id
	private Long id;

	@Column("scene_section_id")
	private Long sceneSectionId;

	@Column("character_id")
	private Long characterId;

	@Column("sequence")
	private Integer sequence;

	@Column("dialog")
	private String dialog;

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
