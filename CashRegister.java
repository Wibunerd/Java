/**
* CSIT111 or Assignment 3
*
* Student name: Quoc Duong Nguyen
* Student user ID: qdn899
* Student number: 6562814
*/
import java.util.ArrayList;
public class CashRegister {
    private static double dayPurchase;
	private int totalItems;
	private double purchase;
	private ArrayList<Integer> productQty = new ArrayList<>();
    private ArrayList<Double> productPrices = new ArrayList<>();
    private ArrayList<Double> subtotal = new ArrayList<>();
    private ArrayList<String> productName = new ArrayList<>();
	
	public void scanItems(Product obj){
        productName.add(obj.getName());
        productPrices.add(obj.getPrice());
        productQty.add(obj.getQuantity());
        subtotal.add(obj.getPrice()*obj.getQuantity());
        this.purchase += obj.getPrice()*obj.getQuantity();
        dayPurchase += this.purchase;
        totalItems+= obj.getQuantity();
        
	}
	
	public double getPurchase(){
		return this.purchase;
	}
	
	public int getTotal(){
		return totalItems;
	}

	public void scanAllItems(ArrayList<Product> obj){
		for(int i = 0; i< obj.size(); i++){
			scanItems(obj.get(i));
		}
	}

	public void printReceipt(){
		
        System.out.println("One customer is checking out...");
        String div1 = "=====================================================================";
        String div2 = "---------------------------------------------------------------------";
        String div3 = String.format("%69s","----------------------------------------");
        String legend = String.format("%-14s %-14s %-20s %-25s", "Product", "Price", "Qty", "Subtotal");
        ArrayList<String> productStr = new ArrayList<>();
        for(int i = 0; i<productPrices.size(); i++){
            productStr.add(String.format("%-14s %-14s %-20d %-25s", productName.get(i), "$"+productPrices.get(i), productQty.get(i), "$"+subtotal.get(i)));
        }
        String tot = String.format("%34s %25s %.2f", "Total","$", this.purchase);

        System.out.println(div1);
        System.out.println(legend);
        System.out.println(div2);
        for(int i = 0; i<productStr.size(); i++){
            System.out.println(productStr.get(i));
        }
        System.out.println(div3);
        System.out.println(tot);
        System.out.println(div1);
        
        this.totalItems = 0;
        this.purchase = 0;
        this.productQty.clear();
        this.productName.clear();
        this.productPrices.clear();
        this.subtotal.clear();
	}
}