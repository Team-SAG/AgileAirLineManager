package AirportDetail.Airport.Controller;

import AirportDetail.Airport.DTO.AirportDTO;
import AirportDetail.Airport.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/airport")
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping("/fetch")
    public ResponseEntity<AirportDTO> getAirport(@RequestParam String airportCode)
    {
        AirportDTO airportDTO = this.airportService.getAirport(airportCode);
        return ResponseEntity.status(HttpStatus.FOUND).body(airportDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<AirportDTO> addAirport(@RequestBody AirportDTO airportDTO)
    {
        this.airportService.addAirport(airportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(airportDTO);
    }

    @PutMapping("/update")
    public ResponseEntity<AirportDTO> updateAirport(@RequestBody AirportDTO airportDTO)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.airportService.updateAirport(airportDTO));
    }

    @DeleteMapping("/delete")
    public String deleteAirport(String airportCode) {
        this.airportService.deleteAirport(airportCode);
        return "Airport Deleted";
    }
}
