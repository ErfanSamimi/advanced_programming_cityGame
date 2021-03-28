package Main.Building;

import Main.Person;
import Main.Vehicles.Shipping_vehicle;

import java.util.ArrayList;

public class ShippingPort extends  Terminal {
    private static ArrayList<Shipping_vehicle> shipList = new ArrayList<Shipping_vehicle>() ;
    private static ArrayList<ShippingPort> shippingPortsList = new ArrayList<ShippingPort>();
    private ArrayList<Person> sailors = new ArrayList<Person>();
    private int number_of_waterfront ;

    //==========================================
     public ShippingPort ( int number_of_waterfront , String cityName , String terminalName , String address , int area , int number_of_vehicles , int number_of_workers){
         super( 1000 + number_of_workers*30 , cityName , terminalName , address , area , number_of_vehicles , number_of_workers);
         this.number_of_waterfront = number_of_waterfront ;
         shippingPortsList.add(this);
     }

     //==========================================

    void setShipList( Shipping_vehicle vehicle){
         shipList.add(vehicle);
    }

    public ArrayList<Shipping_vehicle> getShipList () {
         return shipList ;
    }

    public static ArrayList<ShippingPort> getShippingPortsList(){ return shippingPortsList; } ;

    public int numberOfHiredSailor(){
        return sailors.size();
    }

    public void addSailor(Person sailor){
        sailors.add(sailor);
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
