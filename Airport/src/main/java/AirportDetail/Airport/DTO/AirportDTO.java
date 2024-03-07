package AirportDetail.Airport.DTO;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class AirportDTO {

    private String name;
    private String airportCode;
    private String location;
}
