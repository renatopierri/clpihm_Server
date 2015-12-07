package br.com.nets_nuts.clpihm;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ParserTest extends TestCase {

	
	public ParserTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ParserTest.class);
	}

	public void testParser() {
		
		Parser ps = new Parser();
		assertNotNull(ps.parse("09/02/15|08:50:22|CLPNATO|1|1|0|1|0|1|0|0|0|0|0|1|0|0|0|0|0|0|0|0|0|0|143|0|"));
	}	
}
