package Main.Building;

import Main.Person;
import Main.Vehicles.Train;

import java.util.ArrayList;

public class TrainStation extends Terminal{
    private static ArrayList<Train> trainList = new ArrayList<Train>() ;
    private static ArrayList<TrainStation> trainStationsList = new ArrayList<TrainStation>();
    private ArrayList<Person> locomotiveDrivers = new ArrayList<Person>();
    private int inputRails ;
    private int outputRails ;
    private int number_of_bought_vehicles = 0;


    //===============================================================

    public TrainStation (int inputRails , int outputRails , String cityName , String terminalName , String address , int area , int number_of_vehicles , int  number_of_workers  ){
        super(1100, cityName , terminalName , address ,area ,number_of_vehicles , number_of_workers);

        this.inputRails = inputRails ;
        this.outputRails = outputRails ;
    }

    //================================================================

    public void addTrain(Train train){
        trainList.add(train) ;
        System.out.println("\nA Train added to " + this.terminalName + " Train Station . ");
        number_of_bought_vehicles ++ ;
    }

    public int max_number_of_vehicle (){
        return this.number_of_vehicles;
    }

    public int getNumber_of_bought_vehicles(){
        return this.number_of_bought_vehicles ;
    }

    ArrayList<Train> getTrainList (){
        return  trainList ;
    }

    public static ArrayList<TrainStation> getTrainStationsList (){ return trainStationsList ; }

    public int numberOfHiredLocomotiveDriver(){
        return locomotiveDrivers.size();
    }

    public void addLocomotiveDriver(Person driver){
        locomotiveDrivers.add(driver);
    }

    public void showInfo(){
        System.out.println("input rails " + inputRails);
        System.out.println("output rails " + outputRails);
        System.out.println("city name " + cityName);
        System.out.println("airport name : " + terminalName);
        System.out.println("address " + address );
        System.out.println("area " + area);
        System.out.println("vehicles " + number_of_vehicles);
        System.out.println("workers " + number_of_workers);
    }

}
