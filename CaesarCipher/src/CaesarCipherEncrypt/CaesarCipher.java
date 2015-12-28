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
    
}
