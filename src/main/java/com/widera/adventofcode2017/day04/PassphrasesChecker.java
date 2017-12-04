package com.widera.adventofcode2017.day04;

import java.util.HashSet;
import java.util.Set;

public class PassphrasesChecker {

    private final String passphrase;

    public PassphrasesChecker(final String passphrase) {
        this.passphrase = passphrase;
    }

    public boolean isValid() {
        Set<String> foundWords = new HashSet<>();
        for (String word : passphrase.split(" ")) {
            if (foundWords.contains(word)) {
                return false;
            }
            foundWords.add(word);
        }
        return true;
    }
}
