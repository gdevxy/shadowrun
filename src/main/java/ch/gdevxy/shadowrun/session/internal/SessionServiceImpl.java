package ch.gdevxy.shadowrun.session.internal;

import ch.gdevxy.shadowrun.session.Session;
import ch.gdevxy.shadowrun.session.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class SessionServiceImpl implements SessionService {

	private final SessionRepository sessionRepository;

	@Override
	public List<Session> findSessionsByCampaign(Long campaignId) {
		return sessionRepository.findByCampaignIdOrderBySessionNumber(campaignId).stream()
			.map(this::toModel)
			.toList();
	}

	@Override
	public Session save(Session model) {
		SessionEntity entity = new SessionEntity(
			model.id(),
			model.campaignId(),
			model.sessionNumber(),
			model.sessionDate(),
			model.log(),
			model.createdAt(),
			model.updatedAt()
		);
		SessionEntity saved = sessionRepository.save(entity);
		return toModel(saved);
	}

	private Session toModel(SessionEntity entity) {
		return new Session(
			entity.getId(),
			entity.getCampaignId(),
			entity.getSessionNumber(),
			entity.getSessionDate(),
			entity.getLog(),
			entity.getCreatedAt(),
			entity.getUpdatedAt()
		);
	}
}
