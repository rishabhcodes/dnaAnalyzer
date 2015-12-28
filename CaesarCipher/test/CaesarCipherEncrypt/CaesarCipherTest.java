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
	public void test() {
		assertEquals("IJKLMNOPQRSTUVWXYZABCDEFGHijklmnopqrstuvwxyzabcdefgh", cc.get_encryption_lookup());
	}

	@After
	public void tearDown() throws Exception {
	}
}
