/**
* CSIT111/CSIT811 Assignment 1
*
* Student name: Duong Quoc Nguyen
* Student user ID: qdn899
* Student number:6562814
*/ 
import java.util.Scanner;
import java.nio.file.*;
import java.io.*;

public class ATMApp{
    public static void main(String[] args) throws IOException{
        //TASK 1: 1st part
        String fileName = args[0];
       
        Scanner reader = new Scanner(Paths.get(fileName));
            String hashStr = reader.nextLine();
            String saveBalStr = reader.nextLine();
            String checkBalStr = reader.nextLine();
            reader.close();
    //Initial test to see if read file works 
        //System.out.println(hashStr);
        //System.out.println(saveBalStr);
        //System.out.println(checkBalStr);
        int saveBal = Integer.parseInt(saveBalStr);
        int checkBal = Integer.parseInt(checkBalStr);
        
    //2nd test
        //System.out.println(saveBal);
        //System.out.println(checkBal);
        //TASK 1: 2nd part
        long a = 2654435761L;
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your PIN: ");
        int userInput = in.nextInt();
        System.out.println();

        long hash = (long)((userInput*a)%(Math.pow(2.0, 32.0)));
        //System.out.println(hash);

        while(hash != Long.parseLong(hashStr)){
            System.out.print("Please enter your correct PIN: ");
            userInput = in.nextInt();
            System.out.println();
            hash = (long)((userInput*a)%(Math.pow(2.0, 32.0)));
        //    System.out.println(hash);
        }
        //in.close();
        //TASK 1: 3rd part
        ATM userAcc = new ATM(saveBal, checkBal);
        userAcc.selectAccount();
        int choice = userAcc.showMainMenu();

        while(choice != 0){
            if(choice == 1){
                userAcc.displayBalance();
                choice = userAcc.showMainMenu();
                continue;
            }else if(choice== 2){
                Scanner wit = new Scanner(System.in);
                System.out.print("Enter the amount to withdraw: $");
                double ammount = Double.parseDouble(wit.nextLine());
                System.out.println();
                userAcc.withdraw(ammount);
                choice = userAcc.showMainMenu();
                continue;
            }else if(choice == 3){
                Scanner dep = new Scanner(System.in);
                System.out.print("Enter the amount to deposit: $");
                double ammount = Double.parseDouble(dep.nextLine());
                System.out.println();
                userAcc.deposit(ammount);
                choice = userAcc.showMainMenu();
                continue;
            }else if(choice == 4){
                userAcc.selectAccount();
                choice = userAcc.showMainMenu();
            }
        }
        in.close();



    }
}