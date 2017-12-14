package com.widera.adventofcode2017.day12;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class GroupCounter {

    private final Set<Integer> unusedMembers = new HashSet<>();

    private int counter = 0;

    public GroupCounter(final String[] communicates) {
        IntStream.range(0, communicates.length).forEach(unusedMembers::add);

        while (unusedMembers.size() > 0) {
            Integer nextProgramStart = unusedMembers.iterator().next();
            Group group = new Group(nextProgramStart, communicates);
            System.out.println("group for " + nextProgramStart + " has " + group.memberSize() + " members");
            Set<Integer> members = group.getMembers();
            unusedMembers.removeAll(members);
            counter++;
        }
    }

    public int counter() {
        return counter;
    }
}
