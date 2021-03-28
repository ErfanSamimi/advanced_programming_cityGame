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
     public ShippingPort ( int number_of_waterfront , String cityName , String terminalName , String address , int area , int number_of_vehicles , int number_of_workers){
         super( 1000 + number_of_workers*30 , cityName , terminalName , address , area , number_of_vehicles , number_of_workers);
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


     public void showInfo(){
        System.out.println("runways " + number_of_waterfront);
        System.out.println("city name " + cityName);
        System.out.println("airport name : " + terminalName);
        System.out.println("address " + address );
        System.out.println("area " + area);
        System.out.println("vehicles " + number_of_vehicles);
        System.out.println("workers " + number_of_workers);
    }
}
