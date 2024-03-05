package AirlineManager.Aircraft.Repository;

import AirlineManager.Aircraft.Model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AircraftRepository extends JpaRepository<Aircraft, Long> {

     Optional<Aircraft> findByAircraftNo(String aircraftNo);
}
