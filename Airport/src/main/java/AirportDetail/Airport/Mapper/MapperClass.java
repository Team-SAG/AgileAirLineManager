package AirportDetail.Airport.Mapper;

import AirportDetail.Airport.DTO.AirportDTO;
import AirportDetail.Airport.Model.Airport;

import java.util.Optional;

public class MapperClass {

    public static AirportDTO mapAirportToAirportDTO(Airport airport)
    {
        return AirportDTO.builder()
                .name(airport.getName())
                .location(airport.getLocation())
                .airportCode(airport.getAirportCode())
                .build();
    }

    public static Airport mapAirportDTOtoAirport (AirportDTO airportDTO)
    {
        return Airport.builder()
                .name(airportDTO.getName())
                .location(airportDTO.getLocation())
                .airportCode(airportDTO.getAirportCode())
                .build();
    }
}
