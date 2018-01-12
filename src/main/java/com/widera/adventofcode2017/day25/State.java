package com.widera.adventofcode2017.day25;

public interface State {

    int writeValue(int value);

    int move(int value);

    State nextState(int value);

    class A implements State {

        @Override
        public int writeValue(int value) {
            return value == 0 ? 1: 1;
        }

        @Override
        public int move(int value) {
            return value == 0 ? +1: -1;
        }

        @Override
        public State nextState(int value) {
            return value == 0 ? new B(): new E();
        }
    }

    class B implements State {

        @Override
        public int writeValue(int value) {
            return value == 0 ? 1: 1;
        }

        @Override
        public int move(int value) {
            return value == 0 ? +1: +1;
        }

        @Override
        public State nextState(int value) {
            return value == 0 ? new C(): new F();
        }
    }

    class C implements State {

        @Override
        public int writeValue(int value) {
            return value == 0 ? 1: 0;
        }

        @Override
        public int move(int value) {
            return value == 0 ? -1: +1;
        }

        @Override
        public State nextState(int value) {
            return value == 0 ? new D(): new B();
        }
    }

    class D implements State {

        @Override
        public int writeValue(int value) {
            return value == 0 ? 1: 0;
        }

        @Override
        public int move(int value) {
            return value == 0 ? +1: -1;
        }

        @Override
        public State nextState(int value) {
            return value == 0 ? new E(): new C();
        }
    }

    class E implements State {

        @Override
        public int writeValue(int value) {
            return value == 0 ? 1: 0;
        }

        @Override
        public int move(int value) {
            return value == 0 ? -1: +1;
        }

        @Override
        public State nextState(int value) {
            return value == 0 ? new A(): new D();
        }
    }

    class F implements State {

        @Override
        public int writeValue(int value) {
            return value == 0 ? 1: 1;
        }

        @Override
        public int move(int value) {
            return value == 0 ? +1: +1;
        }

        @Override
        public State nextState(int value) {
            return value == 0 ? new A(): new C();
        }
    }
}
