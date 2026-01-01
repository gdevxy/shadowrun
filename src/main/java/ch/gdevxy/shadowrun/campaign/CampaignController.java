package ch.gdevxy.shadowrun.campaign;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/campaign")
@RequiredArgsConstructor
public class CampaignController {

	private final CampaignService campaignService;

	@GetMapping
	public String campaign(Model model) {
		var activeCampaign = campaignService.findActiveCampaign();
		model.addAttribute("pageTitle", "Active Campaign");
		model.addAttribute("currentPage", "campaign");
		model.addAttribute("activeCampaign", activeCampaign.orElse(null));
		return "campaign";
	}
}
