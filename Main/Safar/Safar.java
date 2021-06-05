package Main.Safar;

import Main.Building.Terminal;
import Main.City;
import Main.CustomClasses.CustomObjectOutputClass;
import Main.Person;
import Main.Vehicles.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Safar implements Comparable<Safar> , Serializable {

    private Terminal startingTerminal;
    private Terminal destinationTerminal ;
    private ArrayList<Integer> passengersIDs = new ArrayList<>();
    int driverID;
    String vehicleID;
    private String journeyID;
    private int journeyDay;
    private int journeyMonth;
    private int price ;


    transient private ArrayList<Person> passengerList ;
    transient private Person driver ;
    transient private Vehicle vehicle;
    private static ArrayList<String> idList = new ArrayList<>();
    private static ArrayList<Safar> safars = new ArrayList<>();


    transient Scanner sc = new Scanner(System.in);
    //=================================================================================================================


    public Safar (Terminal startingTerminal , Terminal destinationTerminal , ArrayList<Person> passengerList , Person driver , Vehicle vehicle , String journeyID , int journeyDay , int journeyMonth , int price ){
        this.startingTerminal = startingTerminal ;
        this.destinationTerminal = destinationTerminal ;
        this. passengerList = passengerList ;
        this.driver = driver ;
        this.driverID = driver.getID();
        this.vehicle = vehicle ;
        this.vehicleID = vehicle.getID();
        this.journeyDay = journeyDay ;
        this.journeyMonth = journeyMonth;
        this.price = price;


        while ( idList.contains(journeyID) ){
            System.out.print("This id is already exists . Please enter new id for this journey : ");
            journeyID = sc.nextLine();
        }

        this.journeyID = journeyID ;
        idList.add(journeyID);
        safars.add(this);

    }

    public int compareTo(Safar sa){
        if (this.journeyMonth > sa.journeyMonth)
            return -1;
        else if ( this.journeyMonth < sa.journeyMonth)
            return  1;
        else if ( this.journeyDay > sa.journeyDay)
            return -1;
        else if (this.journeyDay < sa.journeyDay)
            return 1;

        else if (this.price > sa.price)
            return -1;
        else if (this.price < sa.price)
            return 1;

        return 0;
    }

    public void printINFO(){
        System.out.println("\nStarting terminal name : " + startingTerminal.getTerminalName());
        System.out.println("Destination terminal name : " + destinationTerminal.getTerminalName());
        System.out.println("Number of Passengers : " + this.passengerList.size());
        System.out.println("Journey id : " + journeyID);
        System.out.println("Date : " + journeyDay + " / " + journeyMonth);
        System.out.println("Ticket Price : " + this.price);
        System.out.println("-------------------------------------------------------------");
    }


    //================================================================================== Saving Safar

    void completePassengerIDs(){
        for (Person a : this.passengerList)
            this.passengersIDs.add(a.getID());
    }
    static void restorePassengersAndDriver(Safar safar){
        for (int id : safar.passengersIDs)
            safar.passengerList.add( Person.find_Person_from_ID(id) );

        safar.driver = Person.find_Person_from_ID( safar.driverID );
    }

    static boolean firstObjectSave = true;
    private static String address = "/home/erfan/Projects/Java/Files/CityGame/safars.txt";

    //----------------------------------------------------------------

    public void saveCity() throws IOException {

        completePassengerIDs();

        //----------------------------


        if (firstObjectSave){
            FileOutputStream fout = new FileOutputStream(address );
            ObjectOutputStream obOut = new ObjectOutputStream(fout);
            obOut.writeObject(this);
            firstObjectSave = false;
            obOut.close();
            fout.close();
        }

        else{
            FileOutputStream fout = new FileOutputStream(address , true);
            CustomObjectOutputClass obOut = new CustomObjectOutputClass(fout);
            obOut.writeObject(this);
            obOut.close();
            fout.close();
        }



    }



    public static void restoreCity() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(address);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){
                Safar newSafar = (Safar)obIn.readObject();

                newSafar.startingTerminal = Terminal.getTerminalByName( newSafar.startingTerminal.getTerminalName());
                newSafar.destinationTerminal = Terminal.getTerminalByName( newSafar.destinationTerminal.getTerminalName());
                restorePassengersAndDriver(newSafar);
                newSafar.vehicle = Vehicle.getVehicleByID( newSafar.vehicleID );

                Safar.safars.add(newSafar);
                Safar.idList.add(newSafar.journeyID);
            }
        }
        catch (EOFException ex){}


        fin.close();

    }


}
