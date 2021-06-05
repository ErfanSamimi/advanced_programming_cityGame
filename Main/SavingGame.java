package Main;

import Main.Building.*;
import Main.Safar.Safar;
import Main.Vehicles.*;

import java.io.IOException;

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
}
