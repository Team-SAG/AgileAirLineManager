package AirportDetail.Airport.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class ExceptionResponse {
    private String apiPath;
    private String message;
    private String serviceName;
    private HttpStatus status;
}
