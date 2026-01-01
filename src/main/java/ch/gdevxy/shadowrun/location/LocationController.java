package ch.gdevxy.shadowrun.location;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/locations")
@RequiredArgsConstructor
public class LocationController {

	private final LocationService locationService;

	@GetMapping
	public String locations(Model model) {
		var locations = locationService.findAllLocations();
		model.addAttribute("pageTitle", "Locations");
		model.addAttribute("currentPage", "locations");
		model.addAttribute("locations", locations);
		model.addAttribute("locationCount", locations.size());
		return "locations";
	}
}
