package com.widera.adventofcode2017.day21;

import java.util.Arrays;

public class Rule {

    private char[][][] matches;
    private char[][] replace;

    public Rule(final String input) {
        String[] parts = input.split(" => ");
        buildMatchPart(parts[0]);
        buildReplacePart(parts[1]);
    }

    private void buildReplacePart(final String part) {
        String[] row = part.split("/");
        replace = new char[row.length][];
        for (int r = 0; r < row.length; r++) {
            replace[r] = row[r].toCharArray();
        }
    }

    private void buildMatchPart(final String part) {
        String[] row = part.split("/");
        char[][] match = new char[row.length][];

        for (int r = 0; r < row.length; r++) {
            match[r] = row[r].toCharArray();
        }

        matches = new char[12][][];
        matches[0] = match;
        matches[1] = flipHorizontal(match);
        matches[2] = flipVertical(match);
        for (int rotate = 3; rotate < 12; rotate += 3) {
            matches[rotate] = rotateClockwise(matches[rotate-3]);
            matches[rotate + 1] = flipHorizontal(matches[rotate-3]);
            matches[rotate + 2] = flipVertical(matches[rotate-3]);
        }
    }

    private char[][] flipVertical(final char[][] array) {
        char[][] flipped = clone(array);
        char temp;
        for (int r = 0; r < flipped.length; r++) {
            for (int c = 0; c < flipped[r].length / 2; c++) {
                temp = flipped[r][c];
                flipped[r][c] = flipped[r][flipped[r].length - c - 1];
                flipped[r][flipped[r].length - c - 1] = temp;
            }
        }
        return flipped;
    }

    private char[][] flipHorizontal(final char[][] array) {
        char[][] flipped = clone(array);
        char temp;
        for (int r = 0; r < flipped.length / 2; r++) {
            for (int c = 0; c < flipped[r].length; c++) {
                temp = flipped[r][c];
                flipped[r][c] = flipped[flipped.length - r - 1][c];
                flipped[flipped.length - r - 1][c] = temp;
            }
        }
        return flipped;
    }

    private char[][] clone(final char[][] array) {
        return Arrays.stream(array).map(row -> row.clone()).toArray($ -> array.clone());
    }

    public char[][] getReplace() {
        return clone(replace);
    }

    public char[][] rotateClockwise(final char[][] array) {
        char[][] rotated = clone(array);
        char temp;
        final int len = rotated.length;
        for (int s = 0; s < len / 2; s++) {
            for (int i = 0; i < len - 2 * s - 1; i++) {
                temp = rotated[s][s + i];
                rotated[s][s + i] = rotated[len - s - i - 1][s];
                rotated[len - s - i - 1][s] = rotated[len - s - 1][len - s - i - 1];
                rotated[len - s - 1][len - s - i - 1] = rotated[s + i][len - s - 1];
                rotated[s + i][len - s - 1] = temp;
            }
        }
        return rotated;
    }

    private boolean matchToArrays(final char[][] matching, final char[][] match) {
        if (matching.length != match.length) {
            return false;
        }

       for (int r = 0; r < matching.length; r++) {
            if (matching[r].length != match[r].length) {
                return false;
            }
            for (int c = 0; c < matching.length; c++) {
                if (matching[r][c] != match[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean match(final char[][] matching) {
        for (int m = 0; m < matches.length; m++) {
            if (matchToArrays(matching, matches[m])) {
                return true;
            }
        }
        return false;
    }
}
