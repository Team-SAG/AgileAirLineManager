package AgileAirLineManager.Passenger.Exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;


public class ResourceAlreadyExist extends RuntimeException{
    public ResourceAlreadyExist() {
    }

    public ResourceAlreadyExist(String message) {
        super(message);
    }
}
