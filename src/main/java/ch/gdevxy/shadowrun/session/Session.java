package ch.gdevxy.shadowrun.session;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Session(
	Long id,
	Long campaignId,
	Integer sessionNumber,
	LocalDate sessionDate,
	String log,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
