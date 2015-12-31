package CaesarCipherEncrypt;

//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Arrays;
import java.util.Scanner;

//import edu.duke.DirectoryResource;
//import edu.duke.FileResource;

/**
 * This is a wrapper class for CaesarCipherTwo class. Enables the Caesar Cipher class to be triggered in following ways
 * 1. Input a String and keys for encryption
 * 2. Input a String for decryption
 * 3. Encrypt a single file and then decrypt the same
 * 4. Encrypt multiple files and then decrypt them
 * 
 * @author risshah
 *
 */

public class ExecuteCaesarCipherTwo {
	
	public static void main(String[] args){
		ExecuteCaesarCipherTwo cc = new ExecuteCaesarCipherTwo();
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter the mode ");
		int mode = in.nextInt();
		
		in.nextLine();
		
		if (mode == 1){
			cc.simpleTestOne();
		} 
		/*
		else if (mode == 2) {
			cc.simpleTestTwo();
		} else if (mode == 3) {
			cc.simpleTestThree();
		} else if (mode == 4) {
			cc.simpleTestFour();
		}*/
    }
	

    /**
     * This method takes a string & key(s) as input from user and prints the encrypted String
     * The same encrypted string is then decrypted to produce the original text
     * 
     */
    
    public void simpleTestOne(){
    	
//    	FileResource fr = new FileResource();
//    	String encryption_string = fr.asString();
    	

        
        //Create the scanner object
        Scanner in = new Scanner(System.in);
        
               
        //Ask user for key
        System.out.print("Please enter the first key you want to use for encryption ");
        int key1 = in.nextInt();
        System.out.println();
        
        in.nextLine();
        
        System.out.print("Please enter the second key you want to use for encryption ");
        int key2 = in.nextInt();
        System.out.println();
        
        in.nextLine();        
        
        //Ask user for the String to be encrypted
        System.out.println("Please enter the String you wish to encrypt ");
        String s = in.nextLine();
        System.out.println();
        
        //Create a new CaesarCipher object with key as 18
        CaesarCipherTwo cipher = new CaesarCipherTwo(key1, key2);        
        
        //Get the encrypted String
        String encrypted_string = cipher.encrypt(s);
              
        //Print the encrypted String
        System.out.println("The original string is "+s);
        System.out.println("The encrypted string is "+encrypted_string);
            
        //Decrypt the encrypted string
        String original_text = cipher.decrypt(encrypted_string, 1);
        
        //Print the decrypted text
        System.out.println("The decrypted text is "+original_text);
        
    }

}
