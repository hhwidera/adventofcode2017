package com.widera.adventofcode2017.day21;

import java.util.List;

public class Image {

    private final List<Rule> rules;

    private char[][] image;

    public Image(final char[][] startImage, final List<Rule> rulesToGrow) {
        this.rules = rulesToGrow;
        this.image = startImage;
    }

    public void grow(final int iterations) {
        print();
        for (int i = 0; i < iterations; i++) {
            grow();
            print();
        }
    }

    private void print() {
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                System.out.print(image[r][c]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void grow() {
        int splitSize;
        int partGrownToSize;
        if (image.length % 2 == 0) {
            splitSize = 2;
            partGrownToSize = 3;
        } else {
            splitSize = 3;
            partGrownToSize = 4;
        }
        char[][] grownImage = new char[image.length / splitSize * partGrownToSize][image.length / splitSize * partGrownToSize];

        for (int r = 0; r < image.length / splitSize; r++) {
            for (int c = 0; c < image.length / splitSize; c++) {
                char[][] toGrowPart = new char[splitSize][splitSize];
                for (int toGrowPartRow = 0; toGrowPartRow < toGrowPart.length; toGrowPartRow++) {
                    for (int toGrowPartColumn = 0; toGrowPartColumn < toGrowPart.length; toGrowPartColumn++) {
                        toGrowPart[toGrowPartRow][toGrowPartColumn] = image[r * splitSize + toGrowPartRow][c * splitSize + toGrowPartColumn];
                    }
                }
                char[][] grownPart = growPart(toGrowPart);
                for (int grownPartRow = 0; grownPartRow < grownPart.length; grownPartRow++) {
                    for (int grownPartColumn = 0; grownPartColumn < grownPart.length; grownPartColumn++) {
                        grownImage[r * partGrownToSize + grownPartRow][c * partGrownToSize + grownPartColumn] = grownPart[grownPartRow][grownPartColumn];
                    }
                }
            }
        }

        image = grownImage;
    }

    private char[][] growPart(final char[][] toGrowPart) {
        for (Rule rule : rules) {
            if (rule.match(toGrowPart)) {
                return rule.getReplace();
            }
        }
        throw new IllegalArgumentException("no rule found!");
    }

    public int sizeOfOnPixels() {
        int result = 0;
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                if (image[r][c] == '#') {
                    result++;
                }
            }
        }
        return result;
    }
}
