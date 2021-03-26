package Main.Vehicles;

public class Passenger_airplane extends Air_transport_vehicle {
    private int number_of_workers ;
    private String classType ;     // business class , economy class

    Passenger_airplane(int number_of_workers , String classType , int max_flight_height , int runway_length
                                                , int capacity , String ID , String companyName){

        super(max_flight_height ,runway_length , 800 ,capacity ,ID ,companyName);
        this.number_of_workers = number_of_workers ;
        this.classType = classType;

    }
}
