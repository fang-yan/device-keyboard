package com.asymmetrik.challenges.device.keyboard;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The AutocompleteProvider class to train passages and get Candidates.
 */
public class AutocompleteProvider {
    // key: the word, value: confidence
    Map<String, Integer> candidates;

    public AutocompleteProvider() {
        this.candidates = new HashMap<>();
    }

    /**
     * Get list of candidates ordered by confidence
     *
     * @param fragment the leading characters user typed
     * @return list of candidates ordered by confidence
     */
    List<Candidate> getWords(final String fragment) {
        String fragmentLowerCase = fragment.toLowerCase();
        List<Candidate> suggestion = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            String word = entry.getKey();
            if (word.startsWith(fragmentLowerCase)) {
                Candidate c = new Candidate(word, entry.getValue());
                suggestion.add(c);
            }
        }

        // sort the result set in order
        Collections.sort(suggestion);

        return suggestion;
    }

    /**
     * Trains the algorithm with the provided passage
     *
     * @param passage the passage to train
     */
    void train(final String passage) {
        String[] words = passage.split(" ");
        for (String word : words) {
            // index word with all lower case characters only
            word = word.toLowerCase().trim().replaceAll("[^a-z]", "");
            if (StringUtils.isNotBlank(word)) {
                int confidence = 1;

                if (candidates.containsKey(word)) {
                    confidence = candidates.get(word) + 1;
                }

                candidates.put(word, confidence);
            }
        }
    }
}
