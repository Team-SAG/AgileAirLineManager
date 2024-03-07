package AirportDetail.Airport.Service;

import AirportDetail.Airport.DTO.AirportDTO;
import AirportDetail.Airport.Model.Airport;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface AirportService
{
    AirportDTO getAirport(String airportCode);
    AirportDTO addAirport(@RequestBody AirportDTO airportDTO);
    AirportDTO updateAirport(@RequestBody AirportDTO airportDTO);
    boolean deleteAirport(String AirportCode);
}
