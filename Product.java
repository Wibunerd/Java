/**
* CSIT111/CSIT811 Assignment 3
*
* Student name:  Quoc Duong Nguyen
* Student user ID: qdn899
* Student number:6562814
*/ 
public class Product {
	private String name;
	private double price;
	private int productID;
    private static int total;
    private int qty;
	
	Product(String productName, double productPrice){
		name = productName;
		price = productPrice;
		total++;
        productID = total;
        qty++;
	}
	
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	public void changePrice(double newPrice){
		price = newPrice;
	}
	public int getProductID(){
		return productID;
	}
	public static int getTotal(){
		return total;
    }
    
    public int getQuantity(){
        return qty;
    }

	public void addQty(){
        qty++;
    }
}