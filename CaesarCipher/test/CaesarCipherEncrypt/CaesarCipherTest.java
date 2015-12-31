package CaesarCipherEncrypt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class CaesarCipherTest {
	private CaesarCipher cc;

	@Before
	public void setUp()  {
		cc = new CaesarCipher();
		
	}

	@Test
	public void test_generateEncryptionLookup() {
		cc.set_key(8);
		assertEquals("IJKLMNOPQRSTUVWXYZABCDEFGHijklmnopqrstuvwxyzabcdefgh", cc.get_encryption_lookup());
	}
	
	@Ignore("not ready yet")
	@Test 
	public void test_returnEncryptedChar(){
		//assertEquals('r',cc.returnEncryptedChar('j'));
	}
	
	@Test
	public void test_encryptString(){
		cc.set_string_under_action("ABCDE abcde");
		cc.set_key(8);
		assertEquals("IJKLM ijklm", cc.encryptString());
	}
	
	@Test
	public void test_decryptString(){
		cc.set_string_under_action("IJKLM ijklm");
		cc.set_key(8);
		assertEquals("ABCDE abcde", cc.decryptString(1));
	}
	
	@Test
	public void test_interleave(){
		assertEquals("aNcPe", CaesarCipher.interleave("abcde", "MNOPQ"));
		assertEquals("aNcP", CaesarCipher.interleave("abcd", "MNOP"));
		assertEquals("aNcP", CaesarCipher.interleave("abc", "MNOP"));
		assertEquals("aNcPQRS", CaesarCipher.interleave("abc", "MNOPQRS"));
				
	}
	
	@Test
	public void test_char_frequency() {
		cc.set_string_under_action("me the tumee keep your tumee");
		assertArrayEquals(new int[] {0,0,0,0,8,0,0,1,0,0,1,0,3,0,1,1,0,1,0,3,3,0,0,0,1,0}, cc.get_char_freq());
	}
	
	@Test
	public void test_get_max_char_freq(){
		cc.set_string_under_action("me the tumee keep your tumee");
		cc.get_char_freq();
		assertEquals(4, cc.get_max_char_freq());
	}	
	
    @Ignore
    @Test
    public void test_selectFileAndEncrypt(){
    	//Do not know how to implement this test. Would be implemented later
    }
    
    
    
	@After
	public void tearDown() throws Exception {
	}
}
