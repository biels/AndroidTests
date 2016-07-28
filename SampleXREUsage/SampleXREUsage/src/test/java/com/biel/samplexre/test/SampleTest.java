package com.biel.samplexre.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.biel.samplexre.reportmodel1.DealReport;

public class SampleTest {
	@Test public void testSomeLibraryMethod() {
        DealReport dr = new DealReport();
        assertTrue(dr.getXHTML().startsWith("<"));
        //assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}
