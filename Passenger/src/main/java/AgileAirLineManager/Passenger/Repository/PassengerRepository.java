package AgileAirLineManager.Passenger.Repository;

import AgileAirLineManager.Passenger.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
