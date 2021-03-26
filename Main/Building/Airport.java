package Main.Building;

import Main.Vehicles.Air_transport_vehicle;

import java.util.ArrayList;

public class Airport extends Terminal {
    private static ArrayList <Air_transport_vehicle> airplaneList = new ArrayList <Air_transport_vehicle>();
    private boolean international_Airport ;
    private int number_of_runways ;
    private int number_of_workers ;
     //====================================================================

    Airport(boolean international_Airport , int number_of_runways ,  String cityName , String terminalName , String address , int area , int number_of_vehicles , int number_of_workers){
        super(1400 + number_of_workers*30 ,cityName ,terminalName ,address , area ,number_of_vehicles);
        this.number_of_workers = number_of_workers ;
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

    int getAirportPrice(){
        return super.build_price ;
    }
}
