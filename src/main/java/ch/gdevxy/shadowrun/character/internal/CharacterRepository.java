package ch.gdevxy.shadowrun.character.internal;

import ch.gdevxy.shadowrun.character.CharacterType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface CharacterRepository extends CrudRepository<CharacterEntity, Long> {
	List<CharacterEntity> findByType(CharacterType type);
}
