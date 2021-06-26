package Main.Bank;

import Main.Exception.InvalidTransaction;
import Main.Person;

import java.util.ArrayList;

public class BankAccount implements Runnable {

    ArrayList<Transaction> accountTransactions = new ArrayList<>();
    double accountBalance;
    Person person;
    String userName ;
    String password;


    public BankAccount(double accountBalance , Person person , String userName , String password ){

        this.accountBalance = accountBalance ;
        this.person = person;
        this.userName = userName;
        this.password = password;

        Thread newThread = new Thread(this);
        newThread.start();

    }


    void performTransaction(Transaction t){

        if(t.type == TransactionType.WITHDRAW) {

            if(t.amount > this.accountBalance)
                throw new InvalidTransaction("Transaction amount is more than account balance");

            this.accountBalance -= t.amount;
        }
        else
            this.accountBalance += t.amount;

    }



    void calculateProfit() throws InterruptedException {

        while (true){

            Thread.sleep(5000);

            if (this.accountBalance !=0 ){

                Transaction transaction = new Transaction(this.accountBalance*(15/100D) , TransactionType.PROFIT);
                this.accountTransactions.add(transaction);
                this.performTransaction(transaction);
                System.out.println(this.userName + "  " +this.accountBalance);

            }

        }

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
