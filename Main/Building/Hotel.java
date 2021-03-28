package Main.Building;

import Main.Person;

import java.util.ArrayList;

public class Hotel {
    private String hotelName ;
    private int buildCost  ;
    private String address ;
    private int stars ;
    private int number_of_rooms ;
    private int builtRooms = 0 ;
    private int number_of_workers ;

    private ArrayList<Room> roomList = new ArrayList<Room>() ;
    private static ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
    private ArrayList<Person> employees = new ArrayList<Person>();

    enum Services {
        Breakfast , Lunch , Dinner , Pool ;
    }

    //======================================================================

    public Hotel(String hotelName, String address, int stars, int number_of_rooms, int number_of_workers){
        this.hotelName = hotelName ;
        this.buildCost =(number_of_rooms*150) + (number_of_workers*30 );
        this.number_of_workers = number_of_workers ;
        this.address = address ;
        this.stars = stars ;
        this.number_of_rooms = number_of_rooms;
        hotelsList.add(this);
    }

    //=======================================================================

    public void addRoom( int roomNumber , int number_of_beds , int roomArea , int fee_per_night ){
        if (this.roomList.size() <= this.number_of_rooms){

            this.roomList.add( new Room(roomNumber , number_of_beds , roomArea ,fee_per_night )) ;
            this.builtRooms++;

        }
        else
            System.out.println("You add maximum number of rooms for this hotel");
    }

    ArrayList <Room> getRoomList (){
        return roomList;
    }

    public static ArrayList<Hotel> getHotelsList (){ return hotelsList; }

    int getHotelPrice(){
        return this.buildCost ;
    }

    public int getNumber_of_rooms(){ return this.number_of_rooms; }

    public int getBuildedRooms() { return this.builtRooms; }

    public String getHotelName(){
        return this.hotelName;
    }

    public void showInfo(){
        System.out.println("Hotel name : " + hotelName);
        System.out.println("Address : " + address);
        System.out.println("Number of stars : " + stars);
        System.out.println("Maximum number of hotel rooms : " + number_of_rooms);
        System.out.println("Number of built rooms : " + builtRooms);
        System.out.println("Maximum number of employees : " + number_of_workers);
        System.out.println("Number of hired employees : " + employees.size());

        System.out.println("\n===================================================================\n");
    }

}

class Room{
    private int  roomNumber ;
    private int number_of_beds ;
    private int roomArea ;
    private int fee_per_night ;

    Room(int roomNumber , int number_of_beds , int roomArea , int fee_per_night){
        this.roomNumber = roomNumber ;
        this.number_of_beds = number_of_beds ;
        this.roomArea = roomArea ;
        this.fee_per_night = fee_per_night ;
    }
}
