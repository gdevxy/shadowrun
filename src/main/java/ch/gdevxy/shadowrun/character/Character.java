package ch.gdevxy.shadowrun.character;

import java.time.LocalDateTime;

public record Character(
	Long id,
	String title,
	String race,
	String name,
	CharacterType type,
	String archetype,
	String status,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {
}
