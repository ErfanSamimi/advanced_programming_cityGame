package Main.Vehicles;

public class CargoPlane extends Air_transport_vehicle {
    int total_weight ;

    CargoPlane(int total_weight , int max_flight_height , int runway_length , int price , int capacity , String ID , String companyName ){
        super(max_flight_height , runway_length , price , capacity , ID ,companyName);
        this.total_weight = total_weight ;
    }
}
