package com.nextstep.nextstepracingcar.domain;

public class Position {

    private final static byte MOVE_REFERENCE_VALUE = 4;
    private int move = 0;

    public void plusMove(int randomNum) {
        if (checkForwardCondition(randomNum)) {
            this.move++;
        }
    }

    private boolean checkForwardCondition(int randomNum) {
        return randomNum >= MOVE_REFERENCE_VALUE;
    }

    public int getMove() {
        return move;
    }
}
