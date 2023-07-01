package com.nextstep.nextstepracingcar.domain;

public class Move {

    private final static byte MOVE_REFERENCE_VALUE = 4;
    private int position = 0;

    public void plusMove(int randomNum) {
        if (checkForwardCondition(randomNum)) {
            this.position++;
        }
    }

    private boolean checkForwardCondition(int randomNum) {
        return randomNum >= MOVE_REFERENCE_VALUE;
    }

    public int getPosition() {
        return position;
    }
}
