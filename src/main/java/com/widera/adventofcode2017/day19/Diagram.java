package com.widera.adventofcode2017.day19;

public class Diagram {

    private enum Direction {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0);

        int x;
        int y;

        Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private final char[][] map;

    public Diagram(final String[] input) {
        this.map = new char[input[0].length()][input.length];
        for (int row = 0; row < input.length; row++) {
            char[] rowChars = input[row].toCharArray();
            map[row] = rowChars;
        }
    }

    public int stepsTotal() {
        return getPath().length();
    }

    public String lettersOnPath() {
        String letters = getPath();
        return letters.replace("-", ""). replace("+", "").replace("|", "");
    }

    private String getPath() {
        String letters = "";
        int x = findStartPoint();
        int y = 0;
        Direction direction = Direction.DOWN;

        boolean isMoving = true;
        while (isMoving) {
            letters += map[y][x];
            if (map[y][x] == ' ') {
                isMoving = false;
            } else if (map[y][x] == '+') {
                if (Direction.DOWN.equals(direction) || Direction.UP.equals(direction)) {
                    if (map[y][x - 1] == '-' || Character.isLetter(map[y][x - 1])) {
                        x--;
                        direction = Direction.LEFT;
                    } else if (map[y][x + 1] == '-' || Character.isLetter(map[y][x + 1])) {
                        x++;
                        direction = Direction.RIGHT;
                    } else {
                        throw new IllegalArgumentException(letters);
                    }
                } else {
                    if (map[y - 1][x] == '|' || Character.isLetter(map[y - 1][x])) {
                        y--;
                        direction = Direction.UP;
                    } else if (map[y + 1][x] == '|' || Character.isLetter(map[y + 1][x])) {
                        y++;
                        direction = Direction.DOWN;
                    } else {
                        throw new IllegalArgumentException(letters);
                    }
                }
            } else {
                x += direction.x;
                y += direction.y;
            }
        }
        return letters.replace(" ", "");
    }

    private int findStartPoint() {
        for (int x = 0; x < map[0].length; x++) {
            if (map[0][x] == '|') {
                return x;
            }
        }
        return -1;
    }
}
