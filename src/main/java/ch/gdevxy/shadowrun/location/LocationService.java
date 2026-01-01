package ch.gdevxy.shadowrun.location;

import java.util.List;

public interface LocationService {
	List<Location> findAllLocations();
	Location save(Location location);
}
