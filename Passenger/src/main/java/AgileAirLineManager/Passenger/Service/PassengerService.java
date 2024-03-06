package AgileAirLineManager.Passenger.Service;

import AgileAirLineManager.Passenger.DTO.PassengerDTO;

import java.util.Optional;

public interface PassengerService {

    PassengerDTO getPassenger(String uniqueIdCard);
    PassengerDTO addPassenger(PassengerDTO passengerDTO);
    PassengerDTO updatePassenger(PassengerDTO passengerDTO);
    boolean deletePassenger(String uniqueIdCard);

}
