package Main.Safar;

import Main.Building.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class Safar implements Comparable<Safar> {

    private Terminal startingTerminal;
    private Terminal destinationTerminal ;
    private ArrayList<Person> passengerList = new ArrayList<Person>();
    private Person driver ;
    private Vehicle vehicle;
    private String journeyID;
    private static ArrayList<String> idList = new ArrayList<>();
    private int journeyDay;
    private int journeyMonth;
    private int price ;

    Scanner sc = new Scanner(System.in);
    //=================================================================================================================


    public Safar (Terminal startingTerminal , Terminal destinationTerminal , ArrayList<Person> passengerList , Person driver , Vehicle vehicle , String journeyID , int journeyDay , int journeyMonth , int price ){
        this.startingTerminal = startingTerminal ;
        this.destinationTerminal = destinationTerminal ;
        this. passengerList = passengerList ;
        this.driver = driver ;
        this.vehicle = vehicle ;
        this.journeyDay = journeyDay ;
        this.journeyMonth = journeyMonth;
        this.price = price;

        System.out.println("********* " + idList);
        while ( idList.contains(journeyID) ){
            System.out.print("This id is already exists . Please enter new id for this journey : ");
            journeyID = sc.nextLine();
        }

        this.journeyID = journeyID ;
        idList.add(journeyID);

    }

    public int compareTo(Safar sa){
        if (this.journeyMonth > sa.journeyMonth)
            return 1;
        else if ( this.journeyMonth < sa.journeyMonth)
            return  -1;
        else if ( this.journeyDay > sa.journeyDay)
            return 1;
        else if (this.journeyDay < sa.journeyDay)
            return -1;

        else if (this.price > sa.price)
            return 1;
        else if (this.price < sa.price)
            return -1;

        return 0;
    }

    public void printINFO(){
        System.out.println("\nStarting terminal name : " + startingTerminal.getTerminalName());
        System.out.println("Destination terminal name : " + destinationTerminal.getTerminalName());
        System.out.println("Number of Passengers : " + this.passengerList.size());
        System.out.println("Journey id : " + journeyID);
        System.out.println("Date : " + journeyDay + " / " + journeyMonth);
        System.out.println("-------------------------------------------------------------");
    }


}
