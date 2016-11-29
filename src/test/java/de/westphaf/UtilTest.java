package de.westphaf;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class UtilTest {
	
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testValidInput() {
		assertEquals(false, Util.istErstesHalbjahr(7));
		assertEquals(true, Util.istErstesHalbjahr(6));
		assertEquals(false, Util.istErstesHalbjahr(12));
		assertEquals(true, Util.istErstesHalbjahr(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void invalidInputMin() {
		Util.istErstesHalbjahr(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputMax() {
		Util.istErstesHalbjahr(13);
	}

}
