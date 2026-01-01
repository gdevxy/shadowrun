package ch.gdevxy.shadowrun.campaign.internal;

import ch.gdevxy.shadowrun.campaign.Campaign;
import ch.gdevxy.shadowrun.campaign.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
class CampaignServiceImpl implements CampaignService {

	private final CampaignRepository campaignRepository;

	@Override
	public List<Campaign> findAllCampaigns() {
		return StreamSupport.stream(campaignRepository.findAll().spliterator(), false)
			.map(this::toModel)
			.toList();
	}

	@Override
	public Optional<Campaign> findActiveCampaign() {
		return StreamSupport.stream(campaignRepository.findAll().spliterator(), false)
			.filter(c -> "ACTIVE".equals(c.getStatus()))
			.findFirst()
			.map(this::toModel);
	}

	@Override
	public Optional<Campaign> findById(Long id) {
		return campaignRepository.findById(id).map(this::toModel);
	}

	@Override
	public Campaign save(Campaign model) {
		CampaignEntity entity = new CampaignEntity(
			model.id(),
			model.title(),
			model.description(),
			model.status(),
			model.createdAt(),
			model.updatedAt()
		);
		CampaignEntity saved = campaignRepository.save(entity);
		return toModel(saved);
	}

	private Campaign toModel(CampaignEntity entity) {
		return new Campaign(
			entity.getId(),
			entity.getTitle(),
			entity.getDescription(),
			entity.getStatus(),
			entity.getCreatedAt(),
			entity.getUpdatedAt()
		);
	}
}
