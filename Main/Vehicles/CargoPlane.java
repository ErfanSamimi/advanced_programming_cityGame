package Main.Vehicles;

public class CargoPlane extends Air_transport_vehicle {
    private int total_weight ;

    CargoPlane(int total_weight , int max_flight_height , int runway_length , int capacity , String ID , String companyName ){
        super(max_flight_height , runway_length , 700 , capacity , ID ,companyName);
        this.total_weight = total_weight ;
    }
}
