package AirportDetail.Airport.Exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound()
    {
        super();
    }

    public ResourceNotFound(String message)
    {
        super(message);
    }
}
