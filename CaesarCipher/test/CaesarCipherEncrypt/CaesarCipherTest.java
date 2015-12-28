package CaesarCipherEncrypt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

public class CaesarCipherTest {
	private CaesarCipher cc;

	@Before
	public void setUp()  {
		cc = new CaesarCipher(8);
	}

	@Test
	public void test_generateEncryptionLookup() {
		assertEquals("IJKLMNOPQRSTUVWXYZABCDEFGHijklmnopqrstuvwxyzabcdefgh", cc.get_encryption_lookup());
	}
	
	@Ignore("not ready yet")
	@Test 
	public void test_returnEncryptedChar(){
		//assertEquals('r',cc.returnEncryptedChar('j'));
	}
	
	@Test
	public void test_encryptString(){
		assertEquals("IJKLM ijklm", cc.encryptString("ABCDE abcde"));
	}
	
	@Test
	public void test_decryptString(){
		assertEquals("ABCDE abcde", cc.decryptString("IJKLM ijklm"));
	}
	
	@Test
	public void test_interleave(){
		assertEquals("aNcPe", CaesarCipher.interleave("abcde", "MNOPQ"));
		assertEquals("aNcP", CaesarCipher.interleave("abcd", "MNOP"));
		assertEquals("aNcP", CaesarCipher.interleave("abc", "MNOP"));
		assertEquals("aNcPQRS", CaesarCipher.interleave("abc", "MNOPQRS"));
				
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
