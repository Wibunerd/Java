/**
* CSIT111 Assignment 2
*
* Student name: Quoc Duong Nguyen
* Student user ID: qdn899
* Student number: 6562814
*/ 

public class MyDate{
    private int day;
    private int month;;
    private int year;

    public MyDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this. year = year;
    }   

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    public boolean isDateValid(){
        if(this.month > 12 || this.month <1){
            return false;
        }
        if((this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12)&&(this.day > 31 || this.day <1)){
            return false;
        }

        if((this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) && (this.day < 1 || this.day > 30)){
            return false;
        }

        if((this.year % 4 == 0 || (this.year % 100 == 0 && this.year%400 ==0)) && (this.day > 29 || this.day <1) && this.month == 2){
            return false;
        }

        if(this.year%4!=0 && (this.day > 28 || this.day < 1) && this.month == 2){
            return false;
        }

        if(this.year < 1582){
            return false;
        }else if(this.year == 1582 && this.month < 10){
            return false;
        }else if(this.year == 1582 && this.month == 10 && this.day < 15){
            return false;
        }

        return true;
    }

    public int numDayInMonth(){
        if(this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12){
            return 31;
        }

        if(this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11){
            return 30;
        }

        if(this.year % 4 == 0 || (this.year % 100 == 0 && this.year%400 ==0) && this.month == 2){
            return 29;
        }

        if(this.year%4!=0 && this.month == 2){
            return 28;
        }
        return -1;
    }
}