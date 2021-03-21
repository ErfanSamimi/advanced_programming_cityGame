package Main.Vehicles;

public class Train extends Land_transport_vehicle{

    enum Services {
        Restaurant , Breakfast , Lunch , Dinner
    }

    int number_of_wagons ;
    int stars ;

    Train(int number_of_wagons , int stars , int fuel_capacity , String fuel_type , int speed , int price , int passenger_capacity , String name_company , String ID ){
        super(fuel_capacity , fuel_type ,speed ,price ,passenger_capacity ,name_company , ID);
        this.number_of_wagons = number_of_wagons ;
        this.stars = stars ;
    }
}


