/**
* CSIT111/CSIT811 Assignment 1
*
* Student name:Duong Quoc Nguyen
* Student user ID: qdn899
* Student number: 6562814
*/ 
import java.util.Scanner;

public class ATM{
    int currentAcc = 0;
    double saveBal;
    double checkBal;
    ATM(double saving, double checking){
        saveBal = saving;
        checkBal = checking;
        
    }
    void selectAccount(){

        System.out.println("1 - Savings");
        System.out.println("2 - Checkings");
        System.out.print("Which account:");
        Scanner userIn = new Scanner(System.in);
        currentAcc = Integer.parseInt(userIn.nextLine());
        System.out.println();
        //userIn.close();
        
    }

    int showMainMenu(){
        System.out.println("1 - Inquire Balance");
        System.out.println("2 - Withdraw");
        System.out.println("3 - Deposit");
        System.out.println("4 - Other account");
        System.out.println("0 - Quit");

        Scanner userIn = new Scanner(System.in);
        int userInput = Integer.parseInt(userIn.nextLine());
        //userIn.close();
        return userInput;
    }

    void deposit(double ammount){
        if(currentAcc == 1){
            saveBal+= ammount;
        }else if(currentAcc == 2){
            checkBal += ammount;
        }
        displayBalance();
    }

    void withdraw(double ammount){
        if(currentAcc==1){
            if (ammount > saveBal){
                System.out.println("Insufficient balance");
            }else{
                saveBal -= ammount;
            }
        }else if(currentAcc ==2){
            if (ammount > checkBal){
                System.out.println("Insufficient balance");
            }else{
                checkBal -= ammount;
            }
        }
        displayBalance();
    }

    void displayBalance(){
        if(currentAcc == 1){
            System.out.println("The current balance is $"+saveBal);
        }else if(currentAcc == 2){
            System.out.println("The current balance is $"+checkBal);
        }
    }
}