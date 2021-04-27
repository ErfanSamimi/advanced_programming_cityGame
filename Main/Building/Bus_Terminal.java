package Main.Building;

import Main.City;
import Main.Person;
import Main.Vehicles.Bus;

import java.util.ArrayList;

public class Bus_Terminal extends Terminal{
    private static ArrayList<Bus> busesList = new ArrayList<Bus>();
    private static ArrayList<Bus_Terminal> bus_terminals_list = new ArrayList<Bus_Terminal>();
    private ArrayList<Person> drivers = new ArrayList<Person>();



    //=======================================================================

    public Bus_Terminal(City city, String terminalName, String address, int area, int number_of_vehicles, int number_of_employees){
        super(600 + number_of_employees*30,  city,terminalName ,address , area ,number_of_vehicles , number_of_employees);
        bus_terminals_list.add(this) ;
    }

    //=======================================================================
    public static ArrayList<Bus_Terminal> getBus_terminals_list(){
        return bus_terminals_list ;
    }





    public void showInfo(){

        System.out.println("City name : " + city.getCityName());
        System.out.println("Airport name : " + terminalName);
        System.out.println("Address : " + address );
        System.out.println("Area : " + area);
        System.out.println("Maximum number of vehicles : " + number_of_vehicles);
        System.out.println("Number of bought vehicles : " + getNumber_of_bought_vehicles());
        System.out.println("Max number of  employees : " + number_of_employees);
        System.out.println("Number of hired employees : " + number_of_hired_employees());
        System.out.println("Number of drivers : " + drivers.size());

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

}
