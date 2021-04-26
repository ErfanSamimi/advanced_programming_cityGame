package Main.Safar;

import Main.Building.Terminal;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.util.ArrayList;

public class Safar implements Comparable<Safar> {

    private Terminal startingTerminal;
    private Terminal destinationTerminal ;
    private ArrayList<Person> passengerList = new ArrayList<Person>();
    private Person driver ;
    private Vehicle vehicle;
    private String journeyID;
    private int journeyDay;
    private int journeyMonth;
    private int price ;


    //=================================================================================================================


    public Safar (Terminal startingTerminal , Terminal destinationTerminal , ArrayList<Person> passengerList , Person driver , Vehicle vehicle , String journeyID , int journeyDay , int journeyMonth , int price ){
        this.startingTerminal = startingTerminal ;
        this.destinationTerminal = destinationTerminal ;
        this. passengerList = passengerList ;
        this.driver = driver ;
        this.vehicle = vehicle ;
        this.journeyID = journeyID ;
        this.journeyDay = journeyDay ;
        this.journeyMonth = journeyMonth;
        this.price = price;
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
        System.out.println("Starting terminal name : " + startingTerminal.getTerminalName());
        System.out.println("Destination terminal name : " + destinationTerminal.getTerminalName());
        System.out.println("Journey id : " + journeyID);
        System.out.println("Date : " + journeyID + " / " + journeyMonth);
        System.out.println("-------------------------------------------------------------");
    }


}
