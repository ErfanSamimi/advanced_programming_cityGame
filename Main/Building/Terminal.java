package Main.Building;

import Main.City;
import Main.Person;
import Main.Safar.Safar;
import Main.Safar.Safarable;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

abstract public class Terminal implements Safarable {
    int build_price ;
    City city ;
    String terminalName ;
    String address ;
    int area ;
    int number_of_vehicles ;
    int number_of_employees ;
    private  ArrayList<Person> employees = new ArrayList<Person>();
    private  ArrayList<Safar> safarList = new ArrayList<Safar>();
    private ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
    private ArrayList<Person> driversList = new ArrayList<Person>();
    private ArrayList<Safar> startingTerminalOfJourneys = new ArrayList<Safar>();
    private ArrayList<Safar> destinationTerminalOfJourneys = new ArrayList<Safar>();



    //=============================================================================================

    Terminal(int build_price , City city, String terminalName , String address , int area , int number_of_vehicles , int number_of_employees){
        this.build_price = build_price ;
        this.number_of_employees = number_of_employees ;
        this.city = city ;
        this.terminalName = terminalName ;
        this.address = address ;
        this.area = area ;
        this.number_of_vehicles = number_of_vehicles ;
    }
    //==============================================================================================

    public void addEmployees(Person empl){
        employees.add(empl);
    }

    public int max_number_of_employees(){
        return number_of_employees;
    }

    public int number_of_hired_employees(){
        return employees.size();
    }

    public ArrayList<Vehicle> getVehiclesList(){
        return this.vehiclesList;
    }

    public String getTerminalName(){
        return terminalName ;
    }

    public int max_number_of_vehicle (){
        return this.number_of_vehicles;
    }

    public int getNumber_of_bought_vehicles(){
        return vehiclesList.size();
    }

    public int number_of_hired_drivers(){
        return this.driversList.size();
    }

    public void add_Driver(Person pr){
        this.driversList.add(pr);
    }



    public void addVehicle ( Vehicle vehicle){
        this.vehiclesList.add( vehicle );
    }







    @Override
    public void newJourney(Terminal startingTerminal , Terminal destinationTerminal , ArrayList<Person> passengerList , Person driver , Vehicle vehicle , String journeyID , int journeyDay , int journeyMonth , int price){

        Safar newSafar = new Safar(startingTerminal , destinationTerminal , passengerList ,driver , vehicle ,journeyID , journeyDay , journeyMonth , price);
        this.safarList.add(newSafar);

        startingTerminal.employees.remove(driver);
        destinationTerminal.employees.add(driver);

        startingTerminal.vehiclesList.remove(vehicle);
        destinationTerminal.vehiclesList.add(vehicle);

        startingTerminal.startingTerminalOfJourneys.add(newSafar);
        destinationTerminal.destinationTerminalOfJourneys.add(newSafar);


        startingTerminal.city.getPersonList().remove(driver);
        destinationTerminal.city.getPersonList().add(driver);


        for ( Person a : passengerList){
            if ( ! a.getHired() ){
                startingTerminal.city.getPersonList().remove(a);
                destinationTerminal.city.getPersonList().add(a);
            }
        }


        startingTerminal.city.addBudget( journeyPrice( passengerList , vehicle) );



    }

    @Override
    public void sortJourneys(){
        Collections.sort(this.safarList);
    }

    @Override
    public void journeyHistory(boolean startingTerminal , boolean destinationTerminal){
        if(startingTerminal){
            for (Safar sa : startingTerminalOfJourneys)
                sa.printINFO();
        }
        if( destinationTerminal){
            for (Safar sa : destinationTerminalOfJourneys)
                sa.printINFO();
        }
    }

    @Override
    public int journeyPrice ( ArrayList<Person> passengerList , Vehicle vehicle){

        int total_journey_price = 0 ;
        int ticketPrice = vehicle.getTicketPrice();
        for ( Person a : passengerList){

            if ( ! a.getHired() )
                total_journey_price +=ticketPrice;

        }

        return total_journey_price;
    }





}
