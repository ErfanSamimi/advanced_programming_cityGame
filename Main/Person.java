package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    Scanner sc = new Scanner(System.in);

    private String firstname ;
    private String lastname ;
    private int birthDate ;
    private String birthPlace ;
    private String job ;
    private String gender ;
    private int salary ;
    private int ID ;
    private boolean hired = false ;
    private static ArrayList<Person> peopleList = new ArrayList<Person>() ;


    public Person(String job , int salary , int ID ){
        this(null , null , null , job , null , 0000 , salary , ID) ;
    }

    public Person(String firstname , String lastname , String birthPlace , String job , String gender , int birthDate , int salary , int ID ){
        this.firstname = firstname ;
        this.lastname = lastname ;
        this.birthDate = birthDate ;
        this.birthPlace = birthPlace ;
        this.job = job ;
        this.gender = gender ;
        this.salary = salary ;

        while ( ! uniqID(ID)){
            System.out.print("This ID is exists . Please enter a new ID : ");
            ID = sc.nextInt();
        }

        this.ID = ID ;
        peopleList.add(this);
    }

    public static ArrayList<Person> getPeopleList(){
        return peopleList ;
    }

    public static boolean uniqID(int id){
        for (Person a : peopleList){
            if (a.ID == id)
                return false;
        }
        return true ;
    }

    public int getID(){
        return this.ID;
    }

    public String getJob(){
        return this.job ;
    }

    public boolean getHired(){
        return this.hired;
    }

    public int getSalary(){
        return this.salary;
    }

    public static Person find_Person_from_ID(int ID){
        for (Person a : peopleList){
            if(a.ID == ID)
                return a;
        }
        return null;
    }

    public static void engage (int ID){
        for (Person a : peopleList){
            if(a.ID == ID) {
                a.hired = true;
                System.out.println("You engaged person " + ID + " as " + a.job + " with " + a.salary + "$");
            }
        }


    }
}
