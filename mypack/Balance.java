package mypack;

public class Balance{
    String name;
    double bal;
    Balance(String name, double bal){
        this.name = name;
        this.bal = bal;
    }
    void show(){
        if(this.bal<0){
            System.out.println("You owe "+ (-this.bal));
        }
        System.out.println("Mr/Mrs: "+ this.name+ " Account Balance: "+ this.bal);
    }
}