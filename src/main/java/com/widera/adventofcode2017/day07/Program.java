package com.widera.adventofcode2017.day07;

import java.util.*;
import java.util.stream.Collectors;

public class Program {

    private final String name;

    private final int weight;

    private final Set<Program> subPrograms;

    public Program(final String name, final int weight) {
        this.name = name;
        this.weight = weight;
        this.subPrograms = new HashSet<>();
    }

    public void addSubProgram(final Program subProgram) {
        subPrograms.add(subProgram);
    }

    public String getName() {
        return name;
    }

    public int neededBalancedWeight() {
        if (!areAllSubProgramsBalanced()) {
            Program unbalancedSubProgram = getUnbalancedSubProgram();
            if (unbalancedSubProgram.neededBalancedWeight() == 0) {
                return unbalancedSubProgram.getOwnWeightFactor() - getNeededBalancedSubProgramWeight();
            } else {
                return unbalancedSubProgram.neededBalancedWeight();
            }
        } else {
            return 0;
        }
    }

    private int getOwnWeightFactor() {
        return weight;
    }

    private int getNeededBalancedSubProgramWeight() {
        Map<Integer, List<Program>> subProgramWeights = subPrograms.stream().collect(Collectors.groupingBy(Program::getWeight));
        return subProgramWeights.keySet().stream().max(Comparator.naturalOrder()).get() - subProgramWeights.keySet().stream().min(Comparator.naturalOrder()).get();
    }

    private boolean areAllSubProgramsBalanced() {
        Map<Integer, List<Program>> subProgramWeights = subPrograms.stream().collect(Collectors.groupingBy(Program::getWeight));
        return subProgramWeights.size() <= 1;
    }

    public int getWeight() {
        int result = getOwnWeightFactor();
        for (Program subProgram : subPrograms) {
            result += subProgram.getWeight();
        }
        return result;
    }

    private Program getUnbalancedSubProgram() {
        Map<Integer, List<Program>> subProgramWeights = subPrograms.stream().collect(Collectors.groupingBy(Program::getWeight));
        return subProgramWeights.values().stream().filter(programs -> programs.size() == 1).findFirst().get().get(0);
    }
}
