package ch.gdevxy.shadowrun.session;

import ch.gdevxy.shadowrun.campaign.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

	private final SessionService sessionService;
	private final CampaignService campaignService;

	@GetMapping
	public String sessions(Model model) {

		var activeCampaign = campaignService.findActiveCampaign();
		var sessions = activeCampaign
				.map(campaign -> sessionService.findSessionsByCampaign(campaign.id()))
				.orElse(List.of());

		model.addAttribute("pageTitle", "Session Logs");
		model.addAttribute("currentPage", "sessions");
		model.addAttribute("sessions", sessions);
		model.addAttribute("sessionCount", sessions.size());

		return "sessions";
	}
}
