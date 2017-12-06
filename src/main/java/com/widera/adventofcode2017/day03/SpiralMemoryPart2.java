package com.widera.adventofcode2017.day03;

import java.awt.Point;

public class SpiralMemoryPart2 {

    private int [][] square = new int[20][20];
    private Point point;

    public SpiralMemoryPart2() {
        point = new Point(10, 10);
        square[point.x][point.y] = 1;
    }

    public int getNextStepValueAfter(int value) {
        Step step = new StepRight(point);

        while (value >= square[point.x][point.y]) {
            step = step.step();
            point = step.getPoint();
            calculatePoint(step.getPoint());
            System.out.println(square[point.x][point.y]);
        }

        for(int x = 0; x < square.length; x++) {
            for(int y = 0; y < square[x].length; y++) {
                System.out.print(square[x][y] + "\t");
            }
            System.out.println("");
        }

        return square[point.x][point.y];
    }

    void calculatePoint(Point point) {
        square[point.x][point.y] =
                  square[point.x-1][point.y-1]
                + square[point.x][point.y-1]
                + square[point.x+1][point.y-1]
                + square[point.x-1][point.y]
                + square[point.x+1][point.y]
                + square[point.x-1][point.y+1]
                + square[point.x][point.y+1]
                + square[point.x+1][point.y+1];
    }

    interface Step {
        Step step();
        Point getPoint();
    }

    class StepRight implements Step {

        private Point point;
        public StepRight(Point point) {
            this.point = point;
        }

        @Override
        public Step step() {
            point = new Point(point.x + 1, point.y);
            if(square[point.x][point.y-1] == 0) {
                return new StepUp(point);
            }
            return this;
        }

        @Override
        public Point getPoint() {
            return point;
        }

    }

    private class StepUp implements Step {
        private Point point;
        public StepUp(Point point) {
            this.point = point;
        }

        @Override
        public Step step() {
            point = new Point(point.x, point.y-1);
            if(square[point.x-1][point.y] == 0) {
                return new StepLeft(point);
            }
            return this;
        }

        @Override
        public Point getPoint() {
            return point;
        }
    }

    private class StepLeft implements Step {
        private Point point;
        public StepLeft(Point point) {
            this.point = point;
        }

        @Override
        public Step step() {
            point = new Point(point.x-1, point.y);
            if(square[point.x][point.y+1] == 0) {
                return new StepDown(point);
            }
            return this;
        }

        @Override
        public Point getPoint() {
            return point;
        }
    }

    private class StepDown implements Step {
        private Point point;
        public StepDown(Point point) {
            this.point = point;
        }

        @Override
        public Step step() {
            point = new Point(point.x, point.y+1);
            if(square[point.x+1][point.y] == 0) {
                return new StepRight(point);
            }
            return this;
        }

        @Override
        public Point getPoint() {
            return point;
        }
    }

}
