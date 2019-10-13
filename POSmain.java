/**
* CSIT111 or Assignment 3
*
* Student name: Quoc Duong Nguyen
* Student user ID: qdn899
* Student number: 6562814
*/
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class POSmain{
    public static void main(String[] args) throws IOException{
        String productFile = args[0];
        String cart1File = args[1];
        String cart2File = args[2];
        Scanner productReader = new Scanner(Paths.get(productFile));
        Scanner cart1Reader = new Scanner(Paths.get(cart1File));
        Scanner cart2Reader = new Scanner(Paths.get(cart2File));
        
        ArrayList<String> products= new ArrayList<>();
        ArrayList<Double> prices = new ArrayList<>();
        String[] lineHolder= new String[2];
        ArrayList<Product> allProduct = new ArrayList<>();
        int productIndex = 0;
        while(productReader.hasNextLine()){
            String description = productReader.nextLine();
            description = description.strip();
            if(description == ""){
                continue;
            }
            description = description.replaceAll("\\s+", " ");
            lineHolder = description.split(" ");
            products.add(lineHolder[0]) ;
            prices.add(Double.parseDouble(lineHolder[1]));
            allProduct.add(new Product(products.get(productIndex), prices.get(productIndex)));
            productIndex++;
        }

        ArrayList<String> cart1Items = new ArrayList<>();
        ShoppingCart cart1 = new ShoppingCart();
        while(cart1Reader.hasNextLine()){
            String cart1Str = cart1Reader.nextLine().strip();
            if(cart1Str == ""){
                continue;
            }
            cart1Items.add(cart1Str); 
        }

        for(int j = 0; j<cart1Items.size(); j++){
            for(int i=0; i<allProduct.size(); i++){
                //System.out.print(cart1Items.get(j));
                //System.out.println(allProduct.get(i).getName());
                //System.out.println(cart1Items.get(j).equals(allProduct.get(i).getName()));
                if(cart1Items.get(j).equals(allProduct.get(i).getName())){
                    cart1.addItem(allProduct.get(i));
                    break;
                }
            }
        }
        //System.out.println(cart1.getTotalItems());

        ArrayList<String> cart2Items = new ArrayList<>();
        ShoppingCart cart2 = new ShoppingCart();
        while(cart2Reader.hasNextLine()){
            String cart2Str = cart2Reader.nextLine().strip();
            if(cart2Str == ""){
                continue;
            }
            cart2Items.add(cart2Str);        
        }

        for(int j = 0; j<cart2Items.size(); j++){
            for(int i=0; i<allProduct.size(); i++){
                if(cart2Items.get(j).equals(allProduct.get(i).getName())){
                    cart2.addItem(allProduct.get(i));
                    break;
                }
            }
        }
        //System.out.println(cart2Items.size());
        CashRegister reg = new CashRegister();       
        reg.scanAllItems(cart1.unloadAllItems());
        reg.printReceipt();
        reg.scanAllItems(cart2.unloadAllItems());
        reg.printReceipt();




    }
}