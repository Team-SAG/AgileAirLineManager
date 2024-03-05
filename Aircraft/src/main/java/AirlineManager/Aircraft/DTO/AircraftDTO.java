package AirlineManager.Aircraft.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class AircraftDTO {
    private String name;
    private String aircraftNo;
    private String totalSeat;
    private boolean assigned;
    private boolean grounded;
}
