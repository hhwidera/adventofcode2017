package com.widera.adventofcode2017.day14;

import com.widera.adventofcode2017.day10.KnotHash;

import java.math.BigInteger;

public class BitKnotHash {

    private KnotHash hash;
    public BitKnotHash(final String input) {
        hash = new KnotHash(input);
    }

    public String bits() {
       return String.format("%128s",
               new BigInteger(hash.denseHashAsHex(), 16).toString(2)).replace(' ', '0');
    }
}
