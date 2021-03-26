package Main.Building;

import Main.Vehicles.Train;

import java.util.ArrayList;

public class TrainStation extends Terminal{
    private static ArrayList<Train> trainList = new ArrayList<Train>() ;
    private int inputRails ;
    private int outputRails ;

    //===============================================================

    TrainStation (int inputRails , int outputRails , String cityName , String terminalName , String address , int area , int number_of_vehicles){
        super(1100, cityName , terminalName , address ,area ,number_of_vehicles);

        this.inputRails = inputRails ;
        this.outputRails = outputRails ;
    }

    //================================================================

    void setTrainList(Train train){
        trainList.add(train) ;
    }

    ArrayList<Train> getTrainList (){
        return  trainList ;
    }
}
