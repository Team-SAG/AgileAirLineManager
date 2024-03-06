package AgileAirLineManager.Passenger.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class ExceptionResponse {

    private String apiPath;
    private HttpStatus status;
    private String message;
    private String serviceName;

}
