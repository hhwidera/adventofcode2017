package com.widera.adventofcode2017.day14;

public class Grid {

    private final String word;

    public Grid(final String word) {
        this.word = word;
    }

    public int usedSquares() {
        int result = 0;
        char[][] grid = buildGrid();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                }
            }
        }
        return result;
    }

    private char[][] buildGrid() {
        char[][] grid = new char[128][128];
        for (int i = 0; i < 128; i++) {
            String bits = new BitKnotHash(word + "-" + i).bits();
            System.out.println(bits);
            grid[i] = bits.toCharArray();
        }
        return grid;
    }

    public int usedSquareGroups() {
        int groups = 0;
        char[][] grid = buildGrid();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    groups++;
                    grid = removeAllMembersForGroup(i, j, grid);
                }
            }
        }
        return groups;
    }

    private char[][] removeAllMembersForGroup(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        if (i < grid.length-1 && grid[i+1][j] == '1') {
            grid = removeAllMembersForGroup(i+1, j, grid);
        }
        if (i > 0 && grid[i-1][j] == '1') {
            grid = removeAllMembersForGroup(i-1, j, grid);
        }
        if (j < grid[i].length-1 && grid[i][j+1] == '1') {
            grid = removeAllMembersForGroup(i, j+1, grid);
        }
        if (j > 0 && grid[i][j-1] == '1') {
            grid = removeAllMembersForGroup(i, j-1, grid);
        }
        return grid;
    }
}
