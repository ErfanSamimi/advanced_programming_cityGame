package Main.Building;

import Main.City;
import Main.CustomClasses.CustomObjectOutputClass;
import Main.Person;
import Main.Vehicles.Train;

import java.io.*;
import java.util.ArrayList;

public class TrainStation extends Terminal{

    private static ArrayList<TrainStation> trainStationsList = new ArrayList<TrainStation>();

    private int inputRails ;
    private int outputRails ;


    //===============================================================

    public TrainStation (int inputRails , int outputRails , City city, String terminalName , String address , int area , int number_of_vehicles , int  number_of_employees  ){
        super(1100, city , terminalName , address ,area ,number_of_vehicles , number_of_employees);

        this.inputRails = inputRails ;
        this.outputRails = outputRails ;
        trainStationsList.add(this);
    }

    //================================================================

    public static ArrayList<TrainStation> getTrainStationsList(){
        return trainStationsList ;
    }


    public void showInfo(){
        System.out.println("Input rails " + inputRails);
        System.out.println("Output rails " + outputRails);
        System.out.println("City name : " + getCity().getCityName());
        System.out.println("Airport name : " + terminalName);
        System.out.println("Address : " + super.address );
        System.out.println("Area : " + area);
        System.out.println("Maximum number of vehicles : " + number_of_vehicles);
        System.out.println("Number of available vehicles : " + getNumber_of_bought_vehicles());
        System.out.println("Maximum number of  employees : " + number_of_employees);
        System.out.println("Number of hired employees : " + number_of_hired_employees());
        System.out.println("Number of locomotive drivers : " + number_of_hired_drivers());


        System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }




    //=============================================================================================== Saving Train station




    public static boolean firstObjectSave = true;
    private static String address = "/home/erfan/Projects/Java/Files/CityGame/trainStations.txt";

    public void saveTrainStation() throws IOException {

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

        this.startingPointIDs.removeAll(startingPointIDs);
        this.destinationPointIDs.removeAll(destinationPointIDs);
        this.driverIDs.removeAll(driverIDs);
        this.employeeIDs.removeAll(employeeIDs);
        this.vehicleIDs.removeAll(vehicleIDs);

    }


    public static void restoreTrainStations() throws IOException, ClassNotFoundException {

        FileInputStream fin = new FileInputStream(address);

        try{

            ObjectInputStream obIn = new ObjectInputStream(fin);

            while (true){

                TrainStation newStation = (TrainStation) obIn.readObject();


                newStation.restoreTerminal();

                trainStationsList.add(newStation);

            }
        }
        catch (EOFException ex){}


        fin.close();

    }


}
