package com.widera.adventofcode2017.day09;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private final List<Group> subGroups = new ArrayList<>();

    private final int score;

    private int garbageCounter = 0;

    public Group(final String inputAsString, final int source) {
        this.score = source;
        extractInput(inputAsString);
    }

    private void extractInput(final String inputAsString) {
        String groupInput = inputAsString.substring(1, inputAsString.length() - 1);
        if (!groupInput.isEmpty()) {
            boolean isInGarbageMode = false;
            int indexOfFirstOpenGroup = 0;
            int openGroups = 0;

            for (int c = 0; c < groupInput.length(); c++) {
                if (groupInput.charAt(c) == '!') {
                    c++;
                    continue;
                }

                if (groupInput.charAt(c) == '<' && !isInGarbageMode) {
                    isInGarbageMode = true;
                    continue;
                } else if (groupInput.charAt(c) == '>' && isInGarbageMode) {
                    isInGarbageMode = false;
                    continue;
                }

                if (!isInGarbageMode) {
                    if (groupInput.charAt(c) == '{' && openGroups == 0) {
                        openGroups = 1;
                        indexOfFirstOpenGroup = c;
                    } else if (groupInput.charAt(c) == '{' && openGroups > 0) {
                        openGroups++;
                    } else if (groupInput.charAt(c) == '}' && openGroups > 1) {
                        openGroups--;
                    } else if (groupInput.charAt(c) == '}' && openGroups == 1) {
                        openGroups--;
                        subGroups.add(new Group(groupInput.substring(indexOfFirstOpenGroup, c + 1), score + 1));
                    }
                } else {
                    garbageCounter++;
                }
            }
        }
    }


    public int groupCount() {
        int count = 1;
        for (Group group : subGroups) {
            count += group.groupCount();
        }
        return count;
    }

    public int score() {
        int score = this.score;
        for (Group group : subGroups) {
            score += group.score();
        }
        return score;
    }

    public int canceledGarbageChars() {
        return garbageCounter;
    }
}
