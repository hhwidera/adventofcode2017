package com.widera.adventofcode2017.day07;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProgramTreeTest {

    @Test
    public void testTreeBuild() {
        ProgramTree tree = new ProgramTree();
        String[] programsAsString = new String[] {
                "pbga (66)",
                "xhth (57)",
                "ebii (61)",
                "havc (66)",
                "ktlj (57)",
                "fwft (72) -> ktlj, cntj, xhth",
                "qoyq (66)",
                "padx (45) -> pbga, havc, qoyq",
                "tknk (41) -> ugml, padx, fwft",
                "jptl (61)",
                "ugml (68) -> gyxo, ebii, jptl",
                "gyxo (61)",
                "cntj (57)"
        };

        tree.addProgramsAsString(programsAsString);

        assertEquals("tknk", tree.rootProgramName());
    }

    @Test
    public void testBalance() {
        ProgramTree tree = new ProgramTree();
        String[] programsAsString = new String[] {
                "pbga (66)",
                "xhth (57)",
                "ebii (61)",
                "havc (66)",
                "ktlj (57)",
                "fwft (72) -> ktlj, cntj, xhth",
                "qoyq (66)",
                "padx (45) -> pbga, havc, qoyq",
                "tknk (41) -> ugml, padx, fwft",
                "jptl (61)",
                "ugml (68) -> gyxo, ebii, jptl",
                "gyxo (61)",
                "cntj (57)"
        };

        tree.addProgramsAsString(programsAsString);
        assertEquals(60, tree.neededBalanceWeight());
    }

}