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

@Table("campaign")
@Data
@NoArgsConstructor
@AllArgsConstructor
class CampaignEntity {

	@Id
	private Long id;

	@Column("title")
	private String title;

	@Column("description")
	private String description;

	@Column("status")
	private String status;

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
