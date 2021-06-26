package Main.Bank;

import Main.City;
import Main.Exception.InvalidTransaction;
import Main.Person;

import java.util.ArrayList;

public class BankAccount implements Runnable {

    public  static boolean showLog = false;

    ArrayList<Transaction> accountTransactions = new ArrayList<>();
    double accountBalance;
    Person person;
    String userName ;
    String password;
    Bank bank ;
    City city;


    public BankAccount(double accountBalance , Person person , String userName , String password , Bank bank , City city){

        this.bank = bank;
        this.city = city;
        this.accountBalance = accountBalance ;
        this.person = person;
        this.userName = userName;
        this.password = password;

        Thread newThread = new Thread(this);
        newThread.start();

    }


    public void performTransaction(Transaction t){

        if(t.type == TransactionType.WITHDRAW) {

            if(t.amount > this.accountBalance)
                throw new InvalidTransaction("Transaction amount is more than account balance");

            this.accountBalance -= t.amount;
        }
        else
            this.accountBalance += t.amount;

        if (showLog){
            System.out.print(this.bank.getName() + "  " + this.city.getCityName() + "   " );
            t.showInfo();
            System.out.println("   " + this.accountBalance);
        }

    }



    void calculateProfit() throws InterruptedException {

        while (true){

            Thread.sleep(15000);

            if (this.accountBalance !=0 ){

                Transaction transaction = new Transaction(this.accountBalance*(15/100D) , TransactionType.PROFIT);
                this.accountTransactions.add(transaction);
                this.performTransaction(transaction);


            }

        }

    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }

    public ArrayList<Transaction> getAccountTransactions(){
        return this.accountTransactions;
    }

    @Override
    public void run(){

        try {
            this.calculateProfit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
