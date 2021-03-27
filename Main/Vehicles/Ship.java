package Main.Vehicles;

import java.util.ArrayList;

public class Ship extends Shipping_vehicle {
    private String classType ;
    private int shipLength ;
    private static ArrayList<Ship> shipsList = new ArrayList<Ship>();

    public Ship(String classType, int shipLength, String fuel_type, int min_depth, int capacity, String ID, String companyName){
        super(fuel_type , min_depth , 600 ,capacity ,ID ,companyName);
        this.classType = classType ;
        this.shipLength = shipLength;
        shipsList.add(this);
    }
}
