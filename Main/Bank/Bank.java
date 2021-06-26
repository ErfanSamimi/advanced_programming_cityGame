package Main.Bank;

import java.util.ArrayList;

public class Bank {

    ArrayList<BankAccount> accounts = new ArrayList<>();
    String name ;
    double totalMoney = getTotalMoney();
    int activeAccounts = getActiveAccounts();


    public Bank(String name){
        this.name = name;
    }




    int getActiveAccounts(){
        int counter =0;

        for (BankAccount a : this.accounts){
            if (a.accountBalance != 0)
                counter ++;
        }


        return counter;
    }

    double getTotalMoney(){

        double money = 0;
        for(BankAccount a : this.accounts)
            money += a.accountBalance;

        return money;
    }
}
