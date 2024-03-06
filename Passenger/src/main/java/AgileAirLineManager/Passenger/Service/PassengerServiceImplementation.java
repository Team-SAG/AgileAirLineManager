package AgileAirLineManager.Passenger.Service;

import AgileAirLineManager.Passenger.DTO.PassengerDTO;
import AgileAirLineManager.Passenger.Exceptions.ResourceAlreadyExist;
import AgileAirLineManager.Passenger.Exceptions.ResourceNotFoundException;
import AgileAirLineManager.Passenger.Mapper.MapperClass;
import AgileAirLineManager.Passenger.Model.Passenger;
import AgileAirLineManager.Passenger.Repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PassengerServiceImplementation implements PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public PassengerDTO getPassenger(String uniqueIdCard) {

        Passenger passenger = this.passengerRepository.findByUniqueIdCard(uniqueIdCard)
                .orElseThrow(()-> new ResourceNotFoundException("Passenger not found with given id : "+uniqueIdCard));

        PassengerDTO passengerDTO = MapperClass.mapPassengerToPassengerDTO(passenger);
        return passengerDTO;

    }

    @Override
    public PassengerDTO addPassenger(PassengerDTO passengerDTO) {
        try {
            Passenger passenger = MapperClass.mapPassengerDTOToPassenger(passengerDTO);
            passenger.setCreatedBy("admin");
            passenger.setCreatedAt(LocalDateTime.now());
            this.passengerRepository.save(passenger);
            return passengerDTO;
        }
        catch(Exception exception) {
            throw new ResourceAlreadyExist("Passeneger already exist with following UniqueCardId : "+passengerDTO.getUniqueIdCard());
        }
    }

    @Override
    public PassengerDTO updatePassenger(PassengerDTO passengerDTO) {
        Passenger passenger = this.passengerRepository.findByUniqueIdCard(passengerDTO.getUniqueIdCard())
                .orElseThrow(()->new ResourceNotFoundException(
                        "Passenger do not exist with following UniqueCardId : "+passengerDTO.getUniqueIdCard()
                ));


            passenger.setUniqueIdCard(passengerDTO.getUniqueIdCard());
            passenger.setFirstName(passengerDTO.getFirstName());
            passenger.setLastName(passengerDTO.getLastName());
            passenger.setAge(passengerDTO.getAge());
            passenger.setUpdatedBy("admin");
            passenger.setUpdatedAt(LocalDateTime.now());
            this.passengerRepository.save(passenger);

            return passengerDTO;
    }

    @Override
    public boolean deletePassenger(String uniqueIdCard) {
        Passenger passenger = this.passengerRepository.findByUniqueIdCard(uniqueIdCard)
                .orElseThrow(()->new ResourceNotFoundException(
                        "Passenger do not exist with following UniqueCardId : "+uniqueIdCard
                ));
        this.passengerRepository.deleteByUniqueIdCard(uniqueIdCard);
        return true;
    }
}
