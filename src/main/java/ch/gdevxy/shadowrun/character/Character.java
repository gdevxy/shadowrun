package ch.gdevxy.shadowrun.character;

import java.time.LocalDateTime;

public record Character(
	Long id,
	Gender gender,
	String metatype,
	String alias,
	String name,
	CharacterType type,
	String archetype,
	CharacterStatus status,
	LocalDateTime createdAt,
	LocalDateTime updatedAt
) {

	public boolean active() {
		return status == CharacterStatus.ALIVE;
	}

}
