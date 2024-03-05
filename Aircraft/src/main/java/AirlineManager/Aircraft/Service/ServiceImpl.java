package AirlineManager.Aircraft.Service;

import AirlineManager.Aircraft.DTO.AircraftDTO;
import AirlineManager.Aircraft.Mapper.MapperClass;
import AirlineManager.Aircraft.Model.Aircraft;
import AirlineManager.Aircraft.Repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceImpl implements AircraftService{

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public Optional<AircraftDTO> getAircraft(String aircraftNo) {
        Optional<Aircraft> aircraft =  this.aircraftRepository.findByAircraftNo(aircraftNo);
        AircraftDTO aircraftDTO = MapperClass.mapAircraftToAircraftDTO(aircraft.get());
        return Optional.of(aircraftDTO);
    }

    @Override
    public AircraftDTO addAircraft(AircraftDTO aircraftDTO) {

        Aircraft aircraft = MapperClass.mapAircraftDTOToAircraft(aircraftDTO);
        this.aircraftRepository.save(aircraft);
        return aircraftDTO;
    }

    @Override
    public AircraftDTO updateAircraft(AircraftDTO aircraftDTO)
    {
        Optional<Aircraft> aircraft = this.aircraftRepository.findByAircraftNo(aircraftDTO.getAircraftNo());
        if(aircraft.isPresent())
        {
            Aircraft newaircraft = aircraft.get();
            newaircraft.setName(aircraftDTO.getName());
            newaircraft.setAircraftNo(aircraftDTO.getAircraftNo());
            newaircraft.setTotalSeat(aircraftDTO.getTotalSeat());
            newaircraft.setGrounded(aircraftDTO.isGrounded());
            newaircraft.setAssigned(aircraftDTO.isAssigned());

            this.aircraftRepository.save(newaircraft);
            return aircraftDTO;
        }
        else
        {
            throw new RuntimeException("Resource Not Found..");
        }

    }

    @Override
    public boolean deleteAircraft(String aircraftNo)
    {
        boolean temp=false;
        Optional<Aircraft> aircraft = this.aircraftRepository.findByAircraftNo(aircraftNo);
        if(aircraft.isPresent())
        {
            this.aircraftRepository.delete(aircraft.get());
            temp=true;
        }

        return temp;
    }
}
