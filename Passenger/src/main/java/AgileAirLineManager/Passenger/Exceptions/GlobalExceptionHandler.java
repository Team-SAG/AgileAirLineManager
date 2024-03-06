package AgileAirLineManager.Passenger.Exceptions;

import AgileAirLineManager.Passenger.DTO.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    // here we are creating different-different methods that will
    // handle the different exceptions

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(
        ResourceNotFoundException resourceNotFoundException, WebRequest webRequest
    ) {
        // here we will be building the object of ExceptionResponse
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .apiPath(webRequest.getDescription(false))
                .message(resourceNotFoundException.getMessage())
                .status(HttpStatus.NOT_FOUND)
                .serviceName("Passeneger")
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);

    }

    // resource already exsits exception
    @ExceptionHandler(ResourceAlreadyExist.class)
    public ResponseEntity<ExceptionResponse> handleResourceAlreadyExist(
            ResourceAlreadyExist resourceAlreadyExist, WebRequest webRequest
    ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .apiPath(webRequest.getDescription(false))
                .status(HttpStatus.OK)
                .message(resourceAlreadyExist.getMessage())
                .serviceName("Passenger")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(exceptionResponse);
    }

}
