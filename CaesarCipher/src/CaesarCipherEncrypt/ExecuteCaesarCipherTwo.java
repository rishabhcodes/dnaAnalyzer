package CaesarCipherEncrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Arrays;
import java.util.Scanner;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

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
		
		else if (mode == 2) {
			cc.simpleTestTwo();
		} else if (mode == 3) {
			cc.simpleTestThree();
		} else if (mode == 4) {
			cc.simpleTestFour();
		} else if (mode == 5){
			cc.simpleTestFive();
		} else if (mode == 6){
			cc.simpleTestSix();
		}
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
    /**
     * This method takes a String from user. This string needs to be decrypted. The method figures out the key used for encryption and produces 
     * the decrypted text
     */
    
    public void simpleTestTwo(){
    	
        //Create a new CaesarCipher object with key as 18
        CaesarCipherTwo cipher = new CaesarCipherTwo();
        
        //Create the scanner object
        Scanner in = new Scanner(System.in);
        
        //Ask user for the String to be decrypted
        System.out.println("Please enter the String you wish to decrypt ");
        String s = in.nextLine();
        System.out.println();
        
            
        //Get the encrypted String
        String decrypted_string = cipher.decrypt(s,2);
              
        //Print the encrypted String
        System.out.println("The encrypted string is "+s);
        System.out.println("The decrypted string is "+decrypted_string);

    	
    }
    
    /**
     * This method reads a single file, outputs the encrypted text
     * 
     */
   
    public void simpleTestThree(){
    	System.out.println("Please select a file for encryption"); 
    	FileResource fr = new FileResource();
    	String text_to_encrypt = fr.asString();
    	
    	//create the scanner object
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
    	
        //Create a new CaesarCipherTwo object 
        CaesarCipherTwo cipher = new CaesarCipherTwo(key1,key2);
        //Get the encrypted String
        String encrypted_string = cipher.encrypt(text_to_encrypt);
                   
             
        //Print the encrypted String
        System.out.println("The original string is "+text_to_encrypt);
        System.out.println("The encrypted string is "+encrypted_string);
            
 	
    } 
    
    /**
     * This method reads a single encrypted file, outputs the decrypted text
     * 
     */
   
    public void simpleTestFour(){
    	System.out.println("Please select a file for decryption"); 
    	FileResource fr = new FileResource();
    	String text_to_encrypt = fr.asString();
    	
        //Create a new CaesarCipherTwo object 
        CaesarCipherTwo cipher = new CaesarCipherTwo();
        //Get the encrypted String
        String decrypted_string = cipher.decrypt(text_to_encrypt,2);
                   
             
        //Print the encrypted String
        System.out.println("The encrypted string is "+text_to_encrypt);
        System.out.println("The decrypted string is "+decrypted_string);
            
 	
    }     
    
    /**
     * This method can be used for selecting multiple files, decrypting them and storing them in a new file with the prefix "decrypt" with the file name
     */
    
    public void simpleTestFive(){
        String file_path = "";
        String file_name = "";
        
        //Create a new CaesarCipher object 
        CaesarCipherTwo cipher = new CaesarCipherTwo();
        
        
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            //Get the file name and file path of the selected file
            file_path = f.getAbsolutePath();
            file_name = f.getName();
            int index = file_path.lastIndexOf(file_name);
            file_path = file_path.substring(0,index);
            
            //Get the file content as a string literal 
            FileResource fr = new FileResource(f);
            String encrypted_string = fr.asString();
            
            //Get the decrypted string

            String decrypted_string = cipher.decrypt(encrypted_string,2);
            
            //Create a new file at the same location with new file name prefixed with encrypted and write the encrypted contents in the new file
            try {
                String new_file_name = "decrypt_"+file_name;
                FileWriter new_file = new FileWriter(file_path + new_file_name);
                new_file.write(decrypted_string);
                new_file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
    /**
     * This method allows a user to feed in an input string and 2 keys to enable encryption of the String
     */
    
    public void simpleTestSix(){
    	
       
        //Create the scanner object
        Scanner in = new Scanner(System.in);
        
        //Ask user for the String to be decrypted
        System.out.println("Please enter the String you wish to decrypt ");
        String s = in.nextLine();
        System.out.println();
        
        in.nextLine();
        
        System.out.println("Please enter the first key ");
        int key1 = in.nextInt();
        System.out.println();
        
        in.nextLine();
        
        System.out.println("Please enter the second key ");
        int key2 = in.nextInt();
        System.out.println();
        
        in.nextLine();  
        
        //Create a new CaesarCipherTwo object
        CaesarCipherTwo cipher = new CaesarCipherTwo(key1,key2);
        
            
        //Get the encrypted String
        String decrypted_string = cipher.decrypt(s,1);
              
        //Print the encrypted String
        System.out.println("The encrypted string is "+s);
        System.out.println("The decrypted string is "+decrypted_string);

    	
    }    
    
}
