package Main.Building;

import Main.Vehicles.Shipping_vehicle;

import java.util.ArrayList;

public class ShippingPort extends  Terminal {
    private static ArrayList<Shipping_vehicle> shipList = new ArrayList<Shipping_vehicle>() ;
    private int number_of_waterfront ;

    //==========================================
     ShippingPort ( int number_of_waterfront , String cityName , String terminalName , String address , int area , int number_of_vehicles){
         super( 1000 , cityName , terminalName , address , area , number_of_vehicles);
         this.number_of_waterfront = number_of_waterfront ;
     }

     //==========================================

    void setShipList( Shipping_vehicle vehicle){
         shipList.add(vehicle);
    }

    ArrayList<Shipping_vehicle> getShipList () {
         return shipList ;
    }
}
