package Main.Vehicles;

import java.util.ArrayList;

public class Train extends Land_transport_vehicle{

    enum Services {
        Restaurant , Breakfast , Lunch , Dinner
    }
    private  static ArrayList<Train> trainsList = new ArrayList<Train>();
    private int number_of_wagons ;
    private int stars ;

    public Train(int number_of_wagons, int stars, int fuel_capacity, String fuel_type, int speed, int passenger_capacity, String name_company, String ID){
        super(fuel_capacity , fuel_type ,speed ,500 ,passenger_capacity ,name_company , ID);
        this.number_of_wagons = number_of_wagons ;
        this.stars = stars ;
        trainsList.add(this);
    }

    public static ArrayList<Train> getTrainsList(){
        return trainsList;
    }
}


