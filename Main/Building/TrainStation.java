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

    public TrainStation (int inputRails , int outputRails , String cityName , String terminalName , String address , int area , int number_of_vehicles , int  number_of_employees  ){
        super(1100, cityName , terminalName , address ,area ,number_of_vehicles , number_of_employees);

        this.inputRails = inputRails ;
        this.outputRails = outputRails ;
        trainStationsList.add(this);
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

    public String getName(){
        return terminalName ;
    }

    public void addEmployee(Person emp){
        super.setEmployees(emp);
    }

    public int getNumber_of_employees(){
        return number_of_employees;
    }

    public int getNumber_of_hired_employees(){
        return super.getEmployees().size();
    }

    public void showInfo(){
        System.out.println("Input rails " + inputRails);
        System.out.println("Output rails " + outputRails);
        System.out.println("City name : " + cityName);
        System.out.println("Airport name : " + terminalName);
        System.out.println("Address : " + address );
        System.out.println("Area : " + area);
        System.out.println("Maximum number of vehicles : " + number_of_vehicles);
        System.out.println("Number of bought vehicles : " + number_of_bought_vehicles);
        System.out.println("Maximum number of  employees : " + number_of_employees);
        System.out.println("Number of hired employees : " + super.getEmployees().size());
        System.out.println("Number of locomotive drivers : " + locomotiveDrivers.size());


        System.out.println("\n===================================================================\n");
    }

}
