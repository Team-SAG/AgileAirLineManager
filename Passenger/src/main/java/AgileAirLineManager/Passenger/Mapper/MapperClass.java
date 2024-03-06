package AgileAirLineManager.Passenger.Mapper;

import AgileAirLineManager.Passenger.DTO.PassengerDTO;
import AgileAirLineManager.Passenger.Model.Passenger;

import java.time.LocalDate;

public class MapperClass {

    public static PassengerDTO mapPassengerToPassengerDTO(Passenger passenger){

        return PassengerDTO.builder()
                .uniqueIdCard(passenger.getUniqueIdCard())
                .firstName(passenger.getFirstName())
                .lastName(passenger.getLastName())
                .age(passenger.getAge())
                .build();
    }

    public static Passenger mapPassengerDTOToPassenger(PassengerDTO passengerDTO) {

        Passenger passenger =  Passenger.builder()
                .uniqueIdCard(passengerDTO.getUniqueIdCard())
                .firstName(passengerDTO.getFirstName())
                .lastName(passengerDTO.getLastName())
                .age(passengerDTO.getAge())
                .build();
        return passenger;

    }

}
