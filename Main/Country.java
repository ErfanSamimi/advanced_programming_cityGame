package Main;

import java.util.ArrayList;

public class Country {

    static ArrayList<City> citiesList = City.getCitiesList();


    public static int totalPopulation (){

        int population =0 ;

        for (City c : citiesList){
            population += c.getPopulation();
        }

        return population;
    }

    public static int totalBudget(){

        int budget = 0 ;
        for (City c : citiesList){
            budget += c.getBudget();
        }

        return budget;
    }

    

}
