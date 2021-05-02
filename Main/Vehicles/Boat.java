package Main.Vehicles;

import java.util.ArrayList;

public class Boat extends Shipping_vehicle{
    private int max_distance ;
    private static ArrayList<Boat> boatsList = new ArrayList<Boat>() ;


    public Boat(int max_distance, String fuel_type, int min_depth, int capacity, String ID, String companyName){
        super(fuel_type , min_depth , 300 , capacity , ID , companyName);
        this.max_distance = max_distance;
        boatsList.add(this);
    }


    public static ArrayList<Boat> getBoatsList() { return boatsList; }
    public void showInfo(){
        System.out.println("max distance " + max_distance);
        System.out.println("fuel  " + fuel_type);
        System.out.println("min depth " + min_depth);

    }
}
