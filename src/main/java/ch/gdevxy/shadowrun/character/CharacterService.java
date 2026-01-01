package ch.gdevxy.shadowrun.character;

import java.util.List;

public interface CharacterService {
	List<Character> findAllCharacters();
	List<Character> findPlayerCharacters();
	List<Character> findNPCCharacters();
	Character save(Character character);
}
