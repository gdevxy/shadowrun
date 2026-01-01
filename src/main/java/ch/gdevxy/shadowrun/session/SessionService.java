package ch.gdevxy.shadowrun.session;

import java.util.List;

public interface SessionService {
	List<Session> findSessionsByCampaign(Long campaignId);
	Session save(Session session);
}
