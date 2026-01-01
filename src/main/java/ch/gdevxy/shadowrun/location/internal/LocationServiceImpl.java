package ch.gdevxy.shadowrun.location.internal;

import ch.gdevxy.shadowrun.location.Location;
import ch.gdevxy.shadowrun.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
class LocationServiceImpl implements LocationService {

	private final LocationRepository locationRepository;

	@Override
	public List<Location> findAllLocations() {
		return StreamSupport.stream(locationRepository.findAll().spliterator(), false)
			.map(this::toModel)
			.toList();
	}

	@Override
	public Location save(Location model) {
		LocationEntity entity = new LocationEntity(
			model.id(),
			model.title(),
			model.body(),
			model.createdAt(),
			model.updatedAt()
		);
		LocationEntity saved = locationRepository.save(entity);
		return toModel(saved);
	}

	private Location toModel(LocationEntity entity) {
		return new Location(
			entity.getId(),
			entity.getTitle(),
			entity.getBody(),
			entity.getCreatedAt(),
			entity.getUpdatedAt()
		);
	}
}
