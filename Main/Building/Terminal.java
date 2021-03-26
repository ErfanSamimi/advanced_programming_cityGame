package Main.Building;

import Main.Person;

import java.util.ArrayList;

abstract public class Terminal {
    int build_price ;
    String cityName ;
    String terminalName ;
    String address ;
    int area ;
    int number_of_vehicles ;
    int number_of_workers ;
    private static ArrayList<Person> employees = new ArrayList<Person>();

    //=============================================================================================

    Terminal(int build_price , String cityName , String terminalName , String address , int area , int number_of_vehicles , int number_of_workers){
        this.build_price = build_price ;
        this.number_of_workers = number_of_workers ;
        this.cityName = cityName ;
        this.terminalName = terminalName ;
        this.address = address ;
        this.area = area ;
        this.number_of_vehicles = number_of_vehicles ;
    }
    //==============================================================================================

    void setEmployees(Person empl){
        employees.add(empl);
    }
    ArrayList<Person> getEmployees(){
        return employees ;
    }
}
