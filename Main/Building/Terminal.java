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
    int number_of_employees ;
    private  ArrayList<Person> employees = new ArrayList<Person>();

    //=============================================================================================

    Terminal(int build_price , String cityName , String terminalName , String address , int area , int number_of_vehicles , int number_of_employees){
        this.build_price = build_price ;
        this.number_of_employees = number_of_employees ;
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
