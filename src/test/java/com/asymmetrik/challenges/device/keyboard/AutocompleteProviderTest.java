package com.asymmetrik.challenges.device.keyboard;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AutocompleteProviderTest {

    @Test
    public void testTrain() {
        AutocompleteProvider provider = new AutocompleteProvider();
        provider.train("The third thing that I need to   tell you is that this thing does not think Thoroughly.");

        Assert.assertEquals("should set candidates", 15, provider.candidates.size());
        Assert.assertEquals("should removed period", 1, provider.candidates.get("thoroughly").intValue());
        Assert.assertEquals("should have 2 'thing' term", 2, provider.candidates.get("thing").intValue());
    }

    @Test
    public void testGetWords() {
        AutocompleteProvider provider = new AutocompleteProvider();
        provider.train("The third thing that I need to tell you is that this thing does not think thoroughly.");

        List<Candidate> candidates = provider.getWords("thi");
        Assert.assertEquals("should find suggestions", 4, candidates.size());
        Assert.assertEquals("should find thing high rank", "thing (2)", candidates.get(0).toString());
        Assert.assertEquals("should sort suggestions", "[thing (2), think (1), third (1), this (1)]", candidates.toString());

        candidates = provider.getWords("need");
        Assert.assertEquals("should find suggestions", 1, candidates.size());
        Assert.assertEquals("should find need", "need (1)", candidates.get(0).toString());

        candidates = provider.getWords("th");
        Assert.assertEquals("should find suggestions", 7, candidates.size());
        Assert.assertEquals("should find that high rank", "that (2)", candidates.get(0).toString());
        Assert.assertEquals("should sort suggestions", "[that (2), thing (2), the (1), think (1), third (1), this (1), thoroughly (1)]", candidates.toString());
    }
}
