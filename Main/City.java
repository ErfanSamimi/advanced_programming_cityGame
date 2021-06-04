package Main;

import Main.Building.*;
import Main.Vehicles.*;

import java.io.*;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class City implements Serializable {

    private int budget;
    private String cityName;


    private ArrayList<Person> personList = new ArrayList<Person>();
    private static ArrayList<City> citiesList = new ArrayList<City>();

    //=================================================================================


    private ArrayList<Airport> cityAirportList = new ArrayList<Airport>();
    private ArrayList<Bus_Terminal> cityBusTerminalList = new ArrayList<Bus_Terminal>();
    private ArrayList<Hotel> cityHotelList = new ArrayList<Hotel>();
    private ArrayList<ShippingPort> cityShippingPortList = new ArrayList<ShippingPort>();
    private ArrayList<TrainStation> cityTrainStationList = new ArrayList<TrainStation>();

    //=================================================================================

//    private ArrayList<Boat> boatsList = getBoatsList();
//    private ArrayList<Bus> busesList = getBusesList() ;
//    private ArrayList<CargoPlane> cargoPlanesList = getCargoPlanesList();
//    private ArrayList<Passenger_airplane> passenger_airplanesList = getPassenger_airplanesList();
//    private ArrayList<Ship> shipsList = getShipsList() ;
//    private ArrayList<Train> trainsList = getTrainsList();


    //=================================================================================

    City(String cityName , int budget){
        this.budget = budget;
        this.cityName = cityName ;

        if (citiesList.size() == 0)
            addFirstPopulation();
        
        citiesList.add(this);
        try{
            saveCity();
        }
        catch (IOException ex){}
    }

//=================================================================================


    void addFirstPopulation (){

        addPeople(2 , "pilot" , 70);
        addPeople(3 , "pilot" , 80);
        addPeople( 4 , "driver" , 50);
        addPeople( 4 , "driver" , 55);
        addPeople(6 , "sailor" , 70);
        addPeople(2 , "sailor" , 74);
        addPeople(3 , "locomotive driver" , 70);
        addPeople(3 , "flight attendant" , 35);
        addPeople(2 , "flight attendant" , 40);
        addPeople( 20 , "employee" , 30);

        //=================================================================================


    }


    void addPeople(int number_of_people , String job , int salary ){

        for (int i=0 ; i< number_of_people ; i++){

            Random rand = new Random();
            int ID = rand.nextInt(701);
            while (!Person.uniqID(ID)) {
                ID = rand.nextInt(701);
            }
            Person newPerson = new Person(job, salary, ID ,true);
            this.personList.add(newPerson);
        }
    }

    //=================================================================================

    void addAirport (Airport a){
        this.cityAirportList.add(a);
    }

    void addBusTerminal (Bus_Terminal b){
        this.cityBusTerminalList.add(b);
    }

    void addHotel (Hotel h){
        this.cityHotelList.add(h);
    }

    void addShippingPort (ShippingPort sh){
        this.cityShippingPortList.add(sh);
    }

    void addTrainStation (TrainStation t){
        this.cityTrainStationList.add(t);
    }

    ArrayList<Terminal> getTerminalList(){
        ArrayList<Terminal> terminalList = new ArrayList<>();
        terminalList.addAll(getCityBusTerminalList());
        terminalList.addAll(getCityAirportList());
        terminalList.addAll(getCityShippingPortList());
        terminalList.addAll(getCityTrainStationList());

        return terminalList;
    }

//=================================================================================

    static ArrayList<City> getCitiesList (){
        return citiesList;
    }

    int getPopulation(){
        return this.personList.size();
    }

    public ArrayList<Person> getPersonList(){
        return this.personList;
    }

    int getBudget(){
        return this.budget;
    }

    public void addBudget( int value ){
        this.budget += value ;
    }

    public void setBudget(int value){
        this.budget = value;
    }

    public void withdrawalBudget(int value){
        this.budget -=value;
    }

    public String getCityName(){
        return this.cityName;
    }

    //=================================================================================

    ArrayList<Airport> getCityAirportList(){
        return this.cityAirportList;
    }

    ArrayList<ShippingPort> getCityShippingPortList (){
        return this.cityShippingPortList;
    }

    ArrayList<Bus_Terminal> getCityBusTerminalList(){
        return cityBusTerminalList;
    }

    ArrayList<TrainStation> getCityTrainStationList(){
        return cityTrainStationList;
    }

    ArrayList<Hotel> getCityHotelList(){
        return cityHotelList;
    }


    //=================================================================================

    ArrayList<Boat> getBoatsList (){
        ArrayList <Boat> boats = new ArrayList<>();
        for ( ShippingPort a : this.cityShippingPortList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Boat)
                    boats.add((Boat) b);
            }
        }
//        this.boatsList = boats ;
        return boats;
    }

    ArrayList<Bus> getBusesList (){
        ArrayList <Bus> buses = new ArrayList<>();
        for ( Bus_Terminal a : this.cityBusTerminalList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Bus)
                    buses.add((Bus) b);
            }
        }
//        this.busesList = buses ;
        return buses ;
    }

    ArrayList<CargoPlane> getCargoPlanesList (){

        ArrayList <CargoPlane> cargoPlanes = new ArrayList<>();
        for ( Airport a : this.cityAirportList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof CargoPlane)
                    cargoPlanes.add((CargoPlane) b);
            }
        }
//        this.cargoPlanesList = cargoPlanes ;
        return cargoPlanes ;
    }

    ArrayList<Passenger_airplane> getPassenger_airplanesList (){

        ArrayList <Passenger_airplane> passenger_airplanes = new ArrayList<>();
        for ( Airport a : this.cityAirportList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Passenger_airplane)
                    passenger_airplanes.add((Passenger_airplane) b);
            }
        }
//        this.passenger_airplanesList = passenger_airplanes ;
        return passenger_airplanes ;
    }

    ArrayList<Ship> getShipsList (){

        ArrayList <Ship> ships = new ArrayList<>();
        for ( ShippingPort a : this.cityShippingPortList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Ship)
                    ships.add((Ship) b);
            }
        }
//        this.shipsList = ships ;
        return ships ;
    }

    ArrayList<Train> getTrainsList (){

        ArrayList <Train> trains = new ArrayList<>();
        for ( TrainStation a : this.cityTrainStationList){
            for ( Vehicle b : a.getVehiclesList()){
                if (b instanceof Train)
                    trains.add((Train) b);
            }
        }
//        this.trainsList = trains ;
        return trains ;
    }


    void showInfo(){
        System.out.println("City name : " + this.cityName);
        System.out.println("City budget : " + this.budget);
        System.out.println("Population : " + this.personList.size());
        //TODO  Complete show info method in City.java


        System.out.println("\n-------------------------\n");
    }


    //=====================================================================================

    transient static boolean firstTimeSavingObject = true;

    void saveCity() throws IOException {

        FileOutputStream cities = new FileOutputStream("home/erfan/Projects/Java/Files/CityGame/cities.txt" , true);

        if (firstTimeSavingObject){
            ObjectOutputStream obOut = new ObjectOutputStream(cities);
            obOut.writeObject(this);
            firstTimeSavingObject = false;
            obOut.close();
            cities.close();
        }

        else {
            CustomObjectOutputClass obOut = new CustomObjectOutputClass(cities);
            obOut.writeObject(this);
            obOut.close();
            cities.close();
        }

    }

    void restoreCities() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream("home/erfan/Projects/Java/Files/CityGame/cities.txt");
        ObjectInputStream obIn = new ObjectInputStream(fin);

        try{
            while (true){
                City city = (City) obIn.readObject();
                citiesList.add(city);
            }
        }
        catch (EOFException ex){}

    }


}


class CustomObjectOutputClass extends ObjectOutputStream {


    CustomObjectOutputClass(OutputStream out) throws IOException {
        super (out);
    }
    @Override
    protected void writeStreamHeader(){}
}

