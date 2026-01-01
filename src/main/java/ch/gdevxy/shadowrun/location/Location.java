package ch.gdevxy.shadowrun.location;

import java.time.LocalDateTime;

public record Location(
	Long id,
	String title,
	String body,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
