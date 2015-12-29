package CaesarCipherEncrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

/**
 * This class executes the Caesar Cipher class
 * @author risshah
 *
 */

public class ExecuteCaesarCipher {
	
    private String string_under_action = "";
    private int [] char_freq = new int[26];
    int key = 0;
    
    /**
     * Constructor
     * @param s
     * 			Input String to be acted upon
     */
    
    public ExecuteCaesarCipher(String s){
        this.string_under_action = s;
        char_frequency();
    }
    
    /**
     * Getter method for character frequency of the supplied string
     * @return
     */
    
    public int [] get_char_freq(){
    	return char_freq;
    }
    
    /**
     * Evalutes the String to be acted upon and populates an array with the character frequencies in the String
     */
    private void char_frequency(){
        String char_map = "abcdefghijklmnopqrstuvwxyz";
        
        for (int i = 0; i<string_under_action.length(); i++){
            char c = (string_under_action.toLowerCase()).charAt(i); //gives the character at i'th position in string
            int n = char_map.indexOf(c); //gives the position of the character on the character map
            if (n!= -1){
                char_freq[n]++;
            }
        }
    } 
    
    /**
     * Returns the index of character that occurs maximum number of times in the string
     * @return 
     */
    
    public int get_max_char_freq(){
    	return this.max_frequency();
    }
    
    /**
     * Returns the character index with highest frequency of characters in the input string
     * @return
     */
    
    private int max_frequency(){
        int max = 0;
        for (int i = 0; i<26; i++){
            if (char_freq[i] > max){
                max = i;
            }
        }
        return max;
    }
    
    public static String[] simpleTests(){
    	
    	String [] all_strings = new String[3];
    	
    	FileResource fr = new FileResource();
    	String encryption_string = fr.asString();
    	
    	all_strings[0] = encryption_string;
            
        //Create a new CaesarCipher object with key as 18
        CaesarCipher cipher = new CaesarCipher(18);
            
        //Send the encryption string to function encryptString(encryption_string)
        String encrypted_string = cipher.encryptString(encryption_string);
        
        all_strings[1] = encrypted_string;
            
        //Print the encrypted String
        System.out.println("The original string is "+encryption_string);
        System.out.println("The encrypted string is "+encrypted_string);
            
        //Decrypt the encrypted string
        String original_text = cipher.decryptString(encrypted_string);
        
        all_strings[2] = original_text;
            
        //Print the decrypted text
        System.out.println("The decrypted text is "+original_text);
        
        System.out.println(Arrays.toString(all_strings));
        
        return all_strings;
            
    }
    
    
}
