package Main;

import Main.Building.*;
import Main.Vehicles.*;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class City {

    String cityName;


    private ArrayList<Airport> cityAirportList = new ArrayList<Airport>();
    private ArrayList<Bus_Terminal> cityBusTerminalList = new ArrayList<Bus_Terminal>();
    private ArrayList<Hotel> cityHotelList = new ArrayList<Hotel>();
    private ArrayList<ShippingPort> cityShippingPortList = new ArrayList<ShippingPort>();
    private ArrayList<TrainStation> cityTrainStaionList = new ArrayList<TrainStation>();
    private static ArrayList<City> citiesList = new ArrayList<City>();


    City(String cityName){
        this.cityName = cityName ;
        citiesList.add(this);
    }




    static void main (){

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


    }



    static void addPeople(int number_of_people , String job , int salary ){

        for (int i=0 ; i< number_of_people ; i++){

            Random rand = new Random();
            int ID = rand.nextInt(701);
            while (!Person.uniqID(ID)) {
                ID = rand.nextInt(701);
            }
            Person newPerson = new Person(job, salary, ID);
        }
    }

    void addAirport (Airport a){
        this.cityAirportList.add(a);
    }

    void addBusTerminal (Bus_Terminal b){
        this.cityBusTerminalList.add(b);
    }

    void addHotel (Hotel h){
        this.cityHotelList.add(h);
    }

    void addShippingPort (ShippingPort sh){
        this.cityShippingPortList.add(sh);
    }

    void addTrainStation (TrainStation t){
        this.cityTrainStaionList.add(t);
    }

     static ArrayList<City> getCitiesList (){
        return citiesList;
    }


}

