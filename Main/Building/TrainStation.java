package Main.Building;

import Main.Vehicles.Train;

import java.util.ArrayList;

public class TrainStation extends Terminal{
    private static ArrayList<Train> trainList = new ArrayList<Train>() ;
    int inputRails ;
    int outputRails ;

    //===============================================================

    TrainStation (int inputRails , int outputRails , int build_price , String cityName , String terminalName , String address , int area , int number_of_vehicles){
        super(build_price , cityName , terminalName , address ,area ,number_of_vehicles);

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
