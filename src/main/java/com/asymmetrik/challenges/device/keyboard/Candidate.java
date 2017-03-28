package com.asymmetrik.challenges.device.keyboard;

/**
 * The Candidate class to represent word with corresponding confidence.
 */
public class Candidate implements Comparable<Candidate> {
    private String word;
    // Confidence is the likelihood/relevance of an individual word relative to the other words being returned by the autocomplete provider.
    private int confidence;

    public Candidate(String word, int confidence) {
        this.word = word;
        this.confidence = confidence;
    }

    /**
     * Getter for word
     *
     * @return the autocomplete candidate
     */
    public String getWord() {
        return word;
    }

    /**
     * Getter for confidence
     *
     * @return the confidence for the candidate
     */
    public int getConfidence() {
        return confidence;
    }

    /**
     * Comparable interface implemenation
     *
     * @param o the object to compare to
     * @return relative value for comparison
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(Candidate o) {
        if (o == null) {
            return 1;
        }
        // compare by confidence first
        int result = Integer.compare(o.getConfidence(), this.confidence);
        if (result == 0) {
            // if tie, compare by word in alphabet order
            result = this.word.compareTo(o.getWord());
        }
        return result;
    }

    /**
     * toString() override
     *
     * @return string value for Candidate object in format "word (confidence)"
     */
    @Override
    public String toString() {
        return word + " (" + confidence + ")";
    }
}
