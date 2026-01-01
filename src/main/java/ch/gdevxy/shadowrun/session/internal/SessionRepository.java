package ch.gdevxy.shadowrun.session.internal;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

interface SessionRepository extends CrudRepository<SessionEntity, Long> {
	List<SessionEntity> findByCampaignIdOrderBySessionNumber(Long campaignId);
}
