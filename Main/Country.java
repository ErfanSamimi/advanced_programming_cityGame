package Main;

import java.util.ArrayList;

public class Country {

    ArrayList<City> citiesList = City.getCitiesList();


    int totalPopulation (){

        int population =0 ;

        for (City c : citiesList){
            population += c.getPopulation();
        }

        return population;
    }

    int totalBudget(){

        int budget = 0 ;
        for (City c : citiesList){
            budget += c.getBudget();
        }

        return budget;
    }

    

}
