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

		var entity = characterRepository.findById(model.id()).orElseGet(CharacterEntity::new);

		entity.setGender(model.gender());
		entity.setMetatype(model.metatype());
		entity.setAlias(model.alias());
		entity.setName(model.name());
		entity.setType(model.type());
		entity.setArchetype(model.archetype());
		entity.setStatus(model.status());

		return toModel(characterRepository.save(entity));
	}

	private Character toModel(CharacterEntity entity) {
		return new Character(
			entity.getId(),
			entity.getGender(),
			entity.getMetatype(),
			entity.getAlias(),
			entity.getName(),
			entity.getType(),
			entity.getArchetype(),
			entity.getStatus(),
			entity.getCreatedAt(),
			entity.getUpdatedAt()
		);
	}
}
