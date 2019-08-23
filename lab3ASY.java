import java.util.Scanner;
import java.io.*;

public class lab3ASY 
{
    public static void main (String [] args) throws IOException {

    	final int NUMLETTERS = 26, ASCII_OFFSET = 65;
    	
    	/* Create a Scanner object from standard input - keyboard */
    	Scanner in = new Scanner(System.in);
    	
    	/* Take the input file name from the user */
    	System.out.print("Filename to read a message: ");
    	String fn = in.nextLine();
   	
		/* Read messages from a file */
		//Do not use Paths in labs unless you setup your account for Version 7
		//Scanner reader =new Scanner(Paths.get(fn));   
    	Scanner reader =new Scanner(new File(fn));
		String clearText = reader.nextLine();
		reader.close();
    	
    	/* Convert characters to all upper case */
        char[] message = clearText.toUpperCase().toCharArray();
        System.out.println(message);
		
		/* Read cipher key from keyboard */
    	System.out.print("Cipher Key (-25 ~ 25): ");
    	int key = in.nextInt();

        /* Create an array to store the en/decrypted message */
        char[] eMessage = new char[message.length];
    	
        /* Insert your code here */
        
        for (int i = 0; i < message.length; i++){
            if (message[i] == ' '){
                eMessage[i] = ' ';
                continue;
            }
            eMessage[i] = (char)((((int)message[i] % ASCII_OFFSET) + NUMLETTERS + key) % NUMLETTERS + ASCII_OFFSET);
        }

        
        
    // DONE
        
        
        System.out.println(eMessage);
        
        /* Take the output file name from the user */
    	System.out.print("Filename to save the processed message: ");
    	String fn_out = in.next();

    	/* Save the processed message to the file */
        PrintWriter writer = new PrintWriter(fn_out);
        writer.println(eMessage);
        
		/* Release open resources */
        writer.close();
    	in.close();
    	
    }
}
