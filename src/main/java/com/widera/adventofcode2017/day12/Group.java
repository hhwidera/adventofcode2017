package com.widera.adventofcode2017.day12;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Group {

    private final Set<Integer> member = new HashSet<>();

    public Group(final int startProgram, final String[] communicates) {
        member.add(startProgram);
        getLinkedFor(startProgram, communicates);

    }

    private void getLinkedFor(Integer program, String[] communicates) {
        for (Integer linkedProgram : extractLinkedPrograms(communicates[program])) {
            if (!member.contains(linkedProgram)) {
                member.add(linkedProgram);
                getLinkedFor(linkedProgram, communicates);
            }
        }
    }

    private Set<Integer> extractLinkedPrograms(String communicate) {
        Set<Integer> result = new HashSet<>();
        String[] parts = communicate.split(" ");
        for (int p = 2; p < parts.length; p++) {
            result.add(Integer.valueOf(parts[p].replace(",", "")));
        }
        return result;
    }

    public int memberSize() {
        return member.size();
    }

    public Set<Integer> getMembers() {
        return Collections.unmodifiableSet(member);
    }
}
