package Main.Vehicles;

import java.util.ArrayList;

public class Passenger_airplane extends Air_transport_vehicle {

    private int number_of_flightAttendants;
    private String classType ;     // business class , economy class

    ArrayList<Passenger_airplane> passenger_airplanesList = new ArrayList<Passenger_airplane>() ;

    public Passenger_airplane(int number_of_flightAttendants, String classType, int max_flight_height, int runway_length
            , int capacity, String ID, String companyName){

        super(max_flight_height ,runway_length , 800 ,capacity ,ID ,companyName);
        this.number_of_flightAttendants = number_of_flightAttendants ;
        this.classType = classType;
        passenger_airplanesList.add(this);

    }
}
