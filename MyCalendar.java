/**
* CSIT111 Assignment 2
*
* Student name: Quoc Duong Nguyen
* Student user ID: qdn899
* Student number: 6562814
*/ 
import java.util.Scanner;
import java.lang.Math;

class MyCalendar{
    private MyDate myDate;
    private enum Day{Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday, Error}

    public static void main(String[] args){
        System.out.print("Enter the date as day month year: ");
        Scanner input = new Scanner(System.in);
        String[] dayMonthYearStr = (input.nextLine().split(" "));
        int[] dayMonthYear = new int[3];
        for(int i=0; i < dayMonthYearStr.length; i++){
            dayMonthYear[i] = Integer.parseInt(dayMonthYearStr[i]);
        }
        MyCalendar thisDate = new MyCalendar(new MyDate(dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]));

        while(!(thisDate.myDate.isDateValid())){
            System.out.println("Please enter a valid date");
            System.out.print("Enter the date as day month year: ");
            dayMonthYearStr = (input.nextLine().split(" "));
            for(int i=0; i < dayMonthYearStr.length; i++){
                dayMonthYear[i] = Integer.parseInt(dayMonthYearStr[i]);
            }
            thisDate = new MyCalendar(new MyDate(dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]));
        }

        input.close();
        thisDate.printDateInfo();
        thisDate.printCalendar();

        
    }

    public MyCalendar(MyDate date){
        myDate = date;
    }

    public Day getDayOfWeek(){
        int h, q, m, k, j, y;
        q = myDate.getDay();
        
        if(myDate.getMonth() == 1){
            m = 13;
            y = myDate.getYear() - 1;
        }else if(myDate.getMonth() == 2){
            m = 14;
            y = myDate.getYear()-1;
        }else{
            m = myDate.getMonth();
            y = myDate.getYear();
        }
            k = y%100;
            j = y/100;

        h = (int)((q + (13*(m+1)/5)+ k + (k/4) + (j/4) + 5*j) % 7);

        switch (h){
            case 0:
                return Day.Saturday;
            case 1:
                return Day.Sunday;
            case 2:
                return Day.Monday;
            case 3: 
                return Day.Tuesday;
            case 4:
                return Day.Wednesday;
            case 5: 
                return Day.Thursday;
            case 6: 
                return Day.Friday;
        }
        
        return Day.Error;
    }


    public int getWeekOfMonth(){
        int currentDay = myDate.getDay();
        double weekDbl = currentDay / 7;
        int week = (int)weekDbl;
        if ((currentDay % 7) !=0){
            return week+1;
        }
        return week;
        /*System.out.println(myDate.getDay());
        System.out.println(currentDay/7);
        return 0;*/
    }

    public void printDateInfo(){
        Day dayOfWeek = getDayOfWeek();
        int week = getWeekOfMonth();
        String weekStr;
        switch (week){
            case 1: 
                weekStr ="first";
                break;
            case 2:
                weekStr = "second";
                break;
            case 3:
                weekStr = "third";
                break;
            case 4:
                weekStr = "fourth";
                break;
            case 5:
                weekStr = "fifth";
                break;
            default:
                weekStr = "error";
        }

        String monthStr;
        switch(myDate.getMonth()){
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            case 12:
                monthStr = "December";
                break;
            default:
                monthStr = "error";
        }

        String info = String.format("%02d/%02d/%d is a %s and located in the %s week of %s %d", myDate.getDay(), myDate.getMonth(), myDate.getYear(), dayOfWeek, weekStr, monthStr, myDate.getYear());

        System.out.println(info);
    }

    public void printCalendar(){
        String monthStr;
        switch(myDate.getMonth()){
            case 1:
                monthStr = "January";
                break;
            case 2:
                monthStr = "February";
                break;
            case 3:
                monthStr = "March";
                break;
            case 4:
                monthStr = "April";
                break;
            case 5:
                monthStr = "May";
                break;
            case 6:
                monthStr = "June";
                break;
            case 7:
                monthStr = "July";
                break;
            case 8:
                monthStr = "August";
                break;
            case 9:
                monthStr = "September";
                break;
            case 10:
                monthStr = "October";
                break;
            case 11:
                monthStr = "November";
                break;
            case 12:
                monthStr = "December";
                break;
            default:
                monthStr = "error";
        }

        int posFirstDay = findFirstDay(myDate.getDay(), getDayOfWeek());    //System.out.println(posFirstDay);
        int startFirstDay = 1; 
        int numDays =  myDate.numDayInMonth();      //System.out.println(numDays);
        int numDaysIndex = numDays+posFirstDay-1;     //System.out.println(numDaysIndex);

        String[] dayOfMonth = new String[38];

        for(int i=0; i<dayOfMonth.length; i++){
            if(i<posFirstDay || i > numDaysIndex){
                dayOfMonth[i] = " ";
            }else if(i>=posFirstDay && i <= numDaysIndex){
                dayOfMonth[i] = Integer.toString(startFirstDay);
                startFirstDay++;    
            }else{
                System.out.println("ERRROOOORRR");
            }
        }
        
        String line_1 = String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s", dayOfMonth[0], dayOfMonth[1], dayOfMonth[2], dayOfMonth[3], dayOfMonth[4], dayOfMonth[5], dayOfMonth[6]);
        String line_2 = String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s", dayOfMonth[7], dayOfMonth[8], dayOfMonth[9], dayOfMonth[10], dayOfMonth[11], dayOfMonth[12], dayOfMonth[13]);
        String line_3 = String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s", dayOfMonth[14], dayOfMonth[15], dayOfMonth[16], dayOfMonth[17], dayOfMonth[18], dayOfMonth[19], dayOfMonth[20]);
        String line_4 = String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s", dayOfMonth[21], dayOfMonth[22], dayOfMonth[23], dayOfMonth[24], dayOfMonth[25], dayOfMonth[26], dayOfMonth[27]);
        String line_5 = String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s", dayOfMonth[28], dayOfMonth[29], dayOfMonth[30], dayOfMonth[31], dayOfMonth[32], dayOfMonth[33], dayOfMonth[34]);
        String line_6 = String.format("%-5s %-5s %-5s", dayOfMonth[35], dayOfMonth[36], dayOfMonth[37]);
        

        String title = String.format("The calendar of %s %d is:", monthStr, myDate.getYear());
        String field = String.format("%-5s %-5s %-5s %-5s %-5s %-5s %-5s", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");


        System.out.println(title);
        System.out.println();
        System.out.println(field);
        System.out.println(line_1);
        System.out.println(line_2);
        System.out.println(line_3);
        System.out.println(line_4);
        System.out.println(line_5);
        System.out.println(line_6);

        

    }

    public int findFirstDay(int date, Day weekDate){
        //Find position of first day of the month. Sun:0, Mon:1, Tue:2, Wed:3, Thu:4, Fri:5, Sat:6
        int pos;
        switch(weekDate){
            case Sunday:
                pos = 0;
                break;
            case Monday:
                pos = 1;
                break;
            case Tuesday:
                pos = 2;
                break;
            case Wednesday:
                pos = 3;
                break;
            case Thursday:
                pos = 4;
                break;
            case Friday:
                pos = 5;
                break;
            case Saturday:
                pos = 6;
                break;
            default:
                pos = -1;
        }
        /*
        String[] daysInWeek = new String[14];
        daysInWeek = {0, 1, 2, 3, 4, 5, 6, 0, 1, 2, 3, 4, 5, 6};*/
        
        int index = 7 - (date%7) + 1;
        pos += index;
        return (pos%7);
    }

    

}