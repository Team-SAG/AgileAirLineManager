package AirlineManager.Aircraft.Service;

import AirlineManager.Aircraft.DTO.AircraftDTO;
import AirlineManager.Aircraft.Model.Aircraft;

import java.util.Optional;

public interface AircraftService {

    Optional<AircraftDTO> getAircraft(String aircraftNo);
    AircraftDTO addAircraft(AircraftDTO aircraftDTO);
    AircraftDTO updateAircraft(AircraftDTO aircraftDTO);
    boolean deleteAircraft(String aircraftNo);

}
