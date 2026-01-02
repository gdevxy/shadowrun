package ch.gdevxy.shadowrun.location;

import java.time.LocalDateTime;

public record Location(
	Long id,
	String title,
	String type,
	String location,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
