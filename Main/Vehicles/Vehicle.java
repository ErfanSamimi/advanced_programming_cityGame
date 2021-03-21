package Main.Vehicles;

import javax.swing.*;
import java.util.ArrayList;

public class Vehicle {
    int price ;
    int capacity ;
    String ID ;
    String name_builder_company ;
    private static ArrayList<String> ID_list = new ArrayList<String>();
    //==================================================

    Vehicle(int price , int capacity , String ID , String name_builder_company){
        this.price = price ;
        this.capacity = capacity ;
        this.name_builder_company = name_builder_company ;
        if(ID_list.contains(ID)){
            System.out.println("This ID exists ! Please Set new ID for this vehicle .");
            this.ID ="00000000";
        }
        else
            this.ID =ID;

    }


}
