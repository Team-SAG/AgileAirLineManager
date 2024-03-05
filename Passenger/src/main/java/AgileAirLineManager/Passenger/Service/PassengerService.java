package AgileAirLineManager.Passenger.Service;

import AgileAirLineManager.Passenger.DTO.PassengerDTO;

public interface PassengerService {

    PassengerDTO getPassenger(long passegerId);
    PassengerDTO addPassenger(PassengerDTO passengerDTO);
    PassengerDTO updatePassenger(PassengerDTO passengerDTO);
    boolean deletePassenger(long passengerId);

}
