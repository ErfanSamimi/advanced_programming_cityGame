package Main.Building;

import Main.City;
import Main.CustomClasses.CustomObjectOutputClass;
import Main.Person;
import Main.Vehicles.Bus;

import java.io.*;
import java.util.ArrayList;

public class Bus_Terminal extends Terminal{


    private static ArrayList<Bus_Terminal> bus_terminals_list = new ArrayList<Bus_Terminal>();


    //=======================================================================

    public Bus_Terminal(City city, String terminalName, String address, int area, int number_of_vehicles, int number_of_employees){
        super(600 + number_of_employees*30,  city,terminalName ,address , area ,number_of_vehicles , number_of_employees);
        bus_terminals_list.add(this) ;
    }

    //=======================================================================
    public static ArrayList<Bus_Terminal> getBus_terminals_list(){
        return bus_terminals_list ;
    }





    public void showInfo(){

        System.out.println("City name : " + city.getCityName());
        System.out.println("Airport name : " + terminalName);
        System.out.println("Address : " + address );
        System.out.println("Area : " + area);
        System.out.println("Maximum number of vehicles : " + number_of_vehicles);
        System.out.println("Number of available vehicles : " + getNumber_of_bought_vehicles());
        System.out.println("Max number of  employees : " + number_of_employees);
        System.out.println("Number of hired employees : " + number_of_hired_employees());
        System.out.println("Number of drivers : " + number_of_hired_drivers());

        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }


    //=============================================================================================== Saving Airport




    public static boolean firstObjectSave = true;
    private static String address = "/home/erfan/Projects/Java/Files/CityGame/busTerminals.txt";

    public void saveBusTerminal() throws IOException {

        this.makeReadyForSaving();


        //---------------


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


    public static void restoreBusTerminals() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(address);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){
                Bus_Terminal newTerminal = (Bus_Terminal) obIn.readObject();


                newTerminal.restoreTerminal();

                bus_terminals_list.add( newTerminal );

            }
        }
        catch (EOFException ex){}


        fin.close();

    }

}
