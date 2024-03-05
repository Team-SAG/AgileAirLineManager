package AgileAirLineManager.Passenger.Repository;

import AgileAirLineManager.Passenger.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Optional<Passenger> findByUniqueIdCard(String uniqueIdCard);
    Optional<Passenger> deleteByUniqueIdCard(String uniqueIdCard);
}
