package ch.gdevxy.shadowrun.campaign;

import java.util.List;
import java.util.Optional;

public interface CampaignService {
	List<Campaign> findAllCampaigns();
	Optional<Campaign> findActiveCampaign();
	Optional<Campaign> findById(Long id);
	Campaign save(Campaign campaign);
}
