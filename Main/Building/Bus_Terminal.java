package Main.Building;

import Main.Person;
import Main.Vehicles.Bus;

import java.util.ArrayList;

public class Bus_Terminal extends Terminal{
    private static ArrayList<Bus> busesList = new ArrayList<Bus>();
    private static ArrayList<Bus_Terminal> bus_terminals_list = new ArrayList<Bus_Terminal>();
    private ArrayList<Person> drivers = new ArrayList<Person>();
//    private ArrayList<Person> employees = new ArrayList<Person>();

    private int number_of_bought_vehicles = 0;


    //=======================================================================

    public Bus_Terminal(String cityName, String terminalName, String address, int area, int number_of_vehicles, int number_of_workers){
        super(600 + number_of_workers*30, cityName ,terminalName ,address , area ,number_of_vehicles , number_of_workers);
        bus_terminals_list.add(this) ;
    }

    //=======================================================================

    public void addBus(Bus bus){
        busesList.add(bus);
        System.out.println("\nA bus added to " + this.terminalName + " Bus terminal . ");
        number_of_bought_vehicles ++;
    }

    public int max_number_of_vehicle (){
        return this.number_of_vehicles;
    }

    public int getNumber_of_bought_vehicles(){
        return this.number_of_bought_vehicles ;
    }

    ArrayList<Bus> getBusesList(){
        return busesList ;
    }

    public static ArrayList<Bus_Terminal> getBus_terminals_list (){
        return bus_terminals_list ;
    }

    public int numberOfHiredDrivers(){
        return drivers.size();
    }

    public void addDriver(Person driver){
        drivers.add(driver);
    }
    int getBusTerminalPrice(){
        return super.build_price ;
    }

    public String getName (){
        return terminalName;
    }


    public void addEmployee(Person emp){
        super.setEmployees(emp);
    }

    public int getNumber_of_employees(){
        return number_of_workers;
    }

    public int getNumber_of_hired_employees(){
        return super.getEmployees().size();
    }

    public void showInfo(){

        System.out.println("City name : " + cityName);
        System.out.println("Airport name : " + terminalName);
        System.out.println("Address : " + address );
        System.out.println("Area : " + area);
        System.out.println("Maximum number of vehicles : " + number_of_vehicles);
        System.out.println("Number of bought vehicles : " + number_of_bought_vehicles);
        System.out.println("Max number of  employees : " + number_of_workers);
        System.out.println("Number of hired employees : " + super.getEmployees().size());
        System.out.println("Number of drivers : " + drivers.size());

        System.out.println("\n===================================================================\n");
    }

}
