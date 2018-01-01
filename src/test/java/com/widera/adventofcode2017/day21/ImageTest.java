package com.widera.adventofcode2017.day21;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImageTest {

    @Test
    public void test() {
        char[][] startImage = new char[3][3];
        startImage[0] = ".#.".toCharArray();
        startImage[1] = "..#".toCharArray();
        startImage[2] = "###".toCharArray();

        Image image = new Image(startImage,
                Arrays.asList(new Rule("../.# => ##./#../..."), new Rule(".#./..#/### => #..#/..../..../#..#")));

        image.grow(2);

        assertEquals(12, image.sizeOfOnPixels());
    }
}