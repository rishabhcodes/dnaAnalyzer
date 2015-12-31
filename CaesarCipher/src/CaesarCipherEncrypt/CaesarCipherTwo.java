package CaesarCipherEncrypt;

/**
 * This class uses two keys to encrypt text. Alternate letters in String are encrypted using key1 and key2. 
 * This class also decrypts text encrypted using two keys
 * @author risshah
 *
 */

public class CaesarCipherTwo {
	
	private int key1 = -1;
	private int key2 = -1;
	private CaesarCipher cc1;
	private CaesarCipher cc2;
	
	public CaesarCipherTwo(int key1, int key2){
		this.key1 = key1;
		this.key2 = key2;
		cc1 = new CaesarCipher();
		cc1.set_key(key1);
		cc2 = new CaesarCipher();
		cc2.set_key(key2);
		
	}

	public String encrypt(String s){
		cc1.set_string_under_action(s);
		cc2.set_string_under_action(s);
		String encrypted1 = cc1.encryptString();
		String encrypted2 = cc2.encryptString();
		String encrypted = CaesarCipher.interleave(encrypted1, encrypted2);
		return encrypted;
	
	}
	
	public String decrypt(String s, int mode){
		
	    String [] decrypt = CaesarCipherTwo.halfOfString(s);
		cc1.set_string_under_action(decrypt[0]);
		cc2.set_string_under_action(decrypt[1]);
		String d1 = cc1.decryptString(mode);
		String d2 = cc2.decryptString(mode);
		String d = CaesarCipherTwo.weaveTwoStrings(d1, d2);
		return d;	
	}
	
	public static String[] halfOfString(String s){
        StringBuilder sb1 = new StringBuilder(1000);
        StringBuilder sb2 = new StringBuilder(1000);
        String [] decrypt = new String[2];
        
        for (int i = 0; i<s.length();i++){
            if (i%2 == 0){
                sb1.append(s.charAt(i));
            }else {
                sb2.append(s.charAt(i));
            }
        }
        
        decrypt[0] = sb1.toString();
        decrypt[1] = sb2.toString();
        return decrypt;
	}
	
    public static String weaveTwoStrings(String s1,String s2){
        int len = Math.max(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder(1000);
        
            for (int i=0; i< len; i++){
                if (i < s1.length() && i < s2.length()){
                    sb.append(s1.charAt(i));
                    sb.append(s2.charAt(i));
                }else if (i < s1.length() && i >= s2.length()){
                    sb.append(s1.charAt(i));
                }else if (i >= s1.length() && i < s2.length()){
                    sb.append(s2.charAt(i)); 
                }
            }        
        return sb.toString();
        
    }
}
