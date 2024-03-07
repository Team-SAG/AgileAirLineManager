package AirportDetail.Airport.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Airport extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
   @Column(unique = true,nullable = false)
   private String airportCode;
   private String location;

}
