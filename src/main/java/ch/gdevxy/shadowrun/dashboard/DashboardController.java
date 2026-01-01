package ch.gdevxy.shadowrun.dashboard;

import ch.gdevxy.shadowrun.campaign.CampaignService;
import ch.gdevxy.shadowrun.character.CharacterService;
import ch.gdevxy.shadowrun.location.LocationService;
import ch.gdevxy.shadowrun.session.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {

	private final CampaignService campaignService;
	private final CharacterService characterService;
	private final SessionService sessionService;
	private final LocationService locationService;

	@GetMapping("/")
	public String dashboard(Model model) {
		var activeCampaign = campaignService.findActiveCampaign();
		var playerCharacters = characterService.findPlayerCharacters();
		var npcCharacters = characterService.findNPCCharacters();
		var locations = locationService.findAllLocations();

		model.addAttribute("pageTitle", "Dashboard");
		model.addAttribute("currentPage", "dashboard");
		model.addAttribute("activeCampaign", activeCampaign.orElse(null));
		model.addAttribute("playerCharacters", playerCharacters);
		model.addAttribute("npcCharacters", npcCharacters);
		model.addAttribute("locationCount", locations.size());
		model.addAttribute("playerCount", playerCharacters.size());
		model.addAttribute("npcCount", npcCharacters.size());

		if (activeCampaign.isPresent()) {
			var sessions = sessionService.findSessionsByCampaign(activeCampaign.get().id());
			model.addAttribute("sessionCount", sessions.size());
		} else {
			model.addAttribute("sessionCount", 0);
		}

		return "dashboard";
	}
}
