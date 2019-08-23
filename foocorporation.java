public class foocorporation{

    public static double wage_calculator(double wage, double hours){
        if (wage < 8.0) {
            System.out.println("Wage should not be under 8$ hourly");
            return 0.0;
        }
        
        if (hours <= 40.0){
            return wage * hours;

        } else if (hours > 40.0 && hours <=60.0){
            double overhours = hours - 40.0;
            return (40.0* wage + overhours * wage * 1.5);
        }else {
            System.out.println("Hours worked should be positive and cannot be over 60");
            return 0.0;
        }
        
        
    }
    public static void main(String[] args){

        double payout = wage_calculator(11, 70);
        System.out.println(payout);
    }
}