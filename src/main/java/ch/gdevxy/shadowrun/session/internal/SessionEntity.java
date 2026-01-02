package ch.gdevxy.shadowrun.session.internal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table("session")
@Data
@NoArgsConstructor
@AllArgsConstructor
class SessionEntity {

	@Id
	private Long id;

	@Column("campaign_id")
	private Long campaignId;

	@Column("session_number")
	private Integer sessionNumber;

	@Column("session_date")
	private LocalDate sessionDate;

	@Column("log")
	private String log;

	@CreatedDate
	@Column("created_at")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column("updated_at")
	private LocalDateTime updatedAt;
}
