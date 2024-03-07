package AirportDetail.Airport.Service;

import AirportDetail.Airport.DTO.AirportDTO;
import AirportDetail.Airport.Exception.ResourceAlreadyExist;
import AirportDetail.Airport.Exception.ResourceNotFound;
import AirportDetail.Airport.Mapper.MapperClass;
import AirportDetail.Airport.Model.Airport;
import AirportDetail.Airport.Repository.AirportRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService{

    @Autowired
    private AirportRepository airportRepository;

    @Override
    public AirportDTO getAirport(String airportCode) {
        Airport airport = this.airportRepository.findByAirportCode(airportCode)
                .orElseThrow(()->new ResourceNotFound("Airport Not Found with Airport Code : "+airportCode));
        AirportDTO airportDTO = MapperClass.mapAirportToAirportDTO(airport);
        return airportDTO;
    }

    @Override
    public AirportDTO addAirport(AirportDTO airportDTO) {
        Airport airport = MapperClass.mapAirportDTOtoAirport(airportDTO);
        airport.setCreatedBy("admin");
        airport.setCreatedAt(LocalDateTime.now());

        try
        {
            this.airportRepository.save(airport);
            return airportDTO;
        }
        catch(RuntimeException ex)
        {
            throw new ResourceAlreadyExist("Airport Already exist with Airport Code : "+airportDTO.getAirportCode());
        }

    }

    @Override
    public AirportDTO updateAirport(AirportDTO airportDTO) {
       Airport airport = this.airportRepository.findByAirportCode(airportDTO.getAirportCode())
               .orElseThrow(()->new ResourceNotFound("Airport Not Found with Airport Code : "+airportDTO.getAirportCode()));

            airport.setUpdatedBy("Head");
            airport.setUpdatedAt(LocalDateTime.now());
            airport.setName(airportDTO.getName());
            airport.setLocation(airportDTO.getLocation());
            this.airportRepository.save(airport);
            return airportDTO;
    }

    @Override
    public boolean deleteAirport(String airportCode) {
        Airport airport = this.airportRepository.findByAirportCode(airportCode)
                .orElseThrow(()->new ResourceNotFound("Airport Not Found with Airport Code : "+airportCode));


            this.airportRepository.delete(airport);
            return true;
    }
}
