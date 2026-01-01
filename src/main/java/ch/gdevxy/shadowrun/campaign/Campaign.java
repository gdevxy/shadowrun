package ch.gdevxy.shadowrun.campaign;

import java.time.LocalDateTime;

public record Campaign(
	Long id,
	String title,
	String description,
	String status,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
