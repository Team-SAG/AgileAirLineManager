package AirlineManager.Aircraft.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Aircraft extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String aircraftNo;
    @Column(nullable = false)
    private String totalSeat;
    private boolean assigned;
    private boolean grounded;

}
