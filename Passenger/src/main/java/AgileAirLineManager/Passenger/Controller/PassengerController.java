package AgileAirLineManager.Passenger.Controller;

import AgileAirLineManager.Passenger.DTO.PassengerDTO;
import AgileAirLineManager.Passenger.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/fetch")
    public ResponseEntity<PassengerDTO> getPassenger(@RequestParam String uniqueIdCard){
        PassengerDTO passengerDTO = this.passengerService.getPassenger(uniqueIdCard);
        return ResponseEntity.status(HttpStatus.FOUND).body(passengerDTO);
    }
    @PostMapping("/add")
    public ResponseEntity<PassengerDTO> addPassenger(@RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.passengerService.addPassenger(passengerDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<PassengerDTO> updatePassenger(@RequestBody PassengerDTO passengerDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.passengerService.updatePassenger(passengerDTO));
    }

    @DeleteMapping("/delete")
    public String deletePassenger(@RequestParam String uniqueIdCard){
        boolean value = this.passengerService.deletePassenger(uniqueIdCard);
        return (value ? "Deleted Successfully" : "Passenger Not found");
    }

}
