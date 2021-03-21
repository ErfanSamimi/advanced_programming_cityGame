package Main.Vehicles;

public class Bus extends Land_transport_vehicle{
    String class_type ; //business class , economy class
    int KPL ;  //kilometer per liter

    Bus(String class_type , int KPL , int fuel_capacity , String fuel_type , int speed , int price , int passenger_capacity , String name_company , String ID){
        super(fuel_capacity , fuel_type , speed , price , passenger_capacity , name_company , ID);
        this.class_type = class_type;
        this.KPL = KPL ;
    }
}
