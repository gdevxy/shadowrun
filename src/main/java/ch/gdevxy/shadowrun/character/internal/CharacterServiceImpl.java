package ch.gdevxy.shadowrun.character.internal;

import ch.gdevxy.shadowrun.character.Character;
import ch.gdevxy.shadowrun.character.CharacterService;
import ch.gdevxy.shadowrun.character.CharacterType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
class CharacterServiceImpl implements CharacterService {

	private final CharacterRepository characterRepository;

	@Override
	public List<Character> findAllCharacters() {
		return StreamSupport.stream(characterRepository.findAll().spliterator(), false)
			.map(this::toModel)
			.toList();
	}

	@Override
	public List<Character> findPlayerCharacters() {
		return characterRepository.findByType(CharacterType.PLAYER).stream()
			.map(this::toModel)
			.toList();
	}

	@Override
	public List<Character> findNPCCharacters() {
		return characterRepository.findByType(CharacterType.NPC).stream()
			.map(this::toModel)
			.toList();
	}

	@Override
	public Character save(Character model) {
		CharacterEntity entity = new CharacterEntity(
			model.id(),
			model.title(),
			model.race(),
			model.name(),
			model.type(),
			model.archetype(),
			model.status(),
			model.createdAt(),
			model.updatedAt()
		);
		CharacterEntity saved = characterRepository.save(entity);
		return toModel(saved);
	}

	private Character toModel(CharacterEntity entity) {
		return new Character(
			entity.getId(),
			entity.getTitle(),
			entity.getRace(),
			entity.getName(),
			entity.getType(),
			entity.getArchetype(),
			entity.getStatus(),
			entity.getCreatedAt(),
			entity.getUpdatedAt()
		);
	}
}
