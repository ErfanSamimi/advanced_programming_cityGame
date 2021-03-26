package Main.Vehicles;

public class Ship extends Shipping_vehicle {
    private String classType ;
    private int shipLength ;

    Ship(String classType , int shipLength , String fuel_type , int min_depth , int capacity , String ID , String companyName){
        super(fuel_type , min_depth , 600 ,capacity ,ID ,companyName);
        this.classType = classType ;
        this.shipLength = shipLength;
    }
}
