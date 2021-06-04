package Main.Vehicles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Passenger_airplane extends Air_transport_vehicle {

    private int number_of_flightAttendants;
    private String classType ;     // business class , economy class


    private static ArrayList<Passenger_airplane> passenger_airplanesList = new ArrayList<Passenger_airplane>() ;

    public Passenger_airplane(int number_of_flightAttendants, String classType, int max_flight_height, int runway_length
            , int capacity, String ID, String companyName){

        super(max_flight_height ,runway_length , 800 ,capacity ,ID ,companyName);
        this.number_of_flightAttendants = number_of_flightAttendants ;
        this.classType = classType;
        passenger_airplanesList.add(this);

    }


    public static ArrayList<Passenger_airplane> getPassenger_airplanesList(){
        return passenger_airplanesList;
    }


    public void saveBus() throws IOException {

        FileOutputStream fout = new FileOutputStream("home/erfan/Projects/Java/Files/CityGame/buses.csv" , true);
        PrintWriter pw = new PrintWriter(fout);

        pw.format("%s,%d,%d,%s,%d,%d,%s,%s\n" , this.class_type , this.KPL , this.fuel_capacity , this.class_type , this.speed , this.getCapacity() , this.getName_builder_company() , this.getID() );
        pw.close();
        fout.close();
    }

    public void restoreBuses() throws IOException {

        FileInputStream fin = new FileInputStream("home/erfan/Projects/Java/Files/CityGame/buses.csv" );
        Scanner sc = new Scanner(fin);

        while (sc.hasNextLine()) {

            String[] bus = sc.nextLine().split(",");

            Bus newBus = new Bus(bus[0]  ,  Integer.parseInt(bus[1]) , Integer.parseInt(bus[2])  , bus[3]  ,  Integer.parseInt(bus[4]) , Integer.parseInt(bus[5]) , bus[6] , bus[7] , false );

        }

        fin.close();
    }
}
