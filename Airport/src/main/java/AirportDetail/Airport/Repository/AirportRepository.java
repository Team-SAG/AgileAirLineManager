package AirportDetail.Airport.Repository;

import AirportDetail.Airport.Model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AirportRepository extends JpaRepository<Airport,Long>
{
    Optional<Airport> findByAirportCode(String airportCode);
}
