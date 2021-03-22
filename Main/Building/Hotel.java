package Main.Building;

import java.util.ArrayList;

public class Hotel {
    private String hotelName ;
    private int buildCost ;
    private String address ;
    private int stars ;
    private int number_of_rooms ;

    private ArrayList<Room> roomList = new ArrayList<Room>() ;

    enum Services {
        Breakfast , Lunch , Dinner , Pool ;
    }

    //======================================================================

    Hotel( String hotelName , int buildCost , String address , int stars , int number_of_rooms){
        this.hotelName = hotelName ;
        this.buildCost = buildCost ;
        this.address = address ;
        this.stars = stars ;
        this.number_of_rooms = number_of_rooms;
    }

    //=======================================================================

    void addRoom( int roomNumber , int number_of_beds , int roomArea , int fee_per_night ){
        if (this.roomList.size() <= this.number_of_rooms){

            this.roomList.add( new Room(roomNumber , number_of_beds , roomArea ,fee_per_night )) ;
        }
        else
            System.out.println("You add maximum number of rooms for this hotel");
    }

    ArrayList <Room> getRoomList (){
        return roomList;
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
