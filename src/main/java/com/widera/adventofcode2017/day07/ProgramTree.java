package com.widera.adventofcode2017.day07;

import java.util.*;

public class ProgramTree {

    private final Map<String, Program> rootPrograms;
    private final Map<String, Program> allPrograms;

    public ProgramTree() {
        this.rootPrograms = new HashMap<>();
        this.allPrograms = new HashMap<>();
    }

    public void addProgramsAsString(final String[] programsAsString) {
        List<String> extractSubPrograms = new ArrayList<>();

        for (String programAsString : programsAsString) {
            String name = extractProgramName(programAsString);
            int weight = extractProgramWeight(programAsString);
            Program program = new Program(name, weight);
            rootPrograms.put(name, program);
            allPrograms.put(name, program);
            if (hasSubPrograms(programAsString)) {
                extractSubPrograms.add(programAsString);
            }
        }

        handleSubPrograms(extractSubPrograms);
    }

    private void handleSubPrograms(List<String> programWithSubProgramsAsString) {
        for (String programAsString : programWithSubProgramsAsString) {
            String name = extractProgramName(programAsString);
            Program program = allPrograms.get(name);
            for (Program subProgram : extractSubPrograms(programAsString)) {
                program.addSubProgram(subProgram);
                rootPrograms.remove(subProgram.getName());
            }
        }
    }

    private boolean hasSubPrograms(String programAsString) {
        String[] parts = splitByWhitespace(programAsString);
        return parts.length > 3;
    }

    private List<Program> extractSubPrograms(final String programAsString) {
        List<Program> subPrograms = new ArrayList<>();
        String[] parts = splitByWhitespace(programAsString);
        if(parts.length > 3) {
            for (int p = 3; p < parts.length; p++) {
                String subProgramName = parts[p].replace(",", "");
                if (allPrograms.containsKey(subProgramName)) {
                    subPrograms.add(allPrograms.get(subProgramName));
                }
            }
        }
        return subPrograms;
    }

    private String extractProgramName(final String programAsString) {
        String[] parts = splitByWhitespace(programAsString);
        return parts[0];
    }

    private String[] splitByWhitespace(String programAsString) {
        return programAsString.split(" ");
    }

    private int extractProgramWeight(final String programAsString) {
        String[] parts = splitByWhitespace(programAsString);
        return Integer.valueOf(parts[1].replace("(", "").replace(")", ""));
    }

    public int neededBalanceWeight() {
        return rootPrograms.get(rootProgramName()).neededBalancedWeight();
    }

    public String rootProgramName() {
        return rootPrograms.keySet().stream().findFirst().get();
    }
}
