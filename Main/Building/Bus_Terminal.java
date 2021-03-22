package Main.Building;

import Main.Vehicles.Bus;

import java.util.ArrayList;

public class Bus_Terminal extends Terminal{
    private static ArrayList<Bus> busesList = new ArrayList<Bus>();

    //=======================================================================

    Bus_Terminal(int build_price , String cityName , String terminalName , String address , int area , int number_of_vehicles){
        super(build_price , cityName ,terminalName ,address , area ,number_of_vehicles);
    }

    //=======================================================================

    void setBusesList(Bus bus){
        busesList.add(bus);
    }

    ArrayList<Bus> getBusesList(){
        return busesList ;
    }

}
