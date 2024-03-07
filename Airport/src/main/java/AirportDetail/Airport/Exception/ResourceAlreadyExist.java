package AirportDetail.Airport.Exception;

public class ResourceAlreadyExist extends RuntimeException
{
    public ResourceAlreadyExist() {
        super();
    }

    public ResourceAlreadyExist(String message)
    {
        super(message);
    }
}
