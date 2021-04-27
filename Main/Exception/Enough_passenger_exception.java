package Main.Exception;

public class Enough_passenger_exception extends CanceledJourney{
    @Override
    public String toString(){
        return "At least half of passenger capacity must be reserved";
    }
}
