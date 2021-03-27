package Main.Vehicles;

import java.util.ArrayList;

public class Bus extends Land_transport_vehicle{
    private String class_type ; //business class , economy class
    private int KPL ;  //kilometer per liter
    private static ArrayList<Bus> busesList = new ArrayList<Bus>() ;

    public Bus(String class_type, int KPL, int fuel_capacity, String fuel_type, int speed, int passenger_capacity, String name_company, String ID){
        super(fuel_capacity , fuel_type , speed , 200 , passenger_capacity , name_company , ID);
        this.class_type = class_type;
        this.KPL = KPL ;
        busesList.add(this);
    }
}
