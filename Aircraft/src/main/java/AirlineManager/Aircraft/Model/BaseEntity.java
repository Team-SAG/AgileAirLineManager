package AirlineManager.Aircraft.Model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@MappedSuperclass
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
