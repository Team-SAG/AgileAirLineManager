package AgileAirLineManager.Passenger.DTO;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class PassengerDTO {
    private long passengerId;
    private String firstName;
    private String lastName;
    private int age;
}
