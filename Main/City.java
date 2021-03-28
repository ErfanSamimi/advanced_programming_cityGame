package Main;

import Main.Building.*;
import Main.Vehicles.*;

import java.lang.annotation.Target;
import java.util.Random;
import java.util.Scanner;

public class City {
    static int total_money = 10000 ;
    public static void main (String [] args){

        addPeople(2 , "pilot" , 70);
        addPeople(3 , "pilot" , 80);
        addPeople( 4 , "driver" , 50);
        addPeople( 4 , "driver" , 55);
        addPeople(6 , "sailor" , 70);
        addPeople(2 , "sailor" , 74);
        addPeople(3 , "locomotive driver" , 70);
        addPeople(3 , "flight attendant" , 35);
        addPeople(2 , "flight attendant" , 40);
        addPeople( 20 , "employee" , 30);

        //=================================================================================


        mainMenu();




    }

    static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n 1-Build Terminal \n 2-Buy Vehicle \n 3-Engage \n 4-Build Hotel \n 5-Build Room For Hotels \n 6-Show Status ");
        System.out.print("\nEnter your choice : ");
        int choice = sc.nextInt();

        if(choice == 1)
            buildTerminal();

        if(choice == 2)
            buyVehicles();

        if(choice == 3)
            engage();

        if(choice == 4)
            buildHotel();

        if(choice == 5)
            build_Room_In_Hotel();

        if (choice == 6)
            showStatus();
    }

    static void showMoney(){
        System.out.println("\n+++ You have " + total_money + " $\n");
    }

    static void addPeople(int number_of_people , String job , int salary ){

        for (int i=0 ; i< number_of_people ; i++){

            Random rand = new Random();
            int ID = rand.nextInt(701);
            while (!Person.uniqID(ID)) {
                ID = rand.nextInt();
            }
            Person newPerson = new Person(job, salary, ID);
        }
    }

    //========================================================================================

    static void showStatus(){
        System.out.println("\n\n=== Show Status === \n");
        Scanner sc = new Scanner(System.in);

        System.out.println("****** population : \n");
        System.out.println("Your city population : " + Person.getPeopleList().size());
        System.out.println("Your city has " + Person.number_of_jobs("pilot") + " pilot(s)");
        System.out.println("Your city has " + Person.number_of_jobs("driver") + " driver(s)");
        System.out.println("Your city has " + Person.number_of_jobs("sailor") + " sailor(s)");
        System.out.println("Your city has " + Person.number_of_jobs("locomotive driver") + " locomotive driver(s)");
        System.out.println("Your city has " + Person.number_of_jobs("flight attendant") + " flight attendant(s)");
        System.out.println("Your city has " + Person.number_of_jobs("employee") + " employee(s)");



        System.out.println("\n\n****** Places : \n");
        System.out.println("You have " + Airport.getAirportsList().size() + " Airport(s)");
        System.out.println("You have " + Bus_Terminal.getBus_terminals_list().size() + " Bus Terminal(s)");
        System.out.println("You have " + Hotel.getHotelsList().size() + " Hotel(s)");
        System.out.println("You have " + ShippingPort.getShippingPortsList().size() + " Shipping Port(s)");
        System.out.println("You have " + TrainStation.getTrainStationsList().size() + " Train Station(s)");

        System.out.println("\n\n****** Vehicles : \n");
        System.out.println("You have " + Boat.getBoatsList().size() + " Boat(s)");
        System.out.println("You have " + Bus.getBusesList().size() + " Bus(es)");
        System.out.println("You have " + CargoPlane.getCargoPlanesList().size() + " Cargo Plane(s)");
        System.out.println("You have " + Passenger_airplane.getPassenger_airplanesList().size() + " Passenger Airplane(s)");
        System.out.println("You have " + Ship.getShipsList().size() + " Ship(s)");
        System.out.println("You have " + Train.getTrainsList().size() + " Train(s)");



        //=====================================================================================================================================

        System.out.print("\n\nDo you want to show more information ? (y/n) : ");
        String moreInfo = sc.nextLine();

        if (moreInfo.equals("y")){
            System.out.println("\n\n****** Show More Information ******\n");
            System.out.println(" 1-Airport(s) more info \n 2-Bus Terminal(s) more info \n 3-Hotel(s) more info \n 4-Shipping Port(s) more info \n 5-Train Station(s) more info ");
            System.out.print("\nEnter number of your choice : ");
            int choice = sc.nextInt();

            if (choice == 1)
                airportsInfo();

            if (choice == 2)
                busTerminalsInfo();

            if (choice == 3)
                hotelsInfo();

            if (choice == 4)
                shippingPortsInfo();

            if (choice == 5)
                trainStationsInfo();


        }
        else
            mainMenu();

    }

    static void airportsInfo(){
        System.out.println("\n\n=== Show More Information About Airplane(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all airports \n 2-Show information of a selected airport : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Airports ++++++\n");

            for (Airport a : Airport.getAirportsList())
                a.showInfo();

            System.out.println("\n\n Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Airport name " );
            for (Airport a : Airport.getAirportsList()){
                System.out.println(counter + "\t\t\t\t" + a.getName());
                counter++;
            }

            System.out.print("\nEnter number of airport : ");
            int numberAirport = sc.nextInt();
            System.out.println("\n\n");

            Airport.getAirportsList().get(numberAirport-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void busTerminalsInfo(){
        System.out.println("\n\n=== Show More Information About Bus Terminal(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all bus terminals \n 2-Show information of a selected bus terminal : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Bus Terminals ++++++\n");

            for (Bus_Terminal a : Bus_Terminal.getBus_terminals_list())
                a.showInfo();

            System.out.println("\n\n Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Bus terminal name " );
            for (Bus_Terminal a : Bus_Terminal.getBus_terminals_list()){
                System.out.println(counter + "\t\t\t\t\t" + a.getName());
                counter++;
            }

            System.out.print("\nEnter number of bus terminal : ");
            int numberBusTerminal = sc.nextInt();
            System.out.println("\n\n");

            Bus_Terminal.getBus_terminals_list().get(numberBusTerminal-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void hotelsInfo(){
        System.out.println("\n\n=== Show More Information About Hotel(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all hotels \n 2-Show information of a selected hotel : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Hotels ++++++\n");

            for (Hotel a : Hotel.getHotelsList())
                a.showInfo();

            System.out.println("\n\n Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Hotel name " );
            for (Hotel a : Hotel.getHotelsList()){
                System.out.println(counter + "\t\t\t\t" + a.getHotelName());
                counter++;
            }

            System.out.print("\nEnter number of hotel : ");
            int numberHotel = sc.nextInt();
            System.out.println("\n\n");

            Hotel.getHotelsList().get(numberHotel-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void shippingPortsInfo(){
        System.out.println("\n\n=== Show More Information About Shipping Port(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all shipping ports \n 2-Show information of a selected shipping port : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Shipping Ports ++++++\n");

            for (ShippingPort a : ShippingPort.getShippingPortsList())
                a.showInfo();

            System.out.println("\n\n Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Shipping port name " );
            for (ShippingPort a : ShippingPort.getShippingPortsList()){
                System.out.println(counter + "\t\t\t\t\t" + a.getName());
                counter++;
            }

            System.out.print("\nEnter number of shipping port : ");
            int numberShippingPort = sc.nextInt();
            System.out.println("\n\n");

            ShippingPort.getShippingPortsList().get(numberShippingPort-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }

    static void trainStationsInfo(){
        System.out.println("\n\n=== Show More Information About Train Station(s) ===\n");
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-Show information of all train stations \n 2-Show information of a selected train station : ");
        System.out.print("\nEnter number of your choice : ");
        int choice = sc.nextInt();

        if (choice == 1){
            System.out.println("\n\n++++++ Show Information Of All Train Stations ++++++\n");

            for (TrainStation a : TrainStation.getTrainStationsList())
                a.showInfo();

            System.out.println("\n\n Finished ");
            mainMenu();
        }

        else if (choice == 2 ){
            int counter = 1 ;

            System.out.println("Number : \t Train station name " );
            for (TrainStation a : TrainStation.getTrainStationsList()){
                System.out.println(counter + "\t\t\t\t\t" + a.getName());
                counter++;
            }

            System.out.print("\nEnter number of train station : ");
            int numberTrainStation = sc.nextInt();
            System.out.println("\n\n");

            TrainStation.getTrainStationsList().get(numberTrainStation-1).showInfo();

            mainMenu();

        }

        else
            mainMenu();
    }


    //=======================================================================================

    static void buildTerminal(){
        System.out.println("\n\n====== Build Terminal ======");
        System.out.println(" 1-Airport \n 2-Bus Terminal \n 3-Shipping port \n 4-Train station ");
        System.out.print("\nEnter your choice : ");
        Scanner sc = new Scanner(System.in) ;
        int choice = sc.nextInt();
        if (choice == 1){
            buildAirport();
        }
        else if (choice == 2){
            buildBusTerminal();
        }
        else if (choice == 3){
            buildShippingPort();
        }
        else if (choice == 4){
            buildTrainStation();
        }

        mainMenu();

    }

    static void buildAirport(){
        Scanner sc = new Scanner(System.in) ;

        System.out.println("\n\n=== Building Airport (1400 $)===\n\n" );
        System.out.print("Is it a International Airport ? (y/n) : ");
        String choice = sc.nextLine();
        boolean international ;
        if(choice.equals("y"))
            international = true ;
        else
            international = false ;

        System.out.println();

        System.out.print("Enter number of runways : ");
        int runways = sc.nextInt();
        System.out.println();

        System.out.print("Enter name of city : ");
        sc.nextLine();
        String cityName = sc.nextLine();
        System.out.println();

        System.out.print("Enter name of Airport : ");
//        sc.nextLine();
        String airportName = sc.nextLine();
        System.out.println();

        System.out.print("Enter address : ");
//        sc.nextLine();
        String address = sc.nextLine();
        System.out.println();

        System.out.print("Enter area of airport : ");
//        sc.nextLine();
        int area = sc.nextInt() ;
        System.out.println();

        System.out.print("Enter number of airplanes : ");
//        sc.nextLine();
        int number_airplane = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
        int number_employees = sc.nextInt();
        System.out.println();


        int finalPrice = 1400 + number_employees*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this airport costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("\nBuild this airport ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Airport newAirport = new Airport(international, runways, cityName, airportName, address, area, number_airplane, number_employees);
                total_money -= finalPrice ;
                System.out.println("Done");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

    }

    static  void buildBusTerminal(){
         Scanner sc = new Scanner(System.in) ;

         System.out.println("\n\n=== Bus Terminal (600 $)===\n\n" );


         System.out.print("Enter name of city : ");
//         sc.nextLine();
         String cityName = sc.nextLine();
         System.out.println();

         System.out.print("Enter name of bus terminal : ");
//        sc.nextLine();
         String busTerminalName = sc.nextLine();
         System.out.println();

         System.out.print("Enter address : ");
//        sc.nextLine();
         String address = sc.nextLine();
         System.out.println();

         System.out.print("Enter area of bus termianl : ");
//        sc.nextLine();
         int area = sc.nextInt() ;
         System.out.println();

         System.out.print("Enter number of Buses : ");
//        sc.nextLine();
         int number_buses = sc.nextInt();
         System.out.println();

         System.out.println("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
         int number_employees = sc.nextInt();
         System.out.println();


         int finalPrice = 600 + number_employees*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this Bus terminal costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("\nBuild this Bus terminal ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Bus_Terminal newBusTerminal = new Bus_Terminal( cityName, busTerminalName , address, area, number_buses , number_employees);
                total_money -= finalPrice ;
                System.out.println("Done");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

     }

    static void buildShippingPort(){
        Scanner sc = new Scanner(System.in) ;

        System.out.print("\n\n=== Shipping port (1000 $)===\n\n" );

        System.out.print("Enter number of waterfronts : ");
        int waterfronts = sc.nextInt();
        System.out.println();

        System.out.print("Enter name of city : ");
         sc.nextLine();
        String cityName = sc.nextLine();
        System.out.println();

        System.out.print("Enter name of shipping port : ");
//        sc.nextLine();
        String shippingPortName = sc.nextLine();
        System.out.println();

        System.out.print("Enter address : ");
//        sc.nextLine();
        String address = sc.nextLine();
        System.out.println();

        System.out.print("Enter area of shipping port : ");
//        sc.nextLine();
        int area = sc.nextInt() ;
        System.out.println();

        System.out.print("Enter number of ships and boats : ");
//        sc.nextLine();
        int number_ships = sc.nextInt();
        System.out.println();

        System.out.println("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
        int number_employees = sc.nextInt();
        System.out.println();


        int finalPrice = 1000 + number_employees*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this shipping port costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("\nBuild this shipping port ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                ShippingPort newShippingPort = new ShippingPort( waterfronts , cityName, shippingPortName , address, area, number_ships , number_employees);
                total_money -= finalPrice ;
                System.out.println("Done");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

    }

    static void buildTrainStation(){
        Scanner sc = new Scanner(System.in) ;

        System.out.print("\n\n=== Shipping port (1100 $)===\n\n" );

        System.out.print("Enter number of input rails : ");
        int inputRails = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of output rails : ");
        int outputRails = sc.nextInt();
        System.out.println();

        System.out.print("Enter name of city : ");
        sc.nextLine();
        String cityName = sc.nextLine();
        System.out.println();

        System.out.print("Enter name of train station : ");
//        sc.nextLine();
        String trainStationName = sc.nextLine();
        System.out.println();

        System.out.print("Enter address : ");
//        sc.nextLine();
        String address = sc.nextLine();
        System.out.println();

        System.out.print("Enter area of train station : ");
//        sc.nextLine();
        int area = sc.nextInt() ;
        System.out.println();

        System.out.print("Enter number of trains : ");
//        sc.nextLine();
        int number_trains = sc.nextInt();
        System.out.println();

        System.out.println("Enter number of employees (30 $ for each employee): ");
//        sc.nextLine();
        int number_employees = sc.nextInt();
        System.out.println();


        int finalPrice = 1100 + number_employees*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this train station costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("\nBuild this train station ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                TrainStation newTrainStation = new TrainStation( inputRails , outputRails , cityName , trainStationName , address, area, number_trains , number_employees);
                total_money -= finalPrice ;
                System.out.println("Done");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();
    }

    //==========================================================================================

    static void buyVehicles(){
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\n====== Buy vehicles ======");
        System.out.println(" 1-boat \n 2-bus \n 3-cargo plane \n 4-passenger airplane \n 5-ship \n 6-train ");
        System.out.print("\nEnter your choice : ");
        int choice = sc.nextInt() ;

        if(choice == 1)
            buyBoat() ;

        if(choice == 2)
            buyBus() ;

        if(choice == 3)
            buyCargoPlane() ;

        if(choice == 4)
            buyPassengerAirplane() ;

        if(choice == 5)
            buyShip() ;

        if(choice == 6)
            buyTrain() ;


        mainMenu();

    }

    static void buyBoat(){
        System.out.println("\n\n=== Buy Boat (300 $) ===");
        Scanner sc = new Scanner(System.in);

        if (ShippingPort.getShippingPortsList().size() == 0){
            System.out.println("You have no shipping port to buy a boat for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of bought vehicles : ");
            int counter = 1;
            for (ShippingPort a : ShippingPort.getShippingPortsList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter ++ ;
            }
            System.out.println("\n *** Completed ");
            System.out.print("\nEnter number of Shipping port that you want to buy a boat for it : ");
            int number_shippingPort = sc.nextInt();
            System.out.println();

            if (ShippingPort.getShippingPortsList().get(number_shippingPort-1).max_number_of_vehicle() == ShippingPort.getShippingPortsList().get(number_shippingPort-1).getNumber_of_bought_vehicles()){
                System.out.println("You bought maximum number of vehicle for this shipping port .");
                mainMenu();
            }


            //===========================================================================================================================


            System.out.print("Enter maximum distance that boat can go : ");
            int distance = sc.nextInt();
//        System.out.println("+++++  " + distance);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
//        System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter minimum water depth for boat : ");
            int min_depth = sc.nextInt();
//        System.out.println("+++++  " + min_depth);
            System.out.println();

            System.out.print("Enter capacity of boat : ");
            int capacity = sc.nextInt();
//        System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of boat : ");
            String ID = sc.nextLine();
//        System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of boat company : ");
            String company = sc.nextLine();
            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 300;

            if (finalPrice <= total_money) {
                System.out.println("Buy this boat costs : " + finalPrice + " $\nand now you have " + total_money + "$");

                System.out.print("\nBuy this boat ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Boat newBoat = new Boat(distance, fuel_type, min_depth, capacity, ID, company);
                    ShippingPort.getShippingPortsList().get(number_shippingPort - 1).addBoat(newBoat);
                    total_money -= finalPrice;
                    System.out.println("Done");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyBus(){
        System.out.println("\n\n=== Buy Bus (200 $) ===");
        Scanner sc = new Scanner(System.in);

        if (Bus_Terminal.getBus_terminals_list().size() == 0){
            System.out.println("You have no Bus terminal to buy a bus for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of bought vehicles : ");
            int counter = 1;
            for (Bus_Terminal a : Bus_Terminal.getBus_terminals_list()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter ++ ;
            }
            System.out.println("\n *** Completed ");
            System.out.print("\nEnter number of bus terminal that you want to buy a bus for it : ");
            int number_busTerminal = sc.nextInt();
            System.out.println();

            if (Bus_Terminal.getBus_terminals_list().get(number_busTerminal-1).max_number_of_vehicle() == Bus_Terminal.getBus_terminals_list().get(number_busTerminal-1).getNumber_of_bought_vehicles()){
                System.out.println("You bought maximum number of vehicle for this bus terminal .");
                mainMenu();
            }

            //===========================================================================================================================

            System.out.print("Enter type of bus class (business , economy ) : ");
            String classType = sc.nextLine();
            System.out.println("+++++  " + classType);
            System.out.println();

            System.out.println("Enter kilometer per liter : ");
            int kpl = sc.nextInt();
            System.out.println("+++++  " + kpl);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
            System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter max speed of this bus : ");
            int speed = sc.nextInt();
            System.out.println("+++++  " + speed);
            System.out.println();

            System.out.print("Enter passenger capacity of bus : ");
            int capacity = sc.nextInt();
            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of bus : ");
            String ID = sc.nextLine();
            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of bus company : ");
            String company = sc.nextLine();
            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 200;

            if (finalPrice <= total_money) {
                System.out.println("Buy this bus costs : " + finalPrice + " $\nand now you have " + total_money + "$");

                System.out.print("\nBuy this bus ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Bus newBus = new Bus(classType, kpl, capacity, fuel_type, speed, capacity, company, ID);
                    Bus_Terminal.getBus_terminals_list().get(number_busTerminal-1).addBus(newBus);
                    total_money -= finalPrice;
                    System.out.println("Done");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyCargoPlane(){
        System.out.println("\n\n=== Buy Cargo Plane (700 $) ===");
        Scanner sc = new Scanner(System.in);

        if (Airport.getAirportsList().size() == 0){
            System.out.println("You have no Airplane to buy a cargo plane for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of bought vehicles : ");
            int counter = 1;
            for (Airport a : Airport.getAirportsList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
            System.out.println("\n *** Completed ");
            System.out.print("\nEnter number of Airport that you want to buy a Cargo plane for it : ");
            int number_airport = sc.nextInt();
            System.out.println();

            if (Airport.getAirportsList().get(number_airport - 1).max_number_of_vehicle() == Airport.getAirportsList().get(number_airport - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this Airplane .");
                mainMenu();
            }

            //===========================================================================================================================

            System.out.print("Enter total weight this plane can transport : ");
            int weight = sc.nextInt();
            System.out.println("+++++  " + weight);
            System.out.println();

            System.out.print("Enter maximum height of flight : ");
            int height = sc.nextInt();
            System.out.println("+++++  " + height);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter runway length : ");
            int runway = sc.nextInt();
            System.out.println("+++++  " + runway);
            System.out.println();


            System.out.print("Enter passenger capacity of this plane ( max = 5 ) : ");
            int capacity = sc.nextInt();
            while (capacity > 5) {
                System.out.println("\nmaximum passenger capacity of plane is 5 , you entered : " + capacity);
                System.out.print("Enter passenger capacity of this plane ( max = 5 ) : ");
                capacity = sc.nextInt();
            }
            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of cargo plane : ");
            String ID = sc.nextLine();
            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of cargo plane company : ");
            String company = sc.nextLine();
            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 700;

            if (finalPrice <= total_money) {
                System.out.println("Buy this cargo plane costs : " + finalPrice + " $\nand now you have " + total_money + "$");

                System.out.print("\nBuy this cargo plane ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    CargoPlane newCargoPlane = new CargoPlane(weight, height, runway, capacity, ID, company);
                    Airport.getAirportsList().get(number_airport-1).addCargoAirplane(newCargoPlane);
                    total_money -= finalPrice;
                    System.out.println("Done");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyPassengerAirplane(){
        System.out.println("\n\n=== Buy Passenger Airplane (800 $) ===");
        Scanner sc = new Scanner(System.in);

        if (Airport.getAirportsList().size() == 0){
            System.out.println("You have no Airport to buy a passenger airplane for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of bought vehicles : ");
            int counter = 1;
            for (Airport a : Airport.getAirportsList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
            System.out.println("\n *** Completed ");
            System.out.print("\nEnter number of Airport that you want to buy a passenger airplane for it : ");
            int number_airport = sc.nextInt();
            System.out.println();

            if (Airport.getAirportsList().get(number_airport - 1).max_number_of_vehicle() == Airport.getAirportsList().get(number_airport - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this Airplane .");
                mainMenu();
            }

            //===========================================================================================================================

            System.out.print("Enter number of flight attendants: ");
            int flightAttendant = sc.nextInt();
            System.out.println("+++++  " + flightAttendant);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter type of airplane class (business , economy ) : ");
            String classType = sc.nextLine();
            System.out.println("+++++  " + classType);
            System.out.println();

            System.out.print("Enter maximum height of flight : ");
            int height = sc.nextInt();
            System.out.println("+++++  " + height);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter runway length : ");
            int runway = sc.nextInt();
            System.out.println("+++++  " + runway);
            System.out.println();


            System.out.print("Enter passenger capacity of this plane : ");
            int capacity = sc.nextInt();
            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of passenger airplane : ");
            String ID = sc.nextLine();
            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of cargo plane company : ");
            String company = sc.nextLine();
            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 800;

            if (finalPrice <= total_money) {
                System.out.println("Buy this passenger airplane costs : " + finalPrice + " $\nand now you have " + total_money + "$");

                System.out.print("\nBuy this passenger airplane ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Passenger_airplane newPassengerAirplane = new Passenger_airplane(flightAttendant, classType, height, runway, capacity, ID, company);
                    Airport.getAirportsList().get(number_airport-1).addPassengerAirplane(newPassengerAirplane);
                    total_money -= finalPrice;
                    System.out.println("Done");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyShip(){
        System.out.println("\n\n=== Buy Ship (600 $) ===");
        Scanner sc = new Scanner(System.in);

        if (ShippingPort.getShippingPortsList().size() == 0){
            System.out.println("You have no shipping port to buy a ship for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of bought vehicles : ");
            int counter = 1;
            for (ShippingPort a : ShippingPort.getShippingPortsList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
            System.out.println("\n *** Completed ");
            System.out.print("\nEnter number of Shipping port that you want to buy a ship for it : ");
            int number_shippingPort = sc.nextInt();
            System.out.println();


            if (ShippingPort.getShippingPortsList().get(number_shippingPort - 1).max_number_of_vehicle() == ShippingPort.getShippingPortsList().get(number_shippingPort - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this shipping port .");
                mainMenu();
            }

            //===========================================================================================================================

            System.out.print("Enter type of ship class (business , economy ) : ");
            String classType = sc.nextLine();
            System.out.println("+++++  " + classType);
            System.out.println();

            System.out.print("Enter length of this ship : ");
            int length = sc.nextInt();
            System.out.println("+++++  " + length);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
            System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter minimum water depth for ship : ");
            int min_depth = sc.nextInt();
            System.out.println("+++++  " + min_depth);
            System.out.println();

            System.out.print("Enter capacity of ship : ");
            int capacity = sc.nextInt();
            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of ship : ");
            String ID = sc.nextLine();
            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of ship company : ");
            String company = sc.nextLine();
            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 600;

            if (finalPrice <= total_money) {
                System.out.println("Buy this ship costs : " + finalPrice + " $\nand now you have " + total_money + "$");

                System.out.print("\nBuy this ship ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Ship newShip = new Ship(classType, length, fuel_type, min_depth, capacity, ID, company);
                    ShippingPort.getShippingPortsList().get(number_shippingPort - 1).addShip(newShip);
                    total_money -= finalPrice;
                    System.out.println("Done");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }
    }

    static void buyTrain(){
        System.out.println("\n\n=== Buy Train (500 $) ===");
        Scanner sc = new Scanner(System.in);


        if (TrainStation.getTrainStationsList().size() == 0){
            System.out.println("You have no Train Station to buy a train for it ! ");
            mainMenu();
        }
        else {

            System.out.println("number : \t maximum number of vehicles : \t number of bought vehicles : ");
            int counter = 1;
            for (TrainStation a : TrainStation.getTrainStationsList()) {
                System.out.println(counter + "\t\t\t\t\t\t" + a.max_number_of_vehicle() + "\t\t\t\t\t\t\t\t" + a.getNumber_of_bought_vehicles());
                counter++;
            }
            System.out.println("\n *** Completed ");
            System.out.print("\nEnter number of Train Station that you want to buy a train for it : ");
            int number_trainStation = sc.nextInt();
            System.out.println();


            if (TrainStation.getTrainStationsList().get(number_trainStation - 1).max_number_of_vehicle() == TrainStation.getTrainStationsList().get(number_trainStation - 1).getNumber_of_bought_vehicles()) {
                System.out.println("You bought maximum number of vehicle for this Train Station .");
                mainMenu();
            }


            //===============================================================================================================================


            System.out.print("Enter number of wagons : ");
            int wagons = sc.nextInt();
            System.out.println("+++++  " + wagons);
            System.out.println();

            System.out.print("Enter number of stars for this train : ");
            int stars = sc.nextInt();
            System.out.println("+++++  " + stars);
            System.out.println();

            System.out.print("Enter fuel capacity  : ");
            int fuel_capacity = sc.nextInt();
            System.out.println("+++++  " + fuel_capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter fuel type : ");
            String fuel_type = sc.nextLine();
            System.out.println("+++++  " + fuel_type);
            System.out.println();

            System.out.print("Enter max speed of this train : ");
            int speed = sc.nextInt();
            System.out.println("+++++  " + speed);
            System.out.println();

            System.out.print("Enter passenger capacity of train : ");
            int capacity = sc.nextInt();
            System.out.println("+++++  " + capacity);
            System.out.println();

            sc.nextLine();
            System.out.print("Enter ID of train : ");
            String ID = sc.nextLine();
            System.out.println("+++++  " + ID);
            System.out.println();

            System.out.print("Enter name of train company : ");
            String company = sc.nextLine();
            System.out.println("+++++  " + company);
            System.out.println();

            int finalPrice = 500;

            if (finalPrice <= total_money) {
                System.out.println("Buy this train costs : " + finalPrice + " $\nand now you have " + total_money + "$");

                System.out.print("\nBuy this train ? (y/n) : ");
//            sc.next();
                String choice2 = sc.next();
//            System.out.println("**  " + choice2);


                if (choice2.equals("y")) {
                    Train newTrain = new Train(wagons, stars, fuel_capacity, fuel_type, speed, capacity, company, ID);
                    TrainStation.getTrainStationsList().get(number_trainStation - 1).addTrain(newTrain);
                    total_money -= finalPrice;
                    System.out.println("Done");
                    showMoney();
                } else {
                    System.out.println("Canceled !");
                }
            } else
                System.out.println("You dont have enough money ");

            mainMenu();
        }

    }

    //==============================================================

    static void engage(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" 1-pilot \n 2-driver \n 3-sailor \n 4-locomotive driver \n 5-flight attendant");
        System.out.print("\nEnter your choice : ");
        int choice = sc.nextInt();
        String final_choice ="";
        if (choice == 1)
            engagePilot();

        if (choice == 2)
            engageDriver();

        if (choice == 3)
            engageSailor();

        if (choice == 4)
            engageLocomotiveDriver();

        if (choice == 5)
            engageFlightAttendant();

        mainMenu();

    }

    static void engagePilot(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n=== Engage Pilot ===");

        System.out.println("ID : \t Salary:");

        for (Person ap : Person.getPeopleList()){
            if(ap.getJob().equals("pilot") && ap.getHired() == false){
                System.out.println(ap.getID() + "\t\t\t " + ap.getSalary() );
            }
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter ID of your choice : ");
        int ID = sc.nextInt();

        int counter = 1;
        System.out.println("number : \t number of hired pilots : ");
        for (Airport a : Airport.getAirportsList()){
            System.out.println(counter + "\t\t\t\t\t" + a.numberOfHiredPilots());
            counter ++;
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter number of Airport you want hire a pilot for it : ");
        int numberAirplane = sc.nextInt() ;


        Person.engage(ID);
        Airport.getAirportsList().get(numberAirplane-1).addPilot(Person.find_Person_from_ID(ID)) ;
        total_money -= Person.find_Person_from_ID( ID ).getSalary();
        showMoney();
        mainMenu();


    }

    static void engageDriver(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n=== Engage Driver ===");

        System.out.println("ID : \t Salary:");

        for (Person ap : Person.getPeopleList()){
            if(ap.getJob().equals("driver") && ap.getHired() == false){
                System.out.println(ap.getID() + "\t\t\t " + ap.getSalary() );
            }
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter ID of your choice : ");
        int ID = sc.nextInt();

        int counter = 1;
        System.out.println("number : \t number of hired pilots : ");
        for (Bus_Terminal a : Bus_Terminal.getBus_terminals_list()){
            System.out.println(counter + "\t\t\t\t\t" + a.numberOfHiredDrivers());
            counter ++;
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter number of Bus Terminal you want hire a driver for it : ");
        int numberBusTerminal = sc.nextInt() ;


        Person.engage(ID);
        Bus_Terminal.getBus_terminals_list().get(numberBusTerminal-1).addDriver(Person.find_Person_from_ID(ID)); ;
        total_money -= Person.find_Person_from_ID( ID ).getSalary();
        showMoney();
        mainMenu();
    }

    static void engageSailor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n=== Engage Sailor ===");

        System.out.println("ID : \t Salary:");

        for (Person ap : Person.getPeopleList()){
            if(ap.getJob().equals("sailor") && ap.getHired() == false){
                System.out.println(ap.getID() + "\t\t\t " + ap.getSalary() );
            }
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter ID of your choice : ");
        int ID = sc.nextInt();

        int counter = 1;
        System.out.println("number : \t number of hired pilots : ");
        for (ShippingPort a : ShippingPort.getShippingPortsList()){
            System.out.println(counter + "\t\t\t\t\t" + a.numberOfHiredSailor());
            counter ++;
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter number of Shipping Port you want hire a sailor for it : ");
        int numberShppingPort = sc.nextInt() ;


        Person.engage(ID);
        ShippingPort.getShippingPortsList().get(numberShppingPort-1).addSailor(Person.find_Person_from_ID(ID)); ;
        total_money -= Person.find_Person_from_ID( ID ).getSalary();
        showMoney();
        mainMenu();
    }

    static void engageLocomotiveDriver(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n=== Engage Locomotive Driver ===");

        System.out.println("ID : \t Salary:");

        for (Person ap : Person.getPeopleList()){
            if(ap.getJob().equals("locomotive driver") && ap.getHired() == false){
                System.out.println(ap.getID() + "\t\t\t " + ap.getSalary() );
            }
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter ID of your choice : ");
        int ID = sc.nextInt();

        int counter = 1;
        System.out.println("number : \t number of hired pilots : ");
        for (TrainStation a : TrainStation.getTrainStationsList()){
            System.out.println(counter + "\t\t\t\t\t" + a.numberOfHiredLocomotiveDriver());
            counter ++;
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter number of Train Station you want hire a locomotive driver for it : ");
        int numberTrainStation = sc.nextInt() ;


        Person.engage(ID);
        TrainStation.getTrainStationsList().get(numberTrainStation-1).addLocomotiveDriver(Person.find_Person_from_ID(ID)); ;
        total_money -= Person.find_Person_from_ID( ID ).getSalary();
        showMoney();
        mainMenu();
    }

    static void engageFlightAttendant(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n=== Engage Flight Attendant ===");

        System.out.println("ID : \t Salary:");

        for (Person ap : Person.getPeopleList()){
            if(ap.getJob().equals("flight attendant") && ap.getHired() == false){
                System.out.println(ap.getID() + "\t\t\t " + ap.getSalary() );
            }
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter ID of your choice : ");
        int ID = sc.nextInt();

        int counter = 1;
        System.out.println("number : \t number of hired pilots : ");
        for (Airport a : Airport.getAirportsList()){
            System.out.println(counter + "\t\t\t\t\t" + a.numberOfHiredFlightAttendants());
            counter ++;
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter number of Airport you want hire a flight attendant for it : ");
        int numberAirplane = sc.nextInt() ;


        Person.engage(ID);
        Airport.getAirportsList().get(numberAirplane-1).addFlightAttendant(Person.find_Person_from_ID(ID)); ;
        total_money -= Person.find_Person_from_ID( ID ).getSalary();
        showMoney();
        mainMenu();
    }

    static void engageEmployee(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n=== Engage Employee ===");

        System.out.println("ID : \t Salary:");

        for (Person ap : Person.getPeopleList()){
            if(ap.getJob().equals("employee") && ap.getHired() == false){
                System.out.println(ap.getID() + "\t\t\t " + ap.getSalary() );
            }
        }
        System.out.println("\n** Completed\n");
        System.out.print("Enter ID of your choice : ");
        int ID = sc.nextInt();

        System.out.println(" 1-Airport \n 2-Bus Terminal \n 3-Hotel \n 4-Shipping Port \n 5-Train Station");
        System.out.print("\n Engage employee for : ");
        int employeeFor = sc.nextInt();

        if (employeeFor == 1 ){

            System.out.println("\n\n=== Engage Employee For Airport ===\n");

            int counter = 1;
            System.out.println("Number : \t Airplane name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (Airport a : Airport.getAirportsList()){
                System.out.println(counter + "\t\t\t" + a.getName() + "\t\t\t\t" + a.getNumber_of_employees() + "\t\t\t\t\t\t" + a.getNumber_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of airplane you want hire employee for that : ");
            int numberAirport = sc.nextInt();

            if(Airport.getAirportsList().get(numberAirport-1).getNumber_of_hired_employees() < Airport.getAirportsList().get(numberAirport-1).getNumber_of_employees() ){
                Person.engage(ID);
                Airport.getAirportsList().get(numberAirport-1).addEmployee( Person.find_Person_from_ID(ID));
                total_money -= Person.find_Person_from_ID( ID ).getSalary();
                showMoney();
                mainMenu();
            }
            else {
                System.out.println("You cant engage an employee for this airport ! ");
                mainMenu();
            }
        }


        else if (employeeFor == 2){

            System.out.println("\n\n=== Engage Employee For Bus Terminal ===\n");

            int counter = 1;
            System.out.println("Number : \t Bus terminal name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (Bus_Terminal a : Bus_Terminal.getBus_terminals_list()){
                System.out.println(counter + "\t\t\t" + a.getName() + "\t\t\t\t" + a.getNumber_of_employees() + "\t\t\t\t\t\t" + a.getNumber_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of bus terminal you want hire employee for that : ");
            int numberBusTerminal = sc.nextInt();

            if(Bus_Terminal.getBus_terminals_list().get(numberBusTerminal-1).getNumber_of_hired_employees() < Bus_Terminal.getBus_terminals_list().get(numberBusTerminal-1).getNumber_of_employees() ){
                Person.engage(ID);
                Bus_Terminal.getBus_terminals_list().get(numberBusTerminal-1).addEmployee( Person.find_Person_from_ID(ID));
                total_money -= Person.find_Person_from_ID( ID ).getSalary();
                showMoney();
                mainMenu();
            }
            else {
                System.out.println("You cant engage an employee for this bus terminal ! ");
                mainMenu();
            }

        }


        else if (employeeFor == 3 ){

            System.out.println("\n\n=== Engage Employee For Hotel ===\n");

            int counter = 1;
            System.out.println("Number : \t Hotel name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (Hotel a : Hotel.getHotelsList()){
                System.out.println(counter + "\t\t\t" + a.getHotelName() + "\t\t\t\t" + a.getNumber_of_Employees() + "\t\t\t\t\t\t" + a.getNumber_of_hired_Employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of hotel you want hire employee for that : ");
            int numberHotel = sc.nextInt();

            if(Hotel.getHotelsList().get(numberHotel-1).getNumber_of_hired_Employees() < Hotel.getHotelsList().get(numberHotel-1).getNumber_of_Employees() ){
                Person.engage(ID);
                Hotel.getHotelsList().get(numberHotel-1).addEmployee( Person.find_Person_from_ID(ID));
                total_money -= Person.find_Person_from_ID( ID ).getSalary();
                showMoney();
                mainMenu();
            }
            else {
                System.out.println("You cant engage an employee for this hotel ! ");
                mainMenu();
            }
        }


        else if (employeeFor == 4 ) {
            System.out.println("\n\n=== Engage Employee For Shipping Port ===\n");

            int counter = 1;
            System.out.println("Number : \t Shipping port name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (ShippingPort a : ShippingPort.getShippingPortsList()){
                System.out.println(counter + "\t\t\t" + a.getName() + "\t\t\t\t" + a.getNumber_of_employees() + "\t\t\t\t\t\t" + a.getNumber_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of Shipping port you want hire employee for that : ");
            int numberShippingPort = sc.nextInt();

            if(ShippingPort.getShippingPortsList().get(numberShippingPort-1).getNumber_of_hired_employees() < ShippingPort.getShippingPortsList().get(numberShippingPort-1).getNumber_of_employees() ){
                Person.engage(ID);
                ShippingPort.getShippingPortsList().get(numberShippingPort-1).addEmployee( Person.find_Person_from_ID(ID));
                total_money -= Person.find_Person_from_ID( ID ).getSalary();
                showMoney();
                mainMenu();
            }
            else {
                System.out.println("You cant engage an employee for this shipping port ! ");
                mainMenu();
            }
        }


        else if (employeeFor == 5){

            System.out.println("\n\n=== Engage Employee For Train Station ===\n");

            int counter = 1;
            System.out.println("Number : \t Train station name : \t Maximum number of employee : \t Number of hired employees :  ");
            for (TrainStation a : TrainStation.getTrainStationsList()){
                System.out.println(counter + "\t\t\t" + a.getName() + "\t\t\t\t" + a.getNumber_of_employees() + "\t\t\t\t\t\t" + a.getNumber_of_hired_employees());
                counter ++ ;
            }
            System.out.print("\nEnter number of train station you want hire employee for that : ");
            int numberTrainStation= sc.nextInt();

            if(TrainStation.getTrainStationsList().get(numberTrainStation-1).getNumber_of_hired_employees() < TrainStation.getTrainStationsList().get(numberTrainStation-1).getNumber_of_employees() ){
                Person.engage(ID);
                TrainStation.getTrainStationsList().get(numberTrainStation-1).addEmployee( Person.find_Person_from_ID(ID));
                total_money -= Person.find_Person_from_ID( ID ).getSalary();
                showMoney();
                mainMenu();
            }
            else {
                System.out.println("You cant engage an employee for this Train Station ! ");
                mainMenu();
            }
        }

    }

    //==============================================================

    static void buildHotel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n=== Build Hotel ===\n");

        System.out.print("Enter hotel name : ");
        String hotelName = sc.nextLine();
        System.out.println("++++  " + hotelName);
        System.out.println();

        System.out.print("Enter address of this hotel : ");
        String address = sc.nextLine();
        System.out.println("++++  " + address);

        System.out.println();

        System.out.print("Enter number of stars : ");
        int stars = sc.nextInt();
        System.out.println("++++  " + stars);
        System.out.println();

        System.out.print("Enter number of rooms (each room = 150 $) : ");
        int rooms = sc.nextInt() ;
        System.out.println("++++  " + rooms);
        System.out.println();

        System.out.print("Enter number of employees (each employee = 30 $) :  ");
        int employees = sc.nextInt() ;
        System.out.println();

        int finalPrice = (rooms * 150) + (employees * 30)  ;

        if(finalPrice <= total_money ){
            System.out.println("Build this Hotel costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("\nBuild this hotel ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Hotel newHotel = new Hotel(hotelName , address , stars , rooms ,employees );
                total_money -= finalPrice ;
                System.out.println("Done");
                showMoney();
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

        mainMenu();

    }

    static void build_Room_In_Hotel(){
        Scanner sc  = new Scanner(System.in);
        System.out.println("\n\n=== Build rooms in hotel ===");
        int counter = 1 ;
        System.out.println("number of hotel \t max number of rooms \t number of builded rooms");
        for (Hotel a : Hotel.getHotelsList()){
            System.out.println(counter + "\t\t\t\t\t\t" + a.getNumber_of_rooms() + "\t\t\t\t\t\t" + a.getBuildedRooms() );
            counter++;
        }

        System.out.print("Enter number of hotel : ");
        int numHotel = sc.nextInt();
        System.out.println("\n +++ Build a room for hotel " + numHotel + " +++");

        System.out.print("Enter room number : ");
        int roomNumber = sc.nextInt();
        System.out.println();

        System.out.print("Enter number of beds : ");
        int beds = sc.nextInt();
        System.out.println();

        System.out.print("Enter room area : ");
        int roomArea = sc.nextInt();
        System.out.println();

        System.out.print("Enter fee for one night : ");
        int fee = sc.nextInt();
        System.out.println();

        sc.nextLine();
        System.out.print("Are you sure to build this room ? (y/n) : ");
        String confirm = sc.nextLine();
        System.out.println();


        if (confirm.equals("y")){
            Hotel.getHotelsList().get(numHotel-1).addRoom(roomNumber , beds , roomArea , fee);
            System.out.println("\nDone");
        }
        else
            System.out.println("\nCanceled");


        mainMenu();


    }


}

