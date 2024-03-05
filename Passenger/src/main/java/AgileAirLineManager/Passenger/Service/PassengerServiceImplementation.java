package AgileAirLineManager.Passenger.Service;

import AgileAirLineManager.Passenger.DTO.PassengerDTO;
import AgileAirLineManager.Passenger.Mapper.MapperClass;
import AgileAirLineManager.Passenger.Model.Passenger;
import AgileAirLineManager.Passenger.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PassengerServiceImplementation implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public Optional<PassengerDTO> getPassenger(String uniqueIdCard) {
        Optional<Passenger> passenger = this.passengerRepository.findByUniqueIdCard(uniqueIdCard);
        PassengerDTO passengerDTO = MapperClass.mapPassengerToPassengerDTO(passenger.get());
        return Optional.of(passengerDTO);

    }

    @Override
    public PassengerDTO addPassenger(PassengerDTO passengerDTO) {
        Passenger passenger = MapperClass.mapPassengerDTOToPassenger(passengerDTO);
        this.passengerRepository.save(passenger);
        return passengerDTO;

    }

    @Override
    public PassengerDTO updatePassenger(PassengerDTO passengerDTO) {
        Optional<Passenger> passenger = this.passengerRepository.findByUniqueIdCard(passengerDTO.getUniqueIdCard());
        if(passenger.isPresent()){
            Passenger passenger1 = passenger.get();
            passenger1.setUniqueIdCard(passengerDTO.getUniqueIdCard());
            passenger1.setFirstName(passengerDTO.getFirstName());
            passenger1.setLastName(passengerDTO.getLastName());
            passenger1.setAge(passengerDTO.getAge());
            this.passengerRepository.save(passenger1);
            return passengerDTO;
        }
        else {
            throw new RuntimeException("Passenger with "+passengerDTO.getUniqueIdCard()+ " not found");
        }
    }

    @Override
    public boolean deletePassenger(String uniqueIdCard) {
        Optional<Passenger> passenger = this.passengerRepository.findByUniqueIdCard(uniqueIdCard);
        if(passenger.isPresent()) {
            this.passengerRepository.deleteByUniqueIdCard(uniqueIdCard);
            return true;
        }
        else {
            return false;
        }
    }
}
