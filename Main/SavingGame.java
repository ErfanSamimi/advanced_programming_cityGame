package Main;

import Main.Building.*;
import Main.Safar.Safar;
import Main.Vehicles.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class SavingGame {

    static void restoreGame() throws IOException, ClassNotFoundException {

        Person.restorePeople();

        //-------------------------

        Boat.restoreBoats();
        Bus.restoreBuses();
        CargoPlane.restoreCargoPlane();
        Passenger_airplane.restorePassenger_airplane();
        Ship.restoreShips();
        Train.restoreTrains();

        //-------------------------

        Hotel.restoreHotel();
        Airport.restoreAirports();
        Bus_Terminal.restoreBusTerminals();
        ShippingPort.restoreShippingPorts();
        TrainStation.restoreTrainStations();

        //-------------------------

        Safar.restoreSafars();

        //-------------------------

        City.restoreCity();

        //-------------------------



    }

    static void clearAllFiles()   {
        try {
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/people.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/trainStations.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/shippingPorts.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/hotels.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/cities.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/busTerminals.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/airports.txt");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/safarIDs.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/trains.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/ships.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/buses.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/boats.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/cargoPlanes.csv");
            clear_a_file("/home/erfan/Projects/Java/Files/CityGame/passenger_airplanes.csv");
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    static void clear_a_file(String address) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(address);
        pw.close();

    }


}
