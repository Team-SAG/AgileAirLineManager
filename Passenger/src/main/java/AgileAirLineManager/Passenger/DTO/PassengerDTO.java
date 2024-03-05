package AgileAirLineManager.Passenger.DTO;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class PassengerDTO {
    private String uniqueIdCard;
    private String firstName;
    private String lastName;
    private int age;
}
