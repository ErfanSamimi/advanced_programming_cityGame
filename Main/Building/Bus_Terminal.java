package Main.Building;

import Main.Person;
import Main.Vehicles.Bus;

import java.util.ArrayList;

public class Bus_Terminal extends Terminal{
    private static ArrayList<Bus> busesList = new ArrayList<Bus>();
    private static ArrayList<Bus_Terminal> bus_terminals_list = new ArrayList<Bus_Terminal>();
    private ArrayList<Person> drivers = new ArrayList<Person>();

    //=======================================================================

    public Bus_Terminal(String cityName, String terminalName, String address, int area, int number_of_vehicles, int number_of_workers){
        super(600 + number_of_workers*30, cityName ,terminalName ,address , area ,number_of_vehicles , number_of_workers);
        bus_terminals_list.add(this) ;
    }

    //=======================================================================

    void setBusesList(Bus bus){
        busesList.add(bus);
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

    public void showInfo(){

        System.out.println("city name " + cityName);
        System.out.println("airport name : " + terminalName);
        System.out.println("address " + address );
        System.out.println("area " + area);
        System.out.println("vehicles " + number_of_vehicles);
        System.out.println("workers " + number_of_workers);
    }

}
