package Main.Building;

import Main.Person;
import Main.Vehicles.Boat;
import Main.Vehicles.Shipping_vehicle;

import java.util.ArrayList;

public class ShippingPort extends  Terminal {
    private ArrayList<Shipping_vehicle> shipList = new ArrayList<Shipping_vehicle>() ;
    private ArrayList<Boat> boatsList = new ArrayList<Boat>();
    private static ArrayList<ShippingPort> shippingPortsList = new ArrayList<ShippingPort>();
    private ArrayList<Person> sailors = new ArrayList<Person>();
    private int number_of_waterfront ;
    private int number_of_bought_vehicles = 0;

    //==========================================
     public ShippingPort ( int number_of_waterfront , String cityName , String terminalName , String address , int area , int number_of_vehicles , int number_of_employees){
         super( 1000 + number_of_employees*30 , cityName , terminalName , address , area , number_of_vehicles , number_of_employees);
         this.number_of_waterfront = number_of_waterfront ;
         shippingPortsList.add(this);
     }

     //==========================================

    public void addShip( Shipping_vehicle vehicle){

         shipList.add(vehicle);
         System.out.println("\nA ship added to " + this.terminalName + " Shipping Port . ");
         number_of_bought_vehicles++;


    }

    public  ArrayList<Shipping_vehicle> getShipList () {
         return shipList ;
    }

    public static ArrayList<ShippingPort> getShippingPortsList(){ return shippingPortsList; } ;

    public int numberOfHiredSailor(){
        return sailors.size();
    }

    public void addSailor(Person sailor){
        sailors.add(sailor);
    }

    public void addBoat(Boat boat){

        this.boatsList.add(boat);
        System.out.println("\nA boat added to " + this.terminalName + " Shipping Port . ");
        number_of_bought_vehicles ++;
    }

    public int max_number_of_vehicle (){
        return this.number_of_vehicles;
    }

    public int getNumber_of_bought_vehicles(){
        return this.number_of_bought_vehicles ;
    }

    public String getName(){
        return terminalName;
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
         System.out.println("Number of waterfronts :  " + number_of_waterfront);
         System.out.println("City name : " + cityName);
         System.out.println("Airport name : " + terminalName);
         System.out.println("Address : " + address );
         System.out.println("Area : " + area);
         System.out.println("Maximum number of vehicles : " + number_of_vehicles);
         System.out.println("Number of bought vehicles : " + number_of_bought_vehicles);
         System.out.println("Number of ships : " + shipList.size());
         System.out.println("Number of boats : " + boatsList.size());
         System.out.println("Maximum number of  employees : " + number_of_employees);
         System.out.println("Number of hired employees : " + super.getEmployees().size());
         System.out.println("Number of sailors : " + sailors.size());

         System.out.println("\n===================================================================\n");

     }
}
