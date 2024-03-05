package AgileAirLineManager.Passenger.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {
    @Column(updatable = false)
    private String createdBy;
    @Column(updatable = false)
    private LocalDate createdAt;
    @Column(insertable = false)
    private String updatedBy;
    @Column(insertable = false)
    private LocalDate updatedAt;

}
