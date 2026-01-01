package ch.gdevxy.shadowrun.session;

import java.time.LocalDateTime;

public record Session(
	Long id,
	Long campaignId,
	Integer sessionNumber,
	String log,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
