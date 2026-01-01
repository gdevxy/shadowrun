package ch.gdevxy.shadowrun.campaign.internal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface CampaignSceneRepository extends CrudRepository<CampaignSceneEntity, Long> {
	List<CampaignSceneEntity> findByCampaignIdOrderBySequence(Long campaignId);
}
