package CaesarCipherEncrypt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	@Test 
	public void test_returnEncryptedChar(){
		assertEquals('r',cc.returnEncryptedChar('j'));
	}
	
	@Test
	public void test_encryptString(){
		assertEquals("IJKLM ijklm", cc.encryptString("ABCDE abcde"));
	}
	
	@Test
	public void test_interleave(){
		assertEquals("aNcPe", CaesarCipher.interleave("abcde", "MNOPQ"));
		assertEquals("aNcP", CaesarCipher.interleave("abcd", "MNOP"));
		assertEquals("aNcP", CaesarCipher.interleave("abc", "MNOP"));
		assertEquals("aNcPQRS", CaesarCipher.interleave("abc", "MNOPQRS"));
				
	}

	@After
	public void tearDown() throws Exception {
	}
}
