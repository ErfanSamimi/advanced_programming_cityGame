package Main.Vehicles;

public class Passenger_airplane extends Air_transport_vehicle {
    private int number_of_stewardess ;
    private String classType ;     // business class , economy class

    Passenger_airplane(int number_of_stewardess , String classType , int max_flight_height , int runway_length
                                                , int capacity , String ID , String companyName){

        super(max_flight_height ,runway_length , 800 ,capacity ,ID ,companyName);
        this.number_of_stewardess = number_of_stewardess ;
        this.classType = classType;

    }
}
