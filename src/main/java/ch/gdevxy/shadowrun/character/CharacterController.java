package ch.gdevxy.shadowrun.character;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personnel")
@RequiredArgsConstructor
public class CharacterController {

	private final CharacterService characterService;

	@GetMapping
	public String personnel(Model model) {
		var players = characterService.findPlayerCharacters();
		var npcs = characterService.findNPCCharacters();

		model.addAttribute("pageTitle", "Personnel Database");
		model.addAttribute("currentPage", "personnel");
		model.addAttribute("playerCharacters", players);
		model.addAttribute("npcCharacters", npcs);
		model.addAttribute("playerCount", players.size());
		model.addAttribute("npcCount", npcs.size());
		return "personnel";
	}
}
