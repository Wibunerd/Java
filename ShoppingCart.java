/**
* CSIT111 or Assignment 3
*
* Student name: Quoc Duong Nguyen
* Student user ID: qdn899
* Student number: 6562814
*/ 
import java.util.ArrayList;
public class ShoppingCart{
    private ArrayList<Product> items = new ArrayList<>();
    private int totalItems;
    private static int totalCarts;


    public int addItem(Product obj){
        if(totalItems == 0){
            totalCarts++;
        }
        for(int i = 0; i< items.size(); i++){
            if(items.get(i)==obj){
                items.get(i).addQty();
                totalItems++;
                return 0;
            }
        }
        items.add(obj);;
        totalItems++;
        return 0;
    }

    public int getTotalItems(){
        return this.totalItems;
    }

    public static int getTotalCarts(){
        return totalCarts;
    }

    public ArrayList<Product> unloadAllItems(){
        totalCarts--;
        this.totalItems = 0;
        return items;
    }
}