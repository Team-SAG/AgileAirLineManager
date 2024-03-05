package AgileAirLineManager.Passenger.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Passenger extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long passengerId;
    @Column(nullable = false, unique = true)
    private String uniqueIdCard;
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private int age;

}
