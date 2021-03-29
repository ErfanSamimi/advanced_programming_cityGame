package Main.Building;

import Main.Person;
import Main.Vehicles.Air_transport_vehicle;

import java.util.ArrayList;

public class Airport extends Terminal {
    private static ArrayList <Air_transport_vehicle> passngerAirplaneList = new ArrayList <Air_transport_vehicle>();
    private static ArrayList <Air_transport_vehicle> cargoAirplaneList = new ArrayList <Air_transport_vehicle>();
    private static ArrayList <Airport> airportsList = new ArrayList<Airport>();
    private  ArrayList<Person> pilots = new ArrayList<Person>();
    private ArrayList<Person> flightAttendants = new ArrayList<Person>();
    private boolean international_Airport ;
    private int number_of_runways ;
    private int number_of_bought_vehicles = 0;


    //====================================================================

    public Airport(boolean international_Airport, int number_of_runways, String cityName, String terminalName, String address, int area, int number_of_vehicles, int number_of_employees){
        super(1400 + number_of_employees*30 ,cityName ,terminalName ,address , area ,number_of_vehicles, number_of_employees);
        this.international_Airport = international_Airport ;
        this.number_of_runways = number_of_runways ;
        airportsList.add(this);
    }

    //======================================================================

    public void addPassengerAirplane(Air_transport_vehicle vehicle){
        passngerAirplaneList.add(vehicle) ;
        System.out.println("\nA passenger airplane  added to " + this.terminalName + " Airport . ");
        number_of_bought_vehicles++;
    }

    public static ArrayList <Air_transport_vehicle> getPassngerAirplaneList(){
        return passngerAirplaneList;
    }

    public void addCargoAirplane(Air_transport_vehicle vehicle){
        cargoAirplaneList.add(vehicle) ;
        System.out.println("\nA cargo airplane  added to " + this.terminalName + " Airport . ");
        number_of_bought_vehicles++;
    }

    public String getName(){
        return this.terminalName;
    }

    public int max_number_of_vehicle (){
        return this.number_of_vehicles;
    }

    public int getNumber_of_bought_vehicles(){
        return this.number_of_bought_vehicles ;
    }

    public static ArrayList <Air_transport_vehicle> getCargoAirplaneList(){
        return cargoAirplaneList;
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

    public void addEmployee(Person emp){
        super.setEmployees(emp);
    }

    public int getNumber_of_employees(){
        return number_of_employees;
    }

    public int getNumber_of_hired_employees(){
        return super.getEmployees().size();
    }

    public void showInfo(){
        System.out.println("International : " + international_Airport);
        System.out.println("Runways : " + number_of_runways);
        System.out.println("City name : " + cityName);
        System.out.println("Airport name : " + terminalName);
        System.out.println("Address : " + address );
        System.out.println("Area : " + area);
        System.out.println("Maximum number of vehicles : " + number_of_vehicles);
        System.out.println("Number of bought vehicles : " + number_of_bought_vehicles);
        System.out.println("Number of cargo planes : " + cargoAirplaneList.size());
        System.out.println("Number of passenger airplanes :" + passngerAirplaneList.size() );
        System.out.println("Maximum number of  employees : " + number_of_employees);
        System.out.println("Number of hired employees : " + super.getEmployees().size());
        System.out.println("Number of pilots : " + pilots.size());
        System.out.println("Number of flight attendants : " + flightAttendants.size());

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }
}
