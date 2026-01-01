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

@Table("campaign_scene")
@Data
@NoArgsConstructor
@AllArgsConstructor
class CampaignSceneEntity {

	@Id
	private Long id;

	@Column("campaign_id")
	private Long campaignId;

	@Column("sequence")
	private Integer sequence;

	@Column("title")
	private String title;

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
