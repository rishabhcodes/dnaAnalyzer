package CaesarCipherEncrypt;

import edu.duke.*;
import java.util.*;
import java.io.*;

public class CaesarCipher {
	
    private int encrypt_key = 0; //Key used to encrypt
    private String alphabet = ""; //Alphabets of the english language
    private String e_alphabet = ""; //Shifted character map used for encryption
        
    /**
     * Main constructor
     * @param key 
     * 				Key used for Caesar Cipher encryption
     */
    
    public CaesarCipher(int key){
        this.encrypt_key = key;
        this.generateEncryptionLookup();
    }
    
    /**
     * Default constructor - Uses a key of 5 
     */
    public CaesarCipher(){
        this.encrypt_key = 5;
        this.generateEncryptionLookup();
    }
    
    /**
     * Getter function
     * @return
     * 			Returns the shifted character map used for encryption
     */
    
    public String get_encryption_lookup(){
        return e_alphabet;
    }
    /**
     * Getter function 
     * @return 
     * 			Returns the key used for encryption
     */
    
    public int get_key(){
    	return encrypt_key;
    }
    
    /**
     * Private function - generates the shifted character map based on the key passed in the object constructor
     */
    
    private void generateEncryptionLookup(){
        String alphabet_uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet_lowercase = "abcdefghijklmnopqrstuvwxyz";   
    
        String e_alphabet_uppercase = alphabet_uppercase.substring(encrypt_key) + alphabet_uppercase.substring(0,encrypt_key);
        String e_alphabet_lowercase = alphabet_lowercase.substring(encrypt_key) + alphabet_lowercase.substring(0,encrypt_key);
            
        
        alphabet = alphabet_uppercase + alphabet_lowercase;
        e_alphabet = e_alphabet_uppercase + e_alphabet_lowercase;
    }
    
    /**
     * This is a helper function. It takes in a char and looks up the corresponding character on the shifted character map
     * @param in 
     * 			Input character to be encrypted
     * @return
     *			Encrypted character
     */
    
    public char returnEncryptedChar(char in){
        char out;
        int index = alphabet.indexOf(in);
        
        if (index != -1){
            out = e_alphabet.charAt(index);
        }else {
            out = in;
        }
        
        return out;
    }
    /**
     * This function takes a string and returns the encrypted string
     * @param e
     * 			Input string to be encrypted
     * @return
     * 			Returns the encrypted String
     */
    
    public String encryptString(String e){
        StringBuilder str = new StringBuilder(1000);
        for (int i=0;i<e.length(); i++){
            char in = e.charAt(i);
            str.append(returnEncryptedChar(in));
        }
        return str.toString();
    }
    /**
     * Static method take two strings as inputs and interleaves them
     * @param a
     * 			String 1 for interleaving
     * @param b
     * 			String 2 for interleaving
     * @return
     * 			Interleaved String
     */
    
    public static String interleave(String a, String b){
        StringBuilder str = new StringBuilder(1000);
            int len = Math.max(a.length(),b.length());
            
            for (int i=0; i< len; i++){
                if (i < a.length() && i < b.length()){
                    if ((i%2)== 0){
                        str.append(a.charAt(i));
                    } else {
                        str.append(b.charAt(i)); 
                    }
                }else if (i < a.length() && i >= b.length()){
                    str.append(a.charAt(i));
                }else if (i >= a.length() && i < b.length()){
                    str.append(b.charAt(i)); 
                }
            }
        
        return str.toString();
    }
    
}
