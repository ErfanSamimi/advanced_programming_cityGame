package Main.Building;

import Main.City;
import Main.Exception.Invalid_TerminalName;
import Main.Person;
import Main.Safar.Safar;
import Main.Safar.Safarable;
import Main.Vehicles.Vehicle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

abstract public class Terminal implements Safarable , Serializable {
    int build_price ;
    String cityName;
    String terminalName ;
    String address ;
    int area ;
    int number_of_vehicles ;
    int number_of_employees ;
    private ArrayList<String> startingPointIDs = new ArrayList<>();
    private ArrayList<String> destinationPointIDs = new ArrayList<>();

    private ArrayList<Integer> drverIDs = new ArrayList<>();
    private ArrayList<Integer> employeeIDs = new ArrayList<>();
    private ArrayList<String> vehicleIDs = new ArrayList<>();



    transient City city ;
    static ArrayList<Terminal> totalTerminals = new ArrayList<>();
    transient private  ArrayList<Person> employees = new ArrayList<Person>();
    transient private ArrayList<Vehicle> vehiclesList = new ArrayList<Vehicle>();
    transient private ArrayList<Person> driversList = new ArrayList<Person>();

    transient private ArrayList<Safar> startingTerminalOfJourneys = new ArrayList<Safar>();
    transient private ArrayList<Safar> destinationTerminalOfJourneys = new ArrayList<Safar>();



    //=============================================================================================

    Terminal(int build_price , City city, String terminalName , String address , int area , int number_of_vehicles , int number_of_employees){
        this.build_price = build_price ;
        this.number_of_employees = number_of_employees ;
        this.city = city ;
        this.cityName = city.getCityName();
        this.terminalName = terminalName ;
        this.address = address ;
        this.area = area ;
        this.number_of_vehicles = number_of_vehicles ;
        totalTerminals.add(this);
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

    public static Terminal getTerminalByName(String name ){
        for (Terminal a : totalTerminals){
            if (a.terminalName.equals(name))
                return a;
        }

        throw new Invalid_TerminalName(name + " Terminal does not exists");
    }

    public String getTerminalType( ){
        if (this instanceof Airport)
            return "Airport";
        else if (this instanceof Bus_Terminal)
            return "BusTerminal";
        else if ( this instanceof ShippingPort)
            return "ShippingPort";
        else
            return "TrainStation";
    }

    public ArrayList<Person> getDriversList(){
        return driversList;
    }

//============================================================================================== Save and restore Terminals

    private void completeJourneyIDs (ArrayList<Safar> safars , ArrayList<String> ids){
        for (Safar s : safars )
            ids.add(s.getJourneyID());
    }

    private void completePeopleIDs (ArrayList<Person> people , ArrayList<Integer> ids){
        for (Person a : people)
            ids.add(a.getID());
    }

    private void completeVehicleIDs (){
        for (Vehicle v : this.vehiclesList)
            this.vehicleIDs.add(v.getID());
    }

    public void makeReadyForSaving() {

        completeJourneyIDs(this.startingTerminalOfJourneys , this.startingPointIDs);
        completeJourneyIDs( this.destinationTerminalOfJourneys , this.destinationPointIDs);
        completePeopleIDs(this.driversList , drverIDs);
        completePeopleIDs(this.employees , this.employeeIDs);
        completeVehicleIDs();

    }

    public  void restoreTerminal(){

        for (int id : this.employeeIDs)
            this.employees.add( Person.find_Person_from_ID(id));

        for (int id : this.drverIDs)
            this.driversList.add( Person.find_Person_from_ID(id));

        for (String id : this.vehicleIDs)
            this.vehiclesList.add( Vehicle.getVehicleByID(id));

        totalTerminals.add(this);

    }

//==============================================================================================



    @Override
    public void newJourney(Terminal startingTerminal , Terminal destinationTerminal , ArrayList<Person> passengerList , Person driver , Vehicle vehicle , String journeyID , int journeyDay , int journeyMonth , int price){

        Safar newSafar = new Safar(startingTerminal , destinationTerminal , passengerList ,driver , vehicle ,journeyID , journeyDay , journeyMonth , price);
//        this.safarList.add(newSafar);

        startingTerminal.driversList.remove(driver);
//        destinationTerminal.driversList.add(driver);

        startingTerminal.vehiclesList.remove(vehicle);
        destinationTerminal.vehiclesList.add(vehicle);

        startingTerminal.startingTerminalOfJourneys.add(newSafar);
        destinationTerminal.destinationTerminalOfJourneys.add(newSafar);


        startingTerminal.city.getPersonList().remove(driver);
        destinationTerminal.city.getPersonList().add(driver);
        destinationTerminal.add_Driver(driver);


        for ( Person a : passengerList){

                startingTerminal.city.getPersonList().remove(a);
                destinationTerminal.city.getPersonList().add(a);

        }

        System.out.println(journeyPrice(passengerList , price));
        startingTerminal.city.addBudget( journeyPrice( passengerList , price) );



    }

    @Override
    public ArrayList<Safar> sortJourneys(ArrayList<Safar> sa){
        Collections.sort(sa);
        return sa;
    }

    @Override
    public void journeyHistory(boolean startingTerminal , boolean destinationTerminal){
        if(startingTerminal){
            ArrayList<Safar> safar = sortJourneys(startingTerminalOfJourneys);
            for (Safar sa : safar)
                sa.printINFO();
        }
        System.out.println("********************************************************************************");
        if( destinationTerminal){
            ArrayList<Safar> safar = sortJourneys(destinationTerminalOfJourneys);
            for (Safar sa : safar)
                sa.printINFO();
        }
    }

    @Override
    public int journeyPrice ( ArrayList<Person> passengerList , int ticketPrice ){

        int total_journey_price = 0 ;
        for ( Person a : passengerList){

            if ( ! a.getHired() )
                total_journey_price +=ticketPrice;

        }

        return total_journey_price;
    }





}
