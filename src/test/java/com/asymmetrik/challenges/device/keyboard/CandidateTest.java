package com.asymmetrik.challenges.device.keyboard;

import org.junit.Assert;
import org.junit.Test;

public class CandidateTest {

    @Test
    public void testConstructor() {
        String word = "test";
        int confidence = 3;

        Candidate c = new Candidate(word, confidence);

        Assert.assertEquals("should set word", word, c.getWord());
        Assert.assertEquals("should set confidence", confidence, c.getConfidence());
    }

    @Test
    public void testCompare() {
        Candidate c1 = new Candidate("bigger", 5);
        Candidate c2 = new Candidate("smaller", 3);

        int result = c1.compareTo(c2);
        Assert.assertTrue("should report bigger", result < 0);

        result = c2.compareTo(c1);
        Assert.assertTrue("should report smaller", result > 0);
    }

    @Test
    public void testCompareSameRank() {
        Candidate c1 = new Candidate("bigger", 5);
        Candidate c2 = new Candidate("smaller", 5);

        int result = c1.compareTo(c2);
        Assert.assertTrue("should report bigger", result < 0);

        result = c2.compareTo(c1);
        Assert.assertTrue("should report smaller", result > 0);
    }

    @Test
    public void testToString() {
        Candidate c = new Candidate("test", 3);
        String expected = "test (3)";

        Assert.assertEquals("should format toString()", c.toString(), expected);
    }
}
