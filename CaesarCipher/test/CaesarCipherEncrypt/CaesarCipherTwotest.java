package CaesarCipherEncrypt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

public class CaesarCipherTwotest {
	private CaesarCipherTwo cct;

	@Before
	public void setUp() throws Exception {
		cct = new CaesarCipherTwo(1,2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_encrypt() {
		assertEquals("ctpyo", cct.encrypt("brown"));
		assertEquals("ng vig vvofg apw vig vvongf", cct.encrypt("me the tumee you the tummee"));
	}
	
	
	@Test
	public void test_decrypt1(){
		assertEquals("brown", cct.decrypt("ctpyo",1));
//		assertEquals("me the tumee you the tummee", cct.decrypt("ng vig vvofg apw vig vvongf", 2));
//		assertEquals("", cct.decrypt("Akag tjw Xibhr awoa aoee xakex znxag xwko", 2));
	}
	
	@Test
	public void test_decrypt2(){
//		assertEquals("brown", cct.decrypt("ctpyo",1));
		assertEquals("me the tumee you the tummee", cct.decrypt("ng vig vvofg apw vig vvongf", 2));
//		assertEquals("", cct.decrypt("Akag tjw Xibhr awoa aoee xakex znxag xwko", 2));
	}	
	
	@Test
	public void test_decrypt3(){
//		assertEquals("brown", cct.decrypt("ctpyo",1));
//		assertEquals("me the tumee you the tummee", cct.decrypt("ng vig vvofg apw vig vvongf", 2));
		assertEquals("Eren and Emily have evil eerie green ears", cct.decrypt("Akag tjw Xibhr awoa aoee xakex znxag xwko", 2));
	}	
	
	

	@Test
	public void test_halfOfString(){
		assertArrayEquals(new String [] {"bon","rw"}, CaesarCipherTwo.halfOfString("brown"));
		assertArrayEquals(new String [] {"m h ue o h ue", "etetmeyutetme"}, CaesarCipherTwo.halfOfString("me the tumee you the tumee"));
	}
	
	@Test
	public void test_weaveTwoStrings(){
		assertEquals("brown", CaesarCipherTwo.weaveTwoStrings("bon", "rw"));
		assertEquals("me the tumee you the tumee",CaesarCipherTwo.weaveTwoStrings("m h ue o h ue", "etetmeyutetme") );
	}
}
