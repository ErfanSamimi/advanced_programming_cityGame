package Main;

import Main.Building.Airport;
import Main.Building.Bus_Terminal;
import Main.Building.ShippingPort;
import Main.Building.TrainStation;
import Main.Vehicles.Air_transport_vehicle;

import java.util.Scanner;

public class City {
    static int total_money = 10000 ;
    public static void main (String [] args){


         buildTerminal();


        for (Airport a : Airport.getAirportsList())
            a.showInfo();

        for(Bus_Terminal a : Bus_Terminal.getBus_terminals_list())
            a.showInfo();

        for (ShippingPort a : ShippingPort.getShippingPortsList())
            a.showInfo();


        System.out.println("++++++++++  " + total_money);


    }


    static void buildTerminal(){
        System.out.println(" 1-Airport \n 2-Bus Terminal \n 3-Shipping port \n 4-Train station ");
        System.out.print("Enter your choice : ");
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

        System.out.println("Enter number of workers (30 $ for each worker): ");
//        sc.nextLine();
        int number_workers = sc.nextInt();
        System.out.println();


        int finalPrice = 1400 + number_workers*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this airport costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("Build this airport ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Airport newAirport = new Airport(international, runways, cityName, airportName, address, area, number_airplane, number_workers);
                total_money -= finalPrice ;
                System.out.println("Done");
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

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

         System.out.println("Enter number of workers (30 $ for each worker): ");
//        sc.nextLine();
         int number_workers = sc.nextInt();
         System.out.println();


         int finalPrice = 600 + number_workers*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this Bus terminal costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("Build this Bus terminal ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                Bus_Terminal newBusTerminal = new Bus_Terminal( cityName, busTerminalName , address, area, number_buses , number_workers);
                total_money -= finalPrice ;
                System.out.println("Done");
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");

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

        System.out.println("Enter number of workers (30 $ for each worker): ");
//        sc.nextLine();
        int number_workers = sc.nextInt();
        System.out.println();


        int finalPrice = 1000 + number_workers*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this shipping port costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("Build this shipping port ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                ShippingPort newShippingPort = new ShippingPort( waterfronts , cityName, shippingPortName , address, area, number_ships , number_workers);
                total_money -= finalPrice ;
                System.out.println("Done");
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");


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

        System.out.println("Enter number of workers (30 $ for each worker): ");
//        sc.nextLine();
        int number_workers = sc.nextInt();
        System.out.println();


        int finalPrice = 1100 + number_workers*30 ;

        if(finalPrice <= total_money ){
            System.out.println("Build this train station costs : " + finalPrice + " $\nand now you have " + total_money + "$");

            System.out.print("Build this train station ? (y/n) : ");
//            sc.next();
            String choice2 = sc.next() ;
//            System.out.println("**  " + choice2);


            if (choice2.equals("y")) {
                TrainStation newTrainStation = new TrainStation( inputRails , outputRails , cityName , trainStationName , address, area, number_trains , number_workers);
                total_money -= finalPrice ;
                System.out.println("Done");
            }
            else{
                System.out.println("Canceled !");
            }
        }
        else
            System.out.println("You dont have enough money ");
    }
}
