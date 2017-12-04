package com.widera.adventofcode2017.day04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PassphrasesRearrangedChecker {

    private final String passphrase;

    public PassphrasesRearrangedChecker(final String passphrase) {
        this.passphrase = passphrase;
    }

    public boolean isValid() {
        Set<List<Integer>> foundWordFootprints = new HashSet<>();
        for (String word : passphrase.split(" ")) {
            List<Integer> footprintOfWord = footprint(word);
            if (foundWordFootprints.contains(footprintOfWord)) {
                return false;
            }
            foundWordFootprints.add(footprintOfWord);
        }
        return true;
    }

   private List<Integer> footprint(final String word) {
        Integer[] result = new Integer[26];
        Arrays.fill(result, 0);
        for (int c = 0; c < word.length(); c++) {
            result[(int)word.charAt(c)-startCharLowerA()] += 1;
        }
        return Arrays.asList(result);
   }

    private int startCharLowerA() {
        return (int)"a".charAt(0);
    }
}
