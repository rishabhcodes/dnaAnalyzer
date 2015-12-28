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
    
    private char returnEncryptedChar(char in){
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
     * This function takes a string and returns the original text through decryption
     * @param e
     * 			Input string to be Decrypted 
     * @return
     * 			Returns the original decrypted text
     */    
    
    public String decryptString(String e){
    	CaesarCipher cc = new CaesarCipher(26-encrypt_key);
    	String decryptedString = cc.encryptString(e);
    	return decryptedString;
    			
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
    /**
     * This method allows one or more files to be selected and encrypted. The encrypted files are 
     * written back to the same folder with a prefix of "encrypt" to the file name
     */
    
    public void selectFileAndEncrypt(){
        String file_path = "";
        String file_name = "";
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            //Get the file name and file path of the selected file
            file_path = f.getAbsolutePath();
            file_name = f.getName();
            int index = file_path.lastIndexOf(file_name);
            file_path = file_path.substring(0,index);
            
            //Get the file content as a string literal 
            FileResource fr = new FileResource(f);
            String encryption_string = fr.asString();
            
            //Send the encryption string to function encryptString(encryption_string)
            String encrypted_string = encryptString(encryption_string);
            
            //Create a new file at the same location with new file name prefixed with encrypted and write the encrypted contents in the new file
            try {
                String new_file_name = "encrypt_"+file_name;
                FileWriter new_file = new FileWriter(file_path + new_file_name);
                new_file.write(encrypted_string);
                new_file.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
    }
    
   
    
}
