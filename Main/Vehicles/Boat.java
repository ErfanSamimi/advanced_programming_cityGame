package Main.Vehicles;

public class Boat extends Shipping_vehicle{
    private int max_distance ;

    Boat(int max_distance , String fuel_type , int min_depth , int capacity , String ID , String companyName){
        super(fuel_type , min_depth , 300 , capacity , ID , companyName);
        this.max_distance = max_distance;
    }
}
