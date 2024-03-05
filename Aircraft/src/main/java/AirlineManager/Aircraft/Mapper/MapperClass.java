package AirlineManager.Aircraft.Mapper;

import AirlineManager.Aircraft.DTO.AircraftDTO;
import AirlineManager.Aircraft.Model.Aircraft;

public class MapperClass {

    public static AircraftDTO mapAircraftToAircraftDTO(Aircraft aircraft)
    {
       return AircraftDTO.builder()
                .name(aircraft.getName())
                .aircraftNo(aircraft.getAircraftNo())
                .assigned(aircraft.isAssigned())
                .totalSeat(aircraft.getTotalSeat())
                .grounded(aircraft.isGrounded())
                .build();


    }
    public static Aircraft mapAircraftDTOToAircraft(AircraftDTO aircraftDTO)
    {
        return Aircraft.builder()
                .name(aircraftDTO.getName())
                .aircraftNo(aircraftDTO.getAircraftNo())
                .assigned(aircraftDTO.isAssigned())
                .totalSeat(aircraftDTO.getTotalSeat())
                .grounded(aircraftDTO.isGrounded())
                .build();


    }
}
