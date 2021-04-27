package Main.Vehicles;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle {
    private int price ;
    private int capacity ;
    private String ID ;
    private String name_builder_company ;
    private static ArrayList<String> ID_list = new ArrayList<String>();
    private static int ticketPrice = 0;

    //==================================================

    Vehicle(int price , int capacity , String ID , String name_builder_company){
        Scanner sc = new Scanner(System.in);
        this.price = price ;
        this.capacity = capacity ;
        this.name_builder_company = name_builder_company ;
        while (ID_list.contains(ID)){
            System.out.print("This ID exists ! Please Set new ID for this vehicle : ");
            ID = sc.nextLine();
        }

        this.ID = ID;
        ID_list.add(ID);



    }

    public int getTicketPrice(){
        return ticketPrice;
    }




}
