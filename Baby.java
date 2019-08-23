import java.util.Scanner;

public class Baby{
    private String name;
    private String sex;
    public double weight;
    private double decibel;
    private int poopCount;

    Baby(String babyName, String babySex, double babyWeight, double babyDecibel, int babyPoopCount){
        name = babyName;
        sex = babySex;
        weight = babyWeight;
        decibel = babyDecibel;
        poopCount = babyPoopCount;
    }

    void poop(){
        poopCount++;
        System.out.printf("I have pooped %d times%n", poopCount);
    }

    void eat(){
        Scanner scan = new Scanner(System.in);
        double foodWeight = scan.nextDouble();
        scan.close();
        if (foodWeight >= 0){
            weight += foodWeight;
        }
    }

    void sayHi(){
        System.out.printf("My name is %s. Hello world%n", name);
    }


}