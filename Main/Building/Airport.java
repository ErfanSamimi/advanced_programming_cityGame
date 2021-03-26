package Main.Building;

import Main.Vehicles.Air_transport_vehicle;

import java.util.ArrayList;

public class Airport extends Terminal {
    private static ArrayList <Air_transport_vehicle> airplaneList = new ArrayList <Air_transport_vehicle>();
    private boolean international_Airport ;
    private int number_of_runways ;
     //====================================================================

    Airport(boolean international_Airport , int number_of_runways ,  String cityName , String terminalName , String address , int area , int number_of_vehicles){
        super(1400 ,cityName ,terminalName ,address , area ,number_of_vehicles);

        this.international_Airport = international_Airport ;
        this.number_of_runways = number_of_runways ;
    }

    //======================================================================

    void setAirplaneList(Air_transport_vehicle vehicle){
        airplaneList.add(vehicle) ;
    }

    ArrayList <Air_transport_vehicle> getAirplaneList(){
        return airplaneList;
    }
}
