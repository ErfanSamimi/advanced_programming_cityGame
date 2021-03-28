package Main.Building;

import Main.Person;
import Main.Vehicles.Air_transport_vehicle;

import java.util.ArrayList;

public class Airport extends Terminal {
    private static ArrayList <Air_transport_vehicle> airplaneList = new ArrayList <Air_transport_vehicle>();
    private static ArrayList <Airport> airportsList = new ArrayList<Airport>();
    private  ArrayList<Person> pilots = new ArrayList<Person>();
    private ArrayList<Person> flightAttendants = new ArrayList<Person>();
    private boolean international_Airport ;
    private int number_of_runways ;

     //====================================================================

    public Airport(boolean international_Airport, int number_of_runways, String cityName, String terminalName, String address, int area, int number_of_vehicles, int number_of_workers){
        super(1400 + number_of_workers*30 ,cityName ,terminalName ,address , area ,number_of_vehicles, number_of_workers);
        this.international_Airport = international_Airport ;
        this.number_of_runways = number_of_runways ;
        airportsList.add(this);
    }

    //======================================================================

    void setAirplaneList(Air_transport_vehicle vehicle){
        airplaneList.add(vehicle) ;
    }

    public static ArrayList <Air_transport_vehicle> getAirplaneList(){
        return airplaneList;
    }

    int getAirportPrice(){
        return super.build_price ;
    }

    public static ArrayList<Airport> getAirportsList(){
        return airportsList ;
    }

    public int numberOfHiredPilots(){
        return pilots.size();
    }

    public void addPilot(Person pilot){
        pilots.add(pilot);
    }

    public int numberOfHiredFlightAttendants(){
        return flightAttendants.size();
    }

    public void addFlightAttendant(Person flight_attendant){
        flightAttendants.add(flight_attendant);
    }

    public void showInfo(){
        System.out.println("international " + international_Airport);
        System.out.println("runways " + number_of_runways);
        System.out.println("city name " + cityName);
        System.out.println("airport name : " + terminalName);
        System.out.println("address " + address );
        System.out.println("area " + area);
        System.out.println("vehicles " + number_of_vehicles);
        System.out.println("workers " + number_of_workers);
    }
}
