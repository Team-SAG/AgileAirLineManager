package AirportDetail.Airport.Exception;

import AirportDetail.Airport.DTO.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFound(ResourceNotFound resourceNotFound, WebRequest webRequest)
    {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .apiPath(webRequest.getDescription(false))
                .status(HttpStatus.NOT_FOUND)
                .message(resourceNotFound.getMessage())
                .serviceName("Airport").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(ResourceAlreadyExist.class)
    public ResponseEntity<ExceptionResponse> HandleResourceAlreadyExist(ResourceAlreadyExist resourceAlreadyExist, WebRequest webRequest)
    {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .apiPath(webRequest.getDescription(false))
                .status(HttpStatus.NOT_FOUND)
                .message(resourceAlreadyExist.getMessage())
                .serviceName("Airport").build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }
}
