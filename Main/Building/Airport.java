package Main.Building;

import Main.Person;
import Main.Vehicles.Air_transport_vehicle;

import java.util.ArrayList;

public class Airport extends Terminal {




    private static ArrayList <Airport> airportsList = new ArrayList<Airport>();
    private  ArrayList<Person> pilots = new ArrayList<Person>();
    private ArrayList<Person> flightAttendants = new ArrayList<Person>();
    private boolean international_Airport ;
    private int number_of_runways ;


    //====================================================================

    public Airport(boolean international_Airport, int number_of_runways, String cityName, String terminalName, String address, int area, int number_of_vehicles, int number_of_employees){
        super(1400 + number_of_employees*30 ,cityName ,terminalName ,address , area ,number_of_vehicles, number_of_employees);
        this.international_Airport = international_Airport ;
        this.number_of_runways = number_of_runways ;
        airportsList.add(this);
    }

    //======================================================================

    public static ArrayList<Airport> getAirportsList(){
        return airportsList ;
    }

    public int numberOfHiredFlightAttendants(){
        return flightAttendants.size();
    }

    public void addFlightAttendant(Person flight_attendant){
        flightAttendants.add(flight_attendant);
    }

    public void showInfo(){
        System.out.println("International : " + international_Airport);
        System.out.println("Runways : " + number_of_runways);
        System.out.println("City name : " + cityName);
        System.out.println("Airport name : " + terminalName);
        System.out.println("Address : " + address );
        System.out.println("Area : " + area);
        System.out.println("Maximum number of vehicles : " + number_of_vehicles);
        System.out.println("Number of bought vehicles : "  + getNumber_of_bought_vehicles() );
        System.out.println("Maximum number of  employees : " + number_of_employees);
        System.out.println("Number of hired employees : " + super.number_of_hired_employees());
        System.out.println("Number of pilots : " + pilots.size());
        System.out.println("Number of flight attendants : " + flightAttendants.size());

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }
}
