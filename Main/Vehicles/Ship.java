package Main.Vehicles;

public class Ship extends Shipping_vehicle {
    String classType ;
    int shipLength ;

    Ship(String classType , int shipLength , String fuel_type , int min_depth , int price , int capacity , String ID , String companyName){
        super(fuel_type , min_depth , price ,capacity ,ID ,companyName);
        this.classType = classType ;
        this.shipLength = shipLength;
    }
}
