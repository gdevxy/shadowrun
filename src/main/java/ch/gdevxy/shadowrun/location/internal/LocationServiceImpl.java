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

		var entity = locationRepository.findById(model.id()).orElseGet(LocationEntity::new);

		entity.setTitle(model.title());
		entity.setLocation(model.location());
		entity.setType(model.type());

		return toModel(locationRepository.save(entity));
	}

	private Location toModel(LocationEntity entity) {
		return new Location(
			entity.getId(),
			entity.getTitle(),
			entity.getType(),
			entity.getLocation(),
			entity.getCreatedAt(),
			entity.getUpdatedAt()
		);
	}
}
